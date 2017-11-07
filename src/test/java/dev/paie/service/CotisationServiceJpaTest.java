package dev.paie.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;

@ContextConfiguration(classes = { DataSourceMySQLConfig.class , ServicesConfig.class})
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)
@EnableTransactionManagement
@Transactional
public class CotisationServiceJpaTest {


	@PersistenceContext private EntityManager em;
	
	@Autowired private CotisationService cotisationService;
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
	// TODO sauvegarder une nouvelle cotisation
		cotisationService.sauvegarder(new Cotisation("C007","COTA",new BigDecimal(0.5),new BigDecimal(1.75)));
	// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation via la méthode lister
	/*	assertThat(cotisationService.lister().size()).isEqualTo(1);
	// TODO modifier une cotisation
		cotisationService.mettreAJour(new Cotisation(1, "C001", "TOTO",new BigDecimal(12.5),new BigDecimal(6.89)));
	// TODO vérifier que les modifications sont bien prises en compte via la méthode lister
		assertThat(cotisationService.lister().get(0).getCode(), equalTo("C001"));
		assertThat(cotisationService.lister().get(0).getLibelle(), equalTo("TOTO"));
		assertTrue(cotisationService.lister().get(0).getTauxSalarial().compareTo(new BigDecimal("12.5")) == 0);
		assertThat(cotisationService.lister().get(0).getTauxPatronal(), equalTo(6.89));*/
	}
	
}
