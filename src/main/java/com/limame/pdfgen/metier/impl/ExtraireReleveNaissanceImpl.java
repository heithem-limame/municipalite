package com.limame.pdfgen.metier.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.limame.pdfgen.dao.DocumentExtraitDao;
import com.limame.pdfgen.dao.ReleveNaissanceDao;
import com.limame.pdfgen.metier.ExtraireReleveNaissance;
import com.limame.pdfgen.model.ReleveNaissance;
import com.limame.pdfgen.util.UserSession;

@Component
public class ExtraireReleveNaissanceImpl implements ExtraireReleveNaissance {

	@Autowired
	ReleveNaissanceDao releveNaissanceDao;
	@Autowired
	DocumentExtraitDao documentExtraitDao;
	UserSession userSession;

	@Override
	public List<ReleveNaissance> chercherReleve(String nom, String prenom, Date date, String lieu, String sexe, String pere,
			String mere) {
		return releveNaissanceDao.getReleves(nom, prenom, date, lieu, sexe, pere, mere);
	}

	@Override
	public void genererDocumentExtrait(ReleveNaissance releve) {
		// generate document signature 
		String signature = generateSignature(userSession.getLogin(), releve.getPrenom());
		// generate PDF document 
		
		// save the currently generated document in database
		documentExtraitDao.ajouterDocument(signature, new Timestamp(new java.util.Date().getTime()), releve.getId(), userSession.getId());
	}

	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
	}

	
	private String generateSignature(String userLogin, String relevePrenom){
		HashFunction hf = Hashing.md5();
		HashCode hc = hf.newHasher()
		       .putString(userLogin, Charsets.UTF_8)
		       .putString(relevePrenom, Charsets.UTF_8)
		       .hash();
		return hc.toString();
	}
	
	
	
}
