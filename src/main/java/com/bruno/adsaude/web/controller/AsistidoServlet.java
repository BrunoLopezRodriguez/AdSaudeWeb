package com.bruno.adsaude.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bruno.adsaude.model.AsistidoDTO;
import com.bruno.adsaude.service.AsistidoService;
import com.bruno.adsaude.service.impl.AsistidoServiceImpl;

/**
 * Controlador (Servlet) para peticiones de asistidos
 */
@WebServlet("/asistido")
public class AsistidoServlet extends HttpServlet {

	private AsistidoService asistidoService=null;
	public AsistidoServlet() {
		super();
		asistidoService= new AsistidoServiceImpl();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		CommandManager.getInstance().doAction(request, response);
		
		try {
			
			
		/*
		String idFamiliarStr = request.getParameter("id-familiar");
		
		// convertir y validar
		Integer idFamiliar = Integer.valueOf(idFamiliarStr);

		//Acceder a la capa de negocio
		
		
		List<AsistidoDTO> as = asistidoService.findByFamiliar(idFamiliar);   	
		//Renderizar los resultados

		request.setAttribute("asistidos", as);
		request.getRequestDispatcher("/asistido/asistido-results.jsp").forward(request, response);

		
		response.getWriter().append("Served at: ").append(request.getContextPath());

		response.getWriter().append(" <h3> El asistido "+nombreStr+" es Pepito</h3> ");
		
			*/
		}catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
