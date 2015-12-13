package com.limame.pdfgen.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.limame.pdfgen.dao.ReleveNaissanceDao;
import com.limame.pdfgen.model.ReleveNaissance;
import com.limame.pdfgen.util.ReleveNaissanceMapper;

@Component
public class ReleveNaissanceDaoImpl implements ReleveNaissanceDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<ReleveNaissance> getReleves(String nom, String prenom, Date date, String lieu, String sexe, String pere,
			String mere) {
		final List<ReleveNaissance> releves = new ArrayList<ReleveNaissance>();
		try {
			String query = "SELECT * FROM releve_naissance WHERE nom = " + nom + " AND prenom = " + prenom
					+ " AND date_naissance = " + date;
			if (lieu != null && !lieu.isEmpty()) {
				query += " AND lieu = " + lieu;
			}
			if (sexe != null && !sexe.isEmpty()) {
				query += " AND sexe = " + sexe;
			}
			if (pere != null && !pere.isEmpty()) {
				query += " AND pere = " + pere;
			}
			if (mere != null && !mere.isEmpty()) {
				query += " AND mere = " + mere;
			}
			List<Map<String, Object>> result = jdbcTemplate.queryForList(query);

			for (Map<String, Object> tuple : result) {
				ReleveNaissance releve = new ReleveNaissance();
				releve.setDateNaissace((java.sql.Date) tuple.get("date_naissace"));
				releve.setId(Long.parseLong(String.valueOf(tuple.get("id_releve"))));
				releve.setLieuNaissance(String.valueOf("lieu_naissance"));
				releve.setNom(String.valueOf("nom"));
				releve.setPrenom(String.valueOf("prenom"));
				releve.setNomMere(String.valueOf("nom_mere"));
				releve.setNomPere(String.valueOf("nom_pere"));
				releve.setSexe(String.valueOf("sexe"));
			}

		} catch (final Exception e) {
			e.printStackTrace();
			return null;
		}
		return releves;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public ReleveNaissance getReleves(Long id) {
		try {
			ReleveNaissance releve = jdbcTemplate.queryForObject("SELECT * FROM releve_naissance WHERE id_releve=?",
					new ReleveNaissanceMapper(), id);

			return releve;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
