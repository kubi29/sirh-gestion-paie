package dev.paie.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;
import dev.paie.util.GradeMapper;

@Service
public class GradeServiceJdbcTemplate implements GradeService {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	
	
	
	
	public Grade findAllGrade(){
		
		String sql = "SELECT * FROM GRADE " ; 
		return this.jdbcTemplate.queryForObject(sql, new GradeMapper());
	}
	
	@Override
	public void sauvegarder(Grade nouveauGrade) {
		
		String sql = "INSERT INTO grade (ID,CODE,NB_HEURES_BASE,TAUX_BASE) VALUES ( ?, ? , ? ,? );";
		this.jdbcTemplate.update(sql, nouveauGrade.getId(), nouveauGrade.getCode() , nouveauGrade.getNbHeuresBase(),nouveauGrade.getTauxBase());
		
	}
	@Override
	public void mettreAJour(Grade grade) {
		
		String sql = "UPDATE GRADE SET CODE = ? , NB_HEURES_BASE = ?, TAUX_BASE = ? WHERE ID = ? ";
		this.jdbcTemplate.update(sql, grade.getCode() , grade.getNbHeuresBase(),grade.getTauxBase(), grade.getId());
		
	}
	

	@Override
	public List<Grade> lister() {
		String sql = "SELECT * FROM GRADE " ; 
		return  this.jdbcTemplate.query(sql, new GradeMapper());
	}
	
	 

}
