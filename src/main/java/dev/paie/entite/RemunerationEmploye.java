package dev.paie.entite;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RemunerationEmploye {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="MATRICULE",length = 10 ,nullable =false )
	private String matricule;
	@ManyToOne
	@JoinColumn(name = "ID_ENTREP_REMUN")
	private Entreprise entreprise;
	@ManyToOne
	@JoinColumn(name = "ID_PROFIL_REMUN")
	private ProfilRemuneration profilRemuneration;
	@ManyToOne
	@JoinColumn(name = "ID_GRADE_REMUN")
	private Grade grade;
	
	private LocalDateTime dateHeureCreation;
	
	
	public RemunerationEmploye() {
		super();
	}

	public RemunerationEmploye(String matricule, Entreprise entreprise, ProfilRemuneration profilRemuneration,Grade grade) {

		super();
		this.matricule = matricule;
		this.entreprise = entreprise;
		this.profilRemuneration = profilRemuneration;
		this.grade = grade;
	}

	
	public RemunerationEmploye(String matricule, Grade grade, LocalDateTime dateHeureCreation) {

		super();
		this.matricule = matricule;
		this.grade = grade;
		this.dateHeureCreation = dateHeureCreation;

	}
	
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	public ProfilRemuneration getProfilRemuneration() {
		return profilRemuneration;
	}
	public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		this.profilRemuneration = profilRemuneration;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}

	public void setDateHeureCreation(LocalDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}
	
	
	
	

}
