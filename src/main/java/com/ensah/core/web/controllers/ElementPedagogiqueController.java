package com.ensah.core.web.controllers;

import com.ensah.core.bo.ElementPedagogique;
import com.ensah.core.bo.Niveau;
import com.ensah.core.bo.Enseignant;
import com.ensah.core.bo.TypeElement;
import com.ensah.core.dto.ElementPedagogiqueForm;

import com.ensah.core.services.NiveauService;
import com.ensah.core.services.EnseignantService;
import com.ensah.core.services.TypeElementService;
import com.ensah.core.services.impl.ElementPedagogiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/elements-pedagogiques")
public class ElementPedagogiqueController {

    @Autowired
    private ElementPedagogiqueService elementPedagogiqueService;

    @Autowired
    private NiveauService niveauService;

    @Autowired
    private EnseignantService enseignantService;

    @Autowired
    private TypeElementService typeElementService;

    @GetMapping
    public String listElements(Model model) {
        model.addAttribute("elementsPedagogiques", elementPedagogiqueService.getAllElements());
        return "elements-pedagogiques/list";
    }

    @GetMapping("/nouveau")
    public String showAddForm(Model model) {
        model.addAttribute("elementPedagogiqueForm", new ElementPedagogiqueForm());
        model.addAttribute("niveaux", niveauService.getAllNiveaux());
        model.addAttribute("enseignants", enseignantService.getAllEnseignants());
        model.addAttribute("typesElements", typeElementService.getAllTypesElements());
        return "elements-pedagogiques/add";
    }

    @PostMapping("/nouveau")
    public String addElement(ElementPedagogiqueForm form) {
        ElementPedagogique element = new ElementPedagogique();
        element.setTitre(form.getTitre());

        Niveau niveau = niveauService.getNiveauById(form.getNiveauId());
        Enseignant coordonnateur = enseignantService.getEnseignantById(form.getCoordonnateurId());
        TypeElement typeElement = typeElementService.getTypeElementById(form.getTypeElementId());

        element.setNiveau(niveau);
        element.setCoordonnateur(coordonnateur);
        element.setTypeElement(typeElement);

        elementPedagogiqueService.saveElement(element);
        return "redirect:/elements-pedagogiques";
    }
    @GetMapping("/{id}/modifier")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        ElementPedagogique element = elementPedagogiqueService.getElementById(id);
        ElementPedagogiqueForm form = new ElementPedagogiqueForm();
        form.setId(element.getId());
        form.setTitre(element.getTitre());
        form.setNiveauId(element.getNiveau().getId());
        form.setCoordonnateurId(element.getCoordonnateur().getIdPersonne());
        form.setTypeElementId(element.getTypeElement().getId());

        model.addAttribute("elementPedagogiqueForm", form);
        model.addAttribute("niveaux", niveauService.getAllNiveaux());
        model.addAttribute("enseignants", enseignantService.getAllEnseignants());
        model.addAttribute("typesElements", typeElementService.getAllTypesElements());
        return "elements-pedagogiques/edit";
    }

    @PostMapping("/{id}/modifier")
    public String updateElement(@PathVariable("id") Long id, ElementPedagogiqueForm form) {
        ElementPedagogique element = elementPedagogiqueService.getElementById(id);
        element.setTitre(form.getTitre());
        Niveau niveau = niveauService.getNiveauById(form.getNiveauId());
        element.setNiveau(niveau);
        Enseignant coordonnateur = enseignantService.getEnseignantById(form.getCoordonnateurId());
        element.setCoordonnateur(coordonnateur);
        TypeElement typeElement = typeElementService.getTypeElementById(form.getTypeElementId());
        element.setTypeElement(typeElement);

        elementPedagogiqueService.saveElement(element);
        return "redirect:/elements-pedagogiques";
    }
    @GetMapping("/{id}/supprimer")
    public String deleteElement(@PathVariable("id") Long id) {
        elementPedagogiqueService.deleteElementById(id);
        return "redirect:/elements-pedagogiques";
    }


}
