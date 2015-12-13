package com.limame.pdfgen.dao;

import com.limame.pdfgen.model.Users;

public interface UsersDao {
	Users getUser(String login, String pass);
}
