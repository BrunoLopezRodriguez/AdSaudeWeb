package com.bruno.adsaude.web.controller;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.model.TipoServicioDTO;
import com.bruno.adsaude.service.TipoServicioService;
import com.bruno.adsaude.service.impl.TipoServicioServiceImpl;
import com.bruno.adsaude.web.controller.util.ActionNames;
import com.bruno.adsaude.web.controller.util.ErrorNames;
import com.google.gson.Gson;

public class ServicioHijaSearchAction extends Action{

	
	private static Logger logger = LogManager.getLogger(ServicioHijaSearchAction.class);
	private TipoServicioService tipoServicioService=null;
	private Gson gson = null; 
	
	public ServicioHijaSearchAction() {
		super(ActionNames.SERVICIO_HIJA_SEARCH);
		tipoServicioService = new TipoServicioServiceImpl();
		gson = new Gson();
	}
	
	
public final String doIt(HttpServletRequest request, HttpServletResponse response) {
			Errors errors = new Errors();
		try {
			
			
				List<TipoServicioDTO> hijas = tipoServicioService.findByHijas();
				String json = gson.toJson(hijas);

				response.setContentType("application/json");
				
				ServletOutputStream sos = response.getOutputStream();
				// TODO mimetype
				sos.write(json.getBytes());

				sos.flush();
			
			
			
		} catch (Exception e) {
			logger.error("TipoServicio Hijas: "+e);
			errors.addCommonError(ErrorNames.ERR_GENERIC);
		}	
		
		//return request.getContextPath();
		return null;
	}
}
