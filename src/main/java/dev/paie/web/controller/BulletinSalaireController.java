package dev.paie.web.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.CalculerRemunerationService;
import dev.paie.service.CalculerRemunerationServiceSimple;

@Controller
@RequestMapping("/bulletins")
public class BulletinSalaireController {

	@Autowired
	private PeriodeRepository periodes;

	@Autowired
	private RemunerationEmployeRepository employes;

	@Autowired
	private BulletinSalaireRepository bulletins;

	@Autowired
	private CalculerRemunerationServiceSimple remuneration;
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		mv.addObject("periodes", periodes.findAll());
		mv.addObject("employes", employes.findAll());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/lister")

	public ModelAndView ajoutBulletin(
			@RequestParam("periode") Integer periode, 
			@RequestParam("employe") Integer employe,
			@RequestParam("primeExceptionnelle") String primeExceptionnelle
			){
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listBulletin");
		
		BulletinSalaire bulletinSalaire = new BulletinSalaire();

		bulletinSalaire.setPeriode(periodes.findOne(periode));
		bulletinSalaire.setRemunerationEmploye(employes.findOne(employe));
		bulletinSalaire.setPrimeExceptionnelle(new BigDecimal(primeExceptionnelle));
		bulletins.save(bulletinSalaire);

		mv.addObject("bulletins", bulletins.findAll());
		
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listBulletin");

		mv.addObject("bulletins", bulletins.findAll());

		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/visualiser/{id}")
	@Transactional
	public ModelAndView visualiserBulletin(
			@PathVariable Integer id){
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/visualiserbulletin");
		
		BulletinSalaire bulletin = bulletins.findOne(id);

		ResultatCalculRemuneration resultat = remuneration.calculer(bulletin);

		List<Cotisation> cotisationsN = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables();

		List<Cotisation> cotisations = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables();

		
		
		mv.addObject("bulletin", bulletin);
		mv.addObject("remuneration", resultat );
		mv.addObject("cotisationsN", cotisationsN );
		mv.addObject("cotisations", cotisations );

		return mv;
	}

}
