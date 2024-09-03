package com.ensah.core.web.controllers;

import com.ensah.core.dao.IDepartementRepository;
import com.ensah.core.dao.IEnseignantRepository;
import com.ensah.core.dao.IFiliereRepository;
import com.ensah.core.dao.IGroupeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.ensah.core.bo.*;
import com.ensah.core.services.IPersonneService;
import com.ensah.core.utils.ExcelExporter;
import com.ensah.core.web.models.PersonModel;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/admin")
public class PersonneMngController {

	@Autowired
	private IPersonneService personService;

	@Autowired
	private HttpSession httpSession;
	@Autowired
	private IEnseignantRepository enseignantRepository;
	@Autowired
	private IDepartementRepository departementRepository;
	@Autowired
	private IFiliereRepository filiereRepository;


	@Autowired
	private IGroupeRepository groupRepository;


	/** Utilisé pour la journalisation */
	private Logger LOGGER = LoggerFactory.getLogger(getClass());


	public PersonneMngController() {




	}

	@GetMapping(value = "showForm")
	public String showForm(@RequestParam int typePerson, Model model) {

		PersonModel pmodel = new PersonModel(typePerson);
		model.addAttribute("personModel", pmodel);

		// Nous avons choisit d'utiliser une classe modèle personnalisée
		// définie par PersonModel pour une meilleur flexibilité

		List<Personne> persons = personService.getAllPersonnes();
		List<PersonModel> modelPersons = new ArrayList<PersonModel>();
		// On copie les données des personnes vers le modèle
		for (int i = 0; i < persons.size(); i++) {
			PersonModel pm = new PersonModel();
			if (persons.get(i) instanceof Enseignant) {

				BeanUtils.copyProperties((Enseignant) persons.get(i), pm);
				pm.setTypePerson(PersonModel.TYPE_PROF);
				modelPersons.add(pm);
			} else if (persons.get(i) instanceof CadreAdministrateur) {
				BeanUtils.copyProperties((CadreAdministrateur) persons.get(i), pm);
				pm.setTypePerson(PersonModel.TYPE_CADRE_ADMIN);
				modelPersons.add(pm);
			}
		}

		// Mettre la liste des personnes dans le modèle de Spring MVC
		model.addAttribute("personList", modelPersons);

		return "admin/form";
	}

	@RequestMapping(value = "addPerson", method = RequestMethod.POST)
	public String process(@Valid @ModelAttribute("personModel") PersonModel person, BindingResult bindingResult,
						  Model model, HttpServletRequest rq) {

		// En cas d'erreur de validation
		if (bindingResult.hasErrors()) {
			// rq.setAttribute("typePerson", +person.getTypePerson());
			return "admin/form";
		}

		// Copier les données de l'objet PersonModel vers l'objet Etudiant (cas du
		// formulaire de l'étudiant)

		// Copier les données de l'objet PersonModel vers l'objet Enseignant (cas du
		// formulaire de l'Enseignant)

		if (person.getTypePerson() == PersonModel.TYPE_PROF) {
			Enseignant prof = new Enseignant();
			BeanUtils.copyProperties(person, prof);
			personService.addPersonne(prof);

		}
		// Copier les données de l'objet PersonModel vers l'objet CadreAdministrateur
		// (cas du
		// formulaire de CadreAdministrateur)
		else if (person.getTypePerson() == PersonModel.TYPE_CADRE_ADMIN) {
			CadreAdministrateur ca = new CadreAdministrateur();
			BeanUtils.copyProperties(person, ca);
			personService.addPersonne(ca);

		}

		// rediriger vers l'action shwoForm avec le meme type de personne
		return "redirect:/admin/showForm?typePerson=" + person.getTypePerson();
	}

	@RequestMapping(value = "updatePersonForm/{idPerson}", method = RequestMethod.GET)
	public String updatePersonForm(@PathVariable("idPerson") int idPerson, Model model) {

		// On reoit comme paramètre l'id de la personne à mettre à jour
		Personne utl = personService.getPersonneById(Long.valueOf(idPerson));

		// On construit le modèle
		PersonModel pm = new PersonModel();

		// En fonction due type de l'utilisateur à modifier
		// Ceci va nous pemettre d'afficher un formulaire adapté
		// slon le type de la personne
		if (utl instanceof Enseignant) {
			BeanUtils.copyProperties((Enseignant) utl, pm);
			pm.setTypePerson(PersonModel.TYPE_PROF);
		} else if (utl instanceof CadreAdministrateur) {
			BeanUtils.copyProperties((CadreAdministrateur) utl, pm);
			pm.setTypePerson(PersonModel.TYPE_CADRE_ADMIN);
		}

		// Initialiser le modele avec la personne
		model.addAttribute("personModel", pm);

		return "admin/updateForm";
	}

	@RequestMapping(value = "serachPerson", method = RequestMethod.GET)
	public String serachPerson(@RequestParam String cin, Model model) {

		// On reoit comme paramètre l'id de la personne à mettre à jour
		Personne utl = personService.getPersonneByCin(cin);

		if (utl == null) {

			// Initialiser le modele avec la personne
			model.addAttribute("personModel", new ArrayList<PersonModel>());
		} else {

			// On construit le modèle
			PersonModel pm = new PersonModel();

			// En fonction due type de l'utilisateur à modifier
			// Ceci va nous pemettre d'afficher un formulaire adapté
			// slon le type de la personne
			if (utl instanceof Enseignant) {
				BeanUtils.copyProperties((Enseignant) utl, pm);
				pm.setTypePerson(PersonModel.TYPE_PROF);
			} else if (utl instanceof CadreAdministrateur) {
				BeanUtils.copyProperties((CadreAdministrateur) utl, pm);
				pm.setTypePerson(PersonModel.TYPE_CADRE_ADMIN);

			}
			List<PersonModel> modelPersons = new ArrayList<PersonModel>();
			modelPersons.add(pm);
			// Initialiser le modele avec la personne
			model.addAttribute("personList", modelPersons);
		}
		return "admin/listPersons";
	}

	@RequestMapping("updatePerson")
	public String updatePerson(@Valid @ModelAttribute("personModel") PersonModel person, BindingResult bindingResult,
							   Model model) {

		// En cas d'erreur
		if (bindingResult.hasErrors()) {

			return "admin/updateForm";
		}

		// On copie les données du modèle vers l'objet métier puis on appel le service
		// pour faire la mise à jour
		if (person.getTypePerson() == PersonModel.TYPE_PROF) {
			Enseignant prof = new Enseignant();
			BeanUtils.copyProperties(person, prof);
			personService.updatePersonne(prof);

		} else if (person.getTypePerson() == PersonModel.TYPE_CADRE_ADMIN) {
			CadreAdministrateur ca = new CadreAdministrateur();
			BeanUtils.copyProperties(person, ca);
			personService.updatePersonne(ca);

		}

		// Mettre le message de succès dans le modèle
		model.addAttribute("msg", "Opération effectuée avec succès");

		return "admin/updateForm";
	}

	@RequestMapping("managePersons")
	public String managePersons(Model model) {

		List<Personne> persons = personService.getAllPersonnes();
		List<PersonModel> modelPersons = new ArrayList<PersonModel>();

		// Copier les objets metier vers PersonModel plus flexible
		for (int i = 0; i < persons.size(); i++) {
			PersonModel pm = new PersonModel();
			if (persons.get(i) instanceof Enseignant) {
				BeanUtils.copyProperties((Enseignant) persons.get(i), pm);
				pm.setTypePerson(PersonModel.TYPE_PROF);
				modelPersons.add(pm);
			} else if (persons.get(i) instanceof CadreAdministrateur) {
				BeanUtils.copyProperties((CadreAdministrateur) persons.get(i), pm);
				pm.setTypePerson(PersonModel.TYPE_CADRE_ADMIN);
				modelPersons.add(pm);
			}
		}

		model.addAttribute("personList", modelPersons);

		return "admin/listPersons";
	}

	@RequestMapping(value = "deletePerson/{idPerson}", method = RequestMethod.GET)
	public String delete(@PathVariable int idPerson) {

		personService.deletePersonne(Long.valueOf(idPerson));

		return "redirect:/admin/managePersons";
	}

