package com.bruno.adsaude.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bruno.adsaude.service.AsistidoFamiliarService;
import com.bruno.adsaude.service.AsistidoService;
import com.bruno.adsaude.service.impl.AsistidoFamiliarServiceImpl;


@WebServlet("/asistidofamiliar")
public class AsistidoFamiliarServlet extends HttpServlet {
	private AsistidoFamiliarService asistidoFamiliarService=null;
    
    public AsistidoFamiliarServlet() {
        super();
        asistidoFamiliarService = new AsistidoFamiliarServiceImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
