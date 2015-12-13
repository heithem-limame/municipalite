package com.limame.pdfgen.model;

import java.io.Serializable;

public class Users implements Serializable {

	Long id;
	String login, pass;

	public Users() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getPass() {
		return pass;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", login=" + login + ", pass=" + pass + "]";
	}

}
