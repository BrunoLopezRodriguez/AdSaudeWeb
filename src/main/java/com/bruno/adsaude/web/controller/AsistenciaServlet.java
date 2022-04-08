package com.bruno.adsaude.web.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.bruno.adsaude.model.AsistenciaCriteria;
import com.bruno.adsaude.model.AsistenciaDTO;
import com.bruno.adsaude.service.AsistenciaService;
import com.bruno.adsaude.service.impl.AsistenciaServiceImpl;


@WebServlet("/asistencia")
public class AsistenciaServlet extends HttpServlet {
	
	private AsistenciaService asistenciaService=null;
     
    public AsistenciaServlet() {
        super();
        asistenciaService= new AsistenciaServiceImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		Integer asistidoId=null;
		Integer asistenciaId=null;
		Integer empleadoId=null;
		try {
			
		String fechaDesdeStr= request.getParameter("fecha-desde");
		String fechaHastaStr= request.getParameter("fecha-hasta");
		String asistidoIdStr=request.getParameter("asistido-id");
		String asistenciaIdStr= request.getParameter("asistencia-id");
		String empleadoIdStr= request.getParameter("empleado-id");
		
		
		Date fechaDesde= Date.valueOf(fechaDesdeStr);
		Date fechaHasta= Date.valueOf(fechaHastaStr);
		
		
			 asistidoId=Integer.valueOf(asistidoIdStr);
		
			 asistenciaId=Integer.valueOf(asistenciaIdStr);
		
			 empleadoId=Integer.valueOf(empleadoIdStr);
		
		
		
		AsistenciaCriteria c = new AsistenciaCriteria();
		
		c.setFechaHoraInicio(fechaDesde);
		c.setFechaHoraFin(fechaHasta);
		c.setIdAsistido(asistidoId);
		c.setIdEmpleado(empleadoId);
		c.setIdServicio(asistenciaId);
		
		List<AsistenciaDTO> as = asistenciaService.findByCriteria(c);
		
		request.setAttribute("asistencias", as);
		request.getRequestDispatcher("/asistencia/asistencia-results.jsp").forward(request, response);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
