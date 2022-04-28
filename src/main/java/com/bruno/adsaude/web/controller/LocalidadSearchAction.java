package com.bruno.adsaude.web.controller;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.model.Localidad;
import com.bruno.adsaude.service.LocalidadService;
import com.bruno.adsaude.service.impl.LocalidadServiceImpl;
import com.bruno.adsaude.web.controller.util.ActionNames;
import com.bruno.adsaude.web.controller.util.ErrorNames;
import com.bruno.adsaude.web.controller.util.ParameterNames;
import com.google.gson.Gson;

public class LocalidadSearchAction extends Action{
	
	
	private static Logger logger = LogManager.getLogger(LocalidadSearchAction.class);
	private LocalidadService localidadService=null;
	private Gson gson = null; 
	
	
	public LocalidadSearchAction() {
		super(ActionNames.LOCALIDAD);
		localidadService = new LocalidadServiceImpl();
		gson = new Gson();
	}
	
	
	public final String doIt(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			Errors errors = new Errors();
			String idProvincia = request.getParameter(ParameterNames.PROVINCIA);
			if(!StringUtils.isBlank(idProvincia)) {
				List<Localidad> localidades = localidadService.findByProvincia(Integer.parseInt(idProvincia));
				String json = gson.toJson(localidades);

				response.setContentType("application/json");
				
				ServletOutputStream sos = response.getOutputStream();
				// TODO mimetype
				sos.write(json.getBytes());

				sos.flush();
			}else {
				errors.addCommonError(ErrorNames.ERR_GENERIC);
				logger.error("parametro idprovincia a null");
			}
			
			
		} catch (Exception e) {
			logger.error("Localidades: "+e);
		}	
		
		//return request.getContextPath();
		return null;
		
	}

}
