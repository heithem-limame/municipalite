package com.limame.pdfgen.metier;

public interface Authentification {
	
	boolean seConnecter(String login, String pass);

	void seDeconnecter();
}