	@GetMapping("exportPersons")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);

		List<Personne> persons = personService.getAllPersonnes();

		ExcelExporter excelExporter = personService.preparePersonneExport(persons);

		excelExporter.export(response);
	}



	@RequestMapping(value = "createGroup", method = RequestMethod.GET)
	public String createGroup(Model model) {
		GroupForm groupForm = new GroupForm();
		model.addAttribute("groupForm", groupForm);

		// Récupérer la liste de tous les enseignants
		List<Enseignant> allEnseignants = enseignantRepository.findAll();
		model.addAttribute("allEnseignants", allEnseignants);

		// Récupérer la liste des départements
		List<Departement> departements = departementRepository.findAll();
		model.addAttribute("departements", departements);

		List<Filiere> filieres = filiereRepository.findAll();
		model.addAttribute("filieres", filieres);

		return "admin/createGroupForm";
	}
	@RequestMapping(value = "createGroup", method = RequestMethod.POST)
	public String processCreateGroup(@ModelAttribute("groupForm") GroupForm groupForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "admin/createGroupForm";
		}

		// Log pour vérifier les données reçues
		System.out.println("Nom du groupe : " + groupForm.getNomGroupe());
		System.out.println("Type du groupe : " + groupForm.getTypeGroupe());
		System.out.println("ID Filiere : " + groupForm.getFiliereId());
		System.out.println("ID Departement : " + groupForm.getDepartementId());
		System.out.println("Enseignants IDs : " + groupForm.getEnseignantsIds());

		if (groupForm.getEnseignantsIds() == null || groupForm.getEnseignantsIds().isEmpty()) {
			System.err.println("Erreur : La liste des identifiants des enseignants est nulle ou vide.");
			return "admin/createGroupForm"; // Ou afficher un message d'erreur approprié
		}

		Groupe newGroup = new Groupe();
		newGroup.setNomGroupe(groupForm.getNomGroupe());
		newGroup.setTypeGroupe(groupForm.getTypeGroupe());

		Filiere filiere = null;
		if (groupForm.getFiliereId() != null) {
			filiere = filiereRepository.findById(groupForm.getFiliereId()).orElse(null);
		}
		newGroup.setFiliere(filiere);

		Departement departement = null;
		if (groupForm.getDepartementId() != null) {
			departement = departementRepository.findById(groupForm.getDepartementId()).orElse(null);
		}
		newGroup.setDepartement(departement);

		// Sauvegarder le groupe d'abord
		groupRepository.save(newGroup);

		List<Enseignant> selectedEnseignants = enseignantRepository.findAllById(groupForm.getEnseignantsIds());

		// Ajouter les enseignants au groupe et sauvegarder à nouveau
		newGroup.setEnseignantss(new HashSet<>(selectedEnseignants));
		groupRepository.save(newGroup);

		// Mettre à jour les groupes de chaque enseignant sélectionné
		for (Enseignant enseignant : selectedEnseignants) {
			enseignant.getGroupes().add(newGroup);
			enseignantRepository.save(enseignant);
		}

		return "admin/adminHome";
	}

	@RequestMapping(value = "viewGroup/{id}", method = RequestMethod.GET)
	public String viewGroup(@PathVariable("id") Long groupId, Model model) {
		Groupe group = groupRepository.findById(groupId).orElse(null);
		if (group == null) {
			return "error/404"; // ou une autre page d'erreur appropriée
		}
		model.addAttribute("group", group);
		model.addAttribute("enseignants", group.getEnseignantss());
		return "admin/viewGroup";
	}

	@RequestMapping(value = "listGroups", method = RequestMethod.GET)
	public String listGroups(Model model) {
		List<Groupe> groups = groupRepository.findAll();
		model.addAttribute("groups", groups);
		return "admin/listGroups";
	}
	@RequestMapping(value = "editGroup/{id}", method = RequestMethod.GET)
	public String editGroup(@PathVariable("id") Long groupId, Model model) {
		Groupe group = groupRepository.findById(groupId).orElse(null);
		if (group == null) {
			return "error/404";
		}

		GroupForm groupForm = new GroupForm();
		groupForm.setIdGroupe(group.getIdGroupe());
		groupForm.setNomGroupe(group.getNomGroupe());
		groupForm.setTypeGroupe(group.getTypeGroupe());

		if (group.getDepartement() != null) {
			groupForm.setDepartementId(group.getDepartement().getIdDepartement());
		}

		if (group.getFiliere() != null) {
			groupForm.setFiliereId(group.getFiliere().getIdFiliere());
		}

		model.addAttribute("groupForm", groupForm);
		model.addAttribute("departements", departementRepository.findAll());
		model.addAttribute("filieres", filiereRepository.findAll());
		model.addAttribute("allEnseignants", enseignantRepository.findAll());

		return "admin/editGroupForm";
	}

	@RequestMapping(value = "editGroup", method = RequestMethod.POST)
	public String processEditGroup(@ModelAttribute("groupForm") GroupForm groupForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "admin/editGroupForm";
		}

		Groupe group = groupRepository.findById(groupForm.getIdGroupe()).orElse(null);
		if (group == null) {
			return "error/404";
		}

		group.setNomGroupe(groupForm.getNomGroupe());
		group.setTypeGroupe(groupForm.getTypeGroupe());

		if (groupForm.getTypeGroupe().equals("Filiere")) {
			Filiere filiere = null;
			if (groupForm.getFiliereId() != null) {
				filiere = filiereRepository.findById(groupForm.getFiliereId()).orElse(null);
			}
			group.setFiliere(filiere);
			group.setDepartement(null); // S'assurer que le département est null pour un groupe de type Filière
		} else {
			Departement departement = null;
			if (groupForm.getDepartementId() != null) {
				departement = departementRepository.findById(groupForm.getDepartementId()).orElse(null);
			}
			group.setDepartement(departement);
			group.setFiliere(null); // S'assurer que la filière est null pour un groupe de type Département
		}

		groupRepository.save(group);

		return "redirect:/admin/listGroups";
	}

	@RequestMapping(value = "deleteGroup/{id}", method = RequestMethod.GET)
	public String deleteGroup(@PathVariable("id") Long groupId) {
		Groupe group = groupRepository.findById(groupId).orElse(null);
		if (group != null) {
			// Récupérer tous les enseignants liés au groupe
			List<Enseignant> enseignants = new ArrayList<>(group.getEnseignantss());

			// Supprimer les liens entre le groupe et les enseignants dans la table enseignant_groupe
			for (Enseignant enseignant : enseignants) {
				enseignant.getGroupes().remove(group);
				enseignantRepository.save(enseignant);
			}

			// Supprimer le groupe
			groupRepository.delete(group);
		}
		return "redirect:/admin/listGroups";
	}
}
