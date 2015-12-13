package com.limame.pdfgen.dao.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.limame.pdfgen.dao.DocumentExtraitDao;

@Component
public class DocumentExtraitDaoImpl implements DocumentExtraitDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void ajouterDocument(String signature, Timestamp date, Long idReleve, Long idUser) {
		try{
		jdbcTemplate.update("INSERT INTO document_extrait (signature,date,id_releve,id_user) VALUES (" + signature + ","
				+ date + "," + idReleve + "," + idUser);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
