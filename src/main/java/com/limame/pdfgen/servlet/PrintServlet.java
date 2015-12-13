package com.limame.pdfgen.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.limame.pdfgen.metier.ExtraireReleveNaissance;
import com.limame.pdfgen.model.ReleveNaissance;

public class PrintServlet extends HttpServlet {

	ApplicationContext context;
	ExtraireReleveNaissance extraireReleveSevice;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get spring context
		context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());

		// get login and pass from request
		Long id = Long.parseLong(request.getParameter("id"));

		extraireReleveSevice = (ExtraireReleveNaissance) context.getBean("extraireReleveNaissanceImpl");
		PrintWriter writer = response.getWriter();
		
		if (extraireReleveSevice.genererDocumentExtrait(extraireReleveSevice.chercherReleve(id))){
			writer.write("{ \"status\": \"OK\" }");
		}else {
			writer.write("{ \"status\": \"KO\" }");
		}

		
		
	}

}
