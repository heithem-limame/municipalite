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

public class SearchServlet extends HttpServlet {

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
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String dateString = request.getParameter("date");
		Date date = new Date(Long.parseLong(dateString));

		extraireReleveSevice = (ExtraireReleveNaissance) context.getBean("extraireReleveNaissanceImpl");

		PrintWriter writer = response.getWriter();

		// get list of releve
		List<ReleveNaissance> list = extraireReleveSevice.chercherReleve(nom, prenom, date, null, null, null, null);
		if (list != null && !list.isEmpty()) {
			writer.write("{ \"nom\" : " + list.get(0).getNom() + "    \"prenom\" : " + list.get(0).getPrenom()
					+ "   \"date\" : " + list.get(0).getDateNaissace().getTime() + " ,\"id\": "+list.get(0).getId()+ "   ,\"error\": 0 }");
		} else {
			writer.write("{ \"error\": 1 }");
		}
	}

}
