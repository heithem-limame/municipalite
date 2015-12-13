package com.limame.pdfgen.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class DocumentExtrait implements Serializable {

	private static final long serialVersionUID = 1L;
	String signature;
	Timestamp date;
	Long idReleve;
	Long idUser;

	public DocumentExtrait() {
		super();
	}

	public Timestamp getDate() {
		return date;
	}

	public Long getIdReleve() {
		return idReleve;
	}

	public Long getIdUser() {
		return idUser;
	}

	public String getSignature() {
		return signature;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public void setIdReleve(Long idReleve) {
		this.idReleve = idReleve;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

}
