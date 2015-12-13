package com.limame.pdfgen.dao;

import java.sql.Date;
import java.util.List;

import com.limame.pdfgen.model.ReleveNaissance;

public interface ReleveNaissanceDao {
	List<ReleveNaissance> getReleves(String nom, String prenom, Date date, String lieu, String sexe, String pere,
			String mere);

	ReleveNaissance getReleves(Long id);

}
