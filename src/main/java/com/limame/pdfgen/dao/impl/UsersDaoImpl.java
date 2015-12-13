package com.limame.pdfgen.dao.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.limame.pdfgen.dao.UsersDao;
import com.limame.pdfgen.model.Users;

@Component
public class UsersDaoImpl implements UsersDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Users getUser(String login, String pass) {
		try {
			Map<String, Object> userMap = jdbcTemplate
					.queryForMap("SELECT * FROM user WHERE login=" + login + " AND pass=" + pass);
			Users user = new Users();
			user.setLogin(String.valueOf(userMap.get("login")));
			user.setId(Long.parseLong(String.valueOf(userMap.get("id"))));
			return user;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
