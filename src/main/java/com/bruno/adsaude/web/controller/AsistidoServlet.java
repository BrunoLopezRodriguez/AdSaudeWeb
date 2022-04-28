package com.bruno.adsaude.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Controlador (Servlet) para peticiones de asistidos
 */
@WebServlet("/asistido")
public class AsistidoServlet extends HttpServlet {
	
	private static Logger logger = LogManager.getLogger(AsistidoServlet.class);

	
	public AsistidoServlet() {
		super();
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			CommandManager.getInstance().doAction(request, response);
			
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
