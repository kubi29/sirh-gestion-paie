package dev.paie.web.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Grade;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {
	
	@Autowired
	private GradeRepository grades;

	@Autowired
	private ProfilRemunerationRepository profils;
	
	@Autowired
	private EntrepriseRepository entreprises;
	
	@Autowired
	private RemunerationEmployeRepository employes;
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
	ModelAndView mv = new ModelAndView();
	mv.setViewName("employes/creerEmploye");
	mv.addObject("prefixMatricule","M00");
	mv.addObject("entreprises", entreprises.findAll());
	mv.addObject("grades",grades.findAll());
	mv.addObject("profils",profils.findAll());
	return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/lister")
	public ModelAndView AjoutEmploye(

			@RequestParam("matricule") String matricule,
			@RequestParam("profil") Integer profil,
			@RequestParam("grade") Integer grade,
			@RequestParam("entreprise") Integer entreprise) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listEmployes");
		
		RemunerationEmploye remunerationEmploye= new RemunerationEmploye();
		
		remunerationEmploye.setMatricule(matricule);
		remunerationEmploye.setEntreprise(entreprises.findOne(entreprise));
		remunerationEmploye.setProfilRemuneration(profils.findOne(profil));
		remunerationEmploye.setGrade(grades.findOne(grade));
		remunerationEmploye.setDateHeureCreation(LocalDateTime.now());

		employes.save(remunerationEmploye);

		mv.addObject("employes",employes.findAll());
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listeEmploye(){
		
			ModelAndView mv = new ModelAndView();
			
			mv.setViewName("employes/listEmployes");
			mv.addObject("employes", employes.findAll());

		return mv;
	}
}
