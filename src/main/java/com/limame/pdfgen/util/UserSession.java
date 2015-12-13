package com.limame.pdfgen.util;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class UserSession implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login;
	private Long id;

	public UserSession() {
	
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
