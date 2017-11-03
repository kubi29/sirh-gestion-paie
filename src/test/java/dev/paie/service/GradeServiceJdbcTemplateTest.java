package dev.paie.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


import dev.paie.entite.Grade;
import dev.paie.spring.DataSourceMySQLConfig;

@ContextConfiguration(classes = { DataSourceMySQLConfig.class})
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {

	@Autowired private GradeService gradeService;
	
	
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
	// TODO sauvegarder un nouveau grade
	//	gradeService.sauvegarder(new Grade (1 , "M01" , new BigDecimal(25) ,new BigDecimal(11) ));
	// TODO vérifier qu'il est possible de récupérer le nouveau grade via la méthode lister
		assertThat(gradeService.lister());
	// TODO modifier un grade
		gradeService.mettreAJour(new Grade (1 , "M02" , new BigDecimal(06) ,new BigDecimal(0.5) ));
	// TODO vérifier que les modifications sont bien prises en compte via la méthode lister
		assertThat(gradeService.lister().get(0).getCode(), equalTo("M02"));
		assertThat(gradeService.lister().get(0).getNbHeuresBase(), equalTo("06.00"));
		assertThat(gradeService.lister().get(0).getTauxBase(), equalTo("0.50"));
	}
	
}
