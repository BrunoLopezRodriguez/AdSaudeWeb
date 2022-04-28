package com.bruno.adsaude.web.controller;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.model.Pais;
import com.bruno.adsaude.service.PaisService;
import com.bruno.adsaude.service.impl.PaisServiceImpl;
import com.bruno.adsaude.web.controller.util.ActionNames;
import com.bruno.adsaude.web.controller.util.ErrorNames;
import com.google.gson.Gson;

public class PaisSearchAction extends Action{
	
	
	private static Logger logger = LogManager.getLogger(PaisSearchAction.class);
	private PaisService paisService=null;
	private Gson gson = null; 
	
	public PaisSearchAction() {
		super(ActionNames.PAIS_SEARCH);
		paisService = new PaisServiceImpl();
		gson = new Gson();
	}
	
public final String doIt(HttpServletRequest request, HttpServletResponse response) {
	Errors errors = new Errors();
		try {
			
			
				List<Pais> pais = paisService.findBy();
				String json = gson.toJson(pais);

				response.setContentType("application/json");
				
				ServletOutputStream sos = response.getOutputStream();
				// TODO mimetype
				sos.write(json.getBytes());

				sos.flush();
			
			
		} catch (Exception e) {
			logger.error("Pais: "+e);
			errors.addCommonError(ErrorNames.ERR_GENERIC);
		}	
		
		//return request.getContextPath();
		return null;
	}


}
