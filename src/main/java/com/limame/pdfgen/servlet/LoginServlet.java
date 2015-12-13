package com.limame.pdfgen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.limame.pdfgen.metier.Authentification;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	ApplicationContext context;
	Authentification authService;

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
		context =  WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
		
		// get login and pass from request
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
  
		PrintWriter writer = response.getWriter();
		authService = (Authentification) context.getBean("authentificationImpl");
		// attempt to find login and pass
		if (authService.seConnecter(login, pass)) {
			// return successful connection
			writer.write("{ \"connected\" : true }");
		} else {
			// return failed connection
			writer.write("{ \"connected\" : false }");
		}
	}

}
