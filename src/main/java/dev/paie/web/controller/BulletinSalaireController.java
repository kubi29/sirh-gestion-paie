package dev.paie.web.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/bulletins")
public class BulletinSalaireController {

	@Autowired
	private PeriodeRepository periodes;

	@Autowired
	private RemunerationEmployeRepository employes;

	@Autowired
	private BulletinSalaireRepository bulletins;

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
			@RequestParam("primeExceptionnelle") String primeExceptionnelle) {
		
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

}
