package com.ensah.core.web.controllers;

import com.ensah.core.bo.*;
import com.ensah.core.dao.IEnseignantRepository;
import com.ensah.core.dto.ElementPedagogiqueForm;
import com.ensah.core.services.*;
import com.ensah.core.dto.ExamenForm;
import com.ensah.core.services.impl.ElementPedagogiqueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/examens")
public class ExamenController {

    @Autowired
    private ExamenService examenService;

    @Autowired
    private SemestreService semestreService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private SalleService salleService;
    @Autowired
    private TypeExamenService typeExamenService;

    @Autowired
    private ElementPedagogiqueService elementPedagogiqueService;
    @Autowired
    private IEnseignantRepository enseignantRepository;
    @Autowired
    private EnseignantService enseignantService;

    @GetMapping("/nouveau")
    public String showAddForm(Model model) {
        ExamenForm examenForm = new ExamenForm();
        model.addAttribute("examenForm", examenForm);
        model.addAttribute("sessions", sessionService.getAllSessions());
        model.addAttribute("semestres", semestreService.getAllSemestres());
        model.addAttribute("salles", salleService.getAllSalles());
        model.addAttribute("typesExamens", typeExamenService.getAllTypeExamens());
        model.addAttribute("typesElements", elementPedagogiqueService.getTypesElements());
        model.addAttribute("elementsPedagogiques", elementPedagogiqueService.getAllElements());
        model.addAttribute("enseignants", enseignantService.getAllEnseignants()); // Ajouté
        return "examens/add";
    }


    @PostMapping("/nouveau")
    public String addExamen(@ModelAttribute("examenForm") @Valid ExamenForm form, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("sessions", sessionService.getAllSessions());
            model.addAttribute("semestres", semestreService.getAllSemestres());
            model.addAttribute("salles", salleService.getAllSalles());
            model.addAttribute("typesExamens", typeExamenService.getAllTypeExamens());
            model.addAttribute("typesElements", elementPedagogiqueService.getTypesElements());
            model.addAttribute("elementsPedagogiques", elementPedagogiqueService.getAllElements());
            model.addAttribute("enseignants", enseignantService.getAllEnseignants());
            return "examens/add";
        }

        Examen examen = new Examen();
        examen.setAnneeUniversitaire(form.getAnneeUniversitaire());
        Session session = sessionService.getSessionById(form.getSessionId());
        Semestre semestre = semestreService.getSemestreById(form.getSemestreId());
        TypeExamen typeExamen = typeExamenService.getTypeExamenById(form.getTypeExamenId());
        ElementPedagogique elementPedagogique = elementPedagogiqueService.getElementById(form.getElementPedagogiqueId());

        if (elementPedagogique != null) {
            examen.setCoordonnateur(elementPedagogique.getCoordonnateur().getNom() + " " + elementPedagogique.getCoordonnateur().getPrenom());
        }

        examen.setDate(form.getDate());
        examen.setHeureDebut(form.getHeureDebut());
        examen.setDureePrevue(form.getDureePrevue());

        if (session != null && semestre != null && typeExamen != null && elementPedagogique != null) {
            examen.setSession(session);
            examen.setSemestre(semestre);
            examen.setType(typeExamen);
            examen.setElementPedagogique(elementPedagogique);

            // Ajout des enseignants sélectionnés à l'examen
            List<Enseignant> selectedEnseignants = enseignantService.getAllEnseignantsByIds(form.getEnseignantsIds());
            examen.setEnseignants(selectedEnseignants);

            // Enregistrer l'examen
            examenService.saveExamen(examen);

            // Gérer les surveillants et les salles
            Salle salle = salleService.getSalleById(form.getSalleId());
            if (salle != null) {
                SalleSurveillant salleSurveillant = new SalleSurveillant();
                salleSurveillant.setSalle(salle);
                salleSurveillant.setNombreSurveillants(form.getNombreSurveillants());
                salleSurveillant.setExamen(examen);
                salleService.saveSalleSurveillant(salleSurveillant);
            }

            return "redirect:/examens";
        }

        return "examens/add";
    }


    @GetMapping
    public String listElements(Model model) {
        model.addAttribute("examens", examenService.getAllExamens());
        return "examens/planExams";
    }
    @GetMapping("/elementPedagogique/{id}")
    @ResponseBody
    public ResponseEntity<?> getElementPedagogique(@PathVariable("id") Long id) {
        ElementPedagogique element = elementPedagogiqueService.getElementById(id);
        if (element == null) {
            return ResponseEntity.notFound().build();
        }
        String coordonnateur = element.getCoordonnateur().getNom() + " " + element.getCoordonnateur().getPrenom();
        return ResponseEntity.ok(coordonnateur);
    }
    @GetMapping("/{id}/modifier")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Examen examen = examenService.getExamenById(id);
        model.addAttribute("examen", examen);
        return "examens/modify";
    }

    @PostMapping("/{id}/modifier")
    public String updateElement(@PathVariable("id") Long id, ExamenForm form, @RequestParam("epreuve") MultipartFile epreuveFile, @RequestParam("pv") MultipartFile pvFile) {
        Examen examen = examenService.getExamenById(id);
        try {
            examen.setEpreuve(form.getEpreuve().getBytes());
            examen.setPv(form.getPv().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            // Gérer les erreurs de téléchargement de fichiers
        }
        examen.setRapportTextuel(form.getRapportTextuel());
        examenService.saveExamen(examen);
        return "redirect:/examens";
    }
    private byte[] convertMultipartFileToByteArray(MultipartFile file) throws IOException {
        return StreamUtils.copyToByteArray(file.getInputStream());
    }

}
