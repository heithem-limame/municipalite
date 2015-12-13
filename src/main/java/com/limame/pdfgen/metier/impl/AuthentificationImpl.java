package com.limame.pdfgen.metier.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.limame.pdfgen.dao.UsersDao;
import com.limame.pdfgen.metier.Authentification;
import com.limame.pdfgen.model.Users;
import com.limame.pdfgen.util.UserSession;

@Component
public class AuthentificationImpl implements Authentification {

	@Autowired
	private UsersDao usersDao;
	@Autowired
	private UserSession userSession;

	@Override
	public boolean seConnecter(String login, String pass) {
		Users user = usersDao.getUser(login, pass);
		if (user == null)
			return false;
		userSession.setId(user.getId());
		userSession.setLogin(user.getLogin());
		return true;
	}

	@Override
	public void seDeconnecter() {
		userSession = null;
	}

	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
	}

}
