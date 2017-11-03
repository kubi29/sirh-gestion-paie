package dev.paie.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;

@Service
public class GradeMapper implements RowMapper<Grade>{

	@Override
	public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Grade g = new Grade();
		g.setId(rs.getInt("ID"));
		g.setCode(rs.getString("CODE"));
		g.setNbHeuresBase(rs.getBigDecimal("NB_HEURES_BASE"));
		g.setTauxBase(rs.getBigDecimal("TAUX_BASE"));
		
		return g;
	}

}
