package dev.paie.service;

import static org.assertj.core.api.Assertions.filter;

import java.math.BigDecimal;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Grade;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService{

	@Autowired
	PaieUtils paieUtils;
	
	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		
		Grade grade = bulletin.getRemunerationEmploye().getGrade();
		
		ResultatCalculRemuneration resultat = new ResultatCalculRemuneration();
		
		resultat.setSalaireDeBase(paieUtils.formaterBigDecimal(grade.getNbHeuresBase().multiply(grade.getTauxBase())));
		
		resultat.setSalaireBrut(paieUtils.formaterBigDecimal(new BigDecimal(resultat.getSalaireDeBase()).add(bulletin.getPrimeExceptionnelle())));
		
		resultat.setTotalRetenueSalarial(paieUtils.formaterBigDecimal(
				bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()
				.stream().filter(taux -> taux.getTauxSalarial() != null)
				.map(taux -> taux.getTauxSalarial().multiply(new BigDecimal(resultat.getSalaireBrut())))
				.reduce(BigDecimal.ZERO ,BigDecimal::add)
				));
		
		resultat.setTotalCotisationsPatronales(paieUtils.formaterBigDecimal(
				bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()
				.stream().filter(taux -> taux.getTauxPatronal() != null)
				.map(taux -> taux.getTauxPatronal().multiply(new BigDecimal(resultat.getSalaireBrut())))
				.reduce(BigDecimal.ZERO ,BigDecimal::add)
				));
		
		resultat.setNetImposable(paieUtils.formaterBigDecimal(new BigDecimal(resultat.getSalaireBrut())
				.subtract(new BigDecimal(resultat.getTotalRetenueSalarial()))));
		
		resultat.setNetAPayer(paieUtils.formaterBigDecimal(new BigDecimal(resultat.getNetImposable())
				.subtract(
						bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables()
						.stream().filter(taux -> taux.getTauxSalarial() != null)
						.map(taux -> taux.getTauxSalarial().multiply(new BigDecimal(resultat.getSalaireBrut())))
						.reduce(BigDecimal.ZERO ,BigDecimal::add)
						)
				));
						
					
		
		return resultat;
	}

}
