package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Avantage {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="CODE",length = 10  )
	private String code;
	@Column(name="NOM",length = 10 )
	private String nom;
	@Column(name="MONTANT")
	private BigDecimal montant;


	public Avantage(String code, String nom, BigDecimal montant) {

		this.code = code;

		this.nom = nom;

		this.montant = montant;

	}



	public Avantage() {

		super();

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}




	
	
}
