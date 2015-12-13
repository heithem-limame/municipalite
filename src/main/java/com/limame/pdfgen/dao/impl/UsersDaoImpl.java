package com.limame.pdfgen.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.limame.pdfgen.dao.UsersDao;
import com.limame.pdfgen.model.Users;
import com.limame.pdfgen.util.UserRowMapper;

@Component
public class UsersDaoImpl implements UsersDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Users getUser(String login, String pass) {
		try {
			String query = "SELECT * FROM user WHERE login=? AND pass=?";
			List<Users> list = jdbcTemplate.query(query, new UserRowMapper(), login, pass);
			if (list.isEmpty() || list.size() > 1) {
				return null;
			}
			return list.get(0);

		} catch (Exception e) {
			return null;
		}
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
