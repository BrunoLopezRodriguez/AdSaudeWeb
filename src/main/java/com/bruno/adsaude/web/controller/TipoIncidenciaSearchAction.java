package com.bruno.adsaude.web.controller;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.model.TipoIncidencia;
import com.bruno.adsaude.service.TipoIncidenciaService;
import com.bruno.adsaude.service.impl.TipoIncidenciaServiceImpl;
import com.bruno.adsaude.web.controller.util.ActionNames;
import com.google.gson.Gson;

public class TipoIncidenciaSearchAction extends Action{
	
	private static Logger logger = LogManager.getLogger(TipoIncidenciaSearchAction.class);
	private TipoIncidenciaService tipoIncidenciaService=null;
	private Gson gson = null; 
	
	
	public TipoIncidenciaSearchAction() {
		super(ActionNames.TIPO_INCIDENCIA_SEARCH);
		tipoIncidenciaService = new TipoIncidenciaServiceImpl();
		gson = new Gson();
	}
	
	
	public final String doIt(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			List<TipoIncidencia> tipoIncidencia = tipoIncidenciaService.findBy();
			String json = gson.toJson(tipoIncidencia);

			response.setContentType("application/json");
			
			ServletOutputStream sos = response.getOutputStream();
			// TODO mimetype
			sos.write(json.getBytes());

			sos.flush();
		} catch (Exception e) {
			logger.error("tipoIncidencia: "+e);
		}	
		
		//return request.getContextPath();
		return null;
		
	}
}
