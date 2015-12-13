package com.limame.pdfgen.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.limame.pdfgen.model.Users;

public class UserRowMapper implements RowMapper<Users>{

	@Override
	public Users mapRow(ResultSet resultSet, int arg1) throws SQLException {
		Users user = new Users();
		user.setId(resultSet.getLong("id"));
		user.setLogin(resultSet.getString("login"));
		user.setPass(resultSet.getString("pass"));
		return user;
	}

}
