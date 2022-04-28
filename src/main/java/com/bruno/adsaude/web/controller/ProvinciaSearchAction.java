package com.bruno.adsaude.web.controller;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.model.Provincia;
import com.bruno.adsaude.service.ProvinciaService;
import com.bruno.adsaude.service.impl.ProvinciaServiceImpl;
import com.bruno.adsaude.web.controller.util.ActionNames;
import com.bruno.adsaude.web.controller.util.ErrorNames;
import com.bruno.adsaude.web.controller.util.ParameterNames;
import com.google.gson.Gson;

public class ProvinciaSearchAction extends Action{


	private static Logger logger = LogManager.getLogger(ProvinciaSearchAction.class);
	private ProvinciaService provinciaService=null;
	private Gson gson = null; 
	
	public ProvinciaSearchAction() {
		super(ActionNames.PROVINCIA_SEARCH);
		provinciaService = new ProvinciaServiceImpl();
		gson = new Gson();
	}
	
public final String doIt(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			Errors errors = new Errors();
			String idPais = request.getParameter(ParameterNames.PAIS);
			if(!StringUtils.isBlank(idPais)) {
				List<Provincia> provincias = provinciaService.findByPais(Integer.parseInt(idPais));
				String json = gson.toJson(provincias);

				response.setContentType("application/json");
				
				ServletOutputStream sos = response.getOutputStream();
				// TODO mimetype
				sos.write(json.getBytes());

				sos.flush();
			}else {
				errors.addCommonError(ErrorNames.ERR_GENERIC);
				logger.error("parametro idpais a null");
			}
			
			
		} catch (Exception e) {
			logger.error("Provincias: "+e);
		}	
		
		//return request.getContextPath();
		return null;
	}

}
