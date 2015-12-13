package com.limame.pdfgen.model;

import java.io.Serializable;
import java.util.Date;

public class ReleveNaissance implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	Long id;
	String nom, prenom, sexe, lieuNaissance, nomPere, nomMere;
	Date dateNaissace;

	public ReleveNaissance() {
		super();
	}

	public Date getDateNaissace() {
		return dateNaissace;
	}

	public Long getId() {
		return id;
	}

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public String getNom() {
		return nom;
	}

	public String getNomMere() {
		return nomMere;
	}

	public String getNomPere() {
		return nomPere;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setDateNaissace(Date dateNaissace) {
		this.dateNaissace = dateNaissace;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setNomMere(String nomMere) {
		this.nomMere = nomMere;
	}

	public void setNomPere(String nomPere) {
		this.nomPere = nomPere;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

}