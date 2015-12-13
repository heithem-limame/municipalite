package com.limame.pdfgen.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.limame.pdfgen.model.ReleveNaissance;
import com.limame.pdfgen.model.Users;

public class ReleveNaissanceMapper implements RowMapper<ReleveNaissance> {

	@Override
	public ReleveNaissance mapRow(ResultSet resultSet, int arg1) throws SQLException {
		ReleveNaissance r = new ReleveNaissance();
		r.setId(resultSet.getLong("releve_id"));
		r.setNom(resultSet.getString("nom"));
		r.setPrenom(resultSet.getString("prenom"));
		r.setNomPere(resultSet.getString("nom_pere"));
		r.setNomMere(resultSet.getString("nom_mere"));
		r.setSexe(resultSet.getString("sexe"));
		r.setLieuNaissance(resultSet.getString("lieu_naissance"));
		r.setDateNaissace(resultSet.getDate("date_naissance"));
		return r;
	}

}
