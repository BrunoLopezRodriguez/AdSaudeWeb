package com.bruno.adsaude.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.model.EmpleadoDTO;
import com.bruno.adsaude.service.EmpleadoService;
import com.bruno.adsaude.service.impl.EmpleadoServiceImpl;
import com.bruno.adsaude.web.controller.util.ActionNames;
import com.bruno.adsaude.web.controller.util.ParameterNames;
import com.google.gson.Gson;

public class EmpleadoSearchAsistenciaAction extends Action{

	private static Logger logger = LogManager.getLogger(EmpleadoSearchAsistenciaAction.class);
	private EmpleadoService empleadoService=null;
	private Gson gson = null; 
	
	public EmpleadoSearchAsistenciaAction() {
		super(ActionNames.EMPLEADO_SEARCH_ASISTENCIA);
		empleadoService = new EmpleadoServiceImpl();
		gson = new Gson();
	}
	
	public final String doIt(HttpServletRequest request, HttpServletResponse response) {
		
		List<EmpleadoDTO> empleado = new ArrayList<EmpleadoDTO>();
		String idTipoAsistendiaStr = request.getParameter(ParameterNames.TIPO_ASISTENCIA);
	try {
		Integer idTipoAsistendia = Integer.valueOf(idTipoAsistendiaStr);
		empleado = empleadoService.findByServicio(idTipoAsistendia);
		String json = gson.toJson(empleado);

		response.setContentType("application/json");
		
		ServletOutputStream sos = response.getOutputStream();
		// TODO mimetype
		sos.write(json.getBytes());

		sos.flush();
	} catch (Exception e) {
		logger.error("EmpleadoSearch: "+e);
	}	
	
	return null;
	//return request.getContextPath();
	
}
	
}
