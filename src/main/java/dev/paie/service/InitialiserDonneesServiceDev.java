package dev.paie.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import static java.time.temporal.TemporalAdjusters.*;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.entite.Utilisateur;
import dev.paie.entite.Utilisateur.ROLES;
import dev.paie.repository.GradeRepository;
@Import(ServicesConfig.class)
@Service
@EnableTransactionManagement
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@Autowired
	private EntityManager em;

	@Autowired
	GradeRepository grades;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	@Override
	public void initialiser() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"cotisations-imposables.xml", 
				"cotisations-non-imposables.xml",
				"entreprises.xml",
				"grades.xml", 
				"profils-remuneration.xml");
		Stream.of(Cotisation.class, Entreprise.class, Grade.class, ProfilRemuneration.class)
		.forEach(classe -> 
		context.getBeansOfType(classe)
		.values()
		.stream()
		.forEach(object -> em.persist(object))
		);		

		for (int i = 1; i <= 12; i++) {

			LocalDate init = LocalDate.of(2017, i, 1);

			em.persist(new Periode(init, init.with(lastDayOfMonth())));

		}
		
		List<RemunerationEmploye> employes = new ArrayList<>();

		employes.add(new RemunerationEmploye("M0111", grades.findAll().get(0), LocalDateTime.of(2017, 6, 1, 10, 16)));
		employes.add(new RemunerationEmploye("M0112", grades.findAll().get(1), LocalDateTime.of(2017, 6, 1, 10, 17)));
		employes.add(new RemunerationEmploye("M0111", grades.findAll().get(0), LocalDateTime.of(2017, 6, 1, 10, 17)));
		employes.add(new RemunerationEmploye("M0113", grades.findAll().get(1), LocalDateTime.of(2017, 6, 1, 10, 18)));

		employes.stream().forEach(employe -> em.persist(employe));

		List<Utilisateur> utilisateurs = new ArrayList<>();
		
		utilisateurs.add(new Utilisateur( "kubi", passwordEncoder.encode("bzh")  ,  true,  Utilisateur.ROLES.ROLE_ADMINISTRATEUR));
		utilisateurs.add(new Utilisateur( "one",  passwordEncoder.encode("piece") ,  true,  Utilisateur.ROLES.ROLE_ADMINISTRATEUR));
		utilisateurs.add(new Utilisateur( "toto", passwordEncoder.encode("111") ,  true,  Utilisateur.ROLES.ROLE_UTILISATEUR));
		utilisateurs.add(new Utilisateur( "zoro", passwordEncoder.encode("333") ,  true,  Utilisateur.ROLES.ROLE_UTILISATEUR));
		
		utilisateurs.stream().forEach(utilisateur -> em.persist(utilisateur));
		
		
		context.close();

	}
}
