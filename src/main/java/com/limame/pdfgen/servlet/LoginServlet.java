package com.limame.pdfgen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.limame.pdfgen.metier.Authentification;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet{

	ApplicationContext context;
	@Override
	public void init() throws ServletException {
		context = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Authentification authService = (Authentification) context.getBean("Authentification");		
		
		// get login and pass from request
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");

		PrintWriter writer = response.getWriter();

		// attempt to find login and pass
		if (authService.seConnecter(login, pass)) {
			// return successful connection
			writer.write("{ connected : true }");
		} else {
			// return failed connection
			writer.write("{ connected : false }");
		}
	}

}
