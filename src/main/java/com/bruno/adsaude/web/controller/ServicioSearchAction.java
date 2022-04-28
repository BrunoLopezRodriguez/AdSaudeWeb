package com.bruno.adsaude.web.controller;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.model.TipoServicio;
import com.bruno.adsaude.service.TipoServicioService;
import com.bruno.adsaude.service.impl.TipoServicioServiceImpl;
import com.bruno.adsaude.web.controller.util.ActionNames;
import com.google.gson.Gson;

public class ServicioSearchAction extends Action{

	private static Logger logger = LogManager.getLogger(ServicioSearchAction.class);
	private TipoServicioService tipoServicioService=null;
	private Gson gson = null; 
	
	public ServicioSearchAction() {
		super(ActionNames.SERVICIOS_SEARCH);
		tipoServicioService = new TipoServicioServiceImpl();
		gson = new Gson();
	}
	
public final String doIt(HttpServletRequest request, HttpServletResponse response) {
			Errors errors = new Errors();
		try {

				List<TipoServicio> serviciosPadre = tipoServicioService.findByPadre();
				
				String json = gson.toJson(serviciosPadre);

				response.setContentType("application/json");
				
				ServletOutputStream sos = response.getOutputStream();
				// TODO mimetype
				sos.write(json.getBytes());

				sos.flush();
			
		} catch (Exception e) {
			logger.error("Servicios: "+e);
			errors.addCommonError("Error carga de Servicios");
		}	
		
		
		//return request.getContextPath();
		return null;
	}

}
