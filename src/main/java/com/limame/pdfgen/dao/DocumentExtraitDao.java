package com.limame.pdfgen.dao;

import java.sql.Timestamp;

public interface DocumentExtraitDao {
	void ajouterDocument(String signature, Timestamp date, Long idReleve, Long idUser);
}
