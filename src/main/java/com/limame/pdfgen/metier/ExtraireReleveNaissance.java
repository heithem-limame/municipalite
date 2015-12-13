package com.limame.pdfgen.metier;

import java.sql.Date;
import java.util.List;

import com.limame.pdfgen.model.ReleveNaissance;

public interface ExtraireReleveNaissance {

	List<ReleveNaissance> chercherReleve(String nom, String prenom, Date date, String lieu, String sexe, String pere,
			String mere);

	void genererDocumentExtrait(ReleveNaissance releve);
}
