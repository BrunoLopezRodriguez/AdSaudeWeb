package com.bruno.adsaude.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.IncidenciaDTO;
import com.bruno.adsaude.model.UsuarioDTO;
import com.bruno.adsaude.service.IncidenciaService;
import com.bruno.adsaude.service.impl.IncidenciaServiceImpl;
import com.bruno.adsaude.web.controller.util.ActionNames;
import com.bruno.adsaude.web.controller.util.AttributeNames;
import com.bruno.adsaude.web.controller.util.ErrorNames;
import com.bruno.adsaude.web.controller.util.ViewPaths;

public class IncidenciaSearchCreadorAction extends Action{
	
	private static Logger logger = LogManager.getLogger(IncidenciaSearchCreadorAction.class);
	private IncidenciaService incidenciaService=null;
	
	
	public IncidenciaSearchCreadorAction() {
		super(ActionNames.INCIDENCIA_SEARCH_C);
		incidenciaService = new IncidenciaServiceImpl();
	}
	
	public final String doIt(HttpServletRequest request, HttpServletResponse response) {
	
		Errors errors = new Errors();
		request.setAttribute(AttributeNames.ERRORS , errors);
		
		UsuarioDTO usuario = (UsuarioDTO) SessionManager.get(request, AttributeNames.USUARIO);
		
		try {
			
			List<IncidenciaDTO> incidencias = incidenciaService.findByCreador(usuario.getId(), null, null);
			
			request.setAttribute(AttributeNames.INCIDENCIA, incidencias);
			
			return ViewPaths.INCIDENCIA_RESULTS;
			
		} catch (DataException de) {
			
			errors.addCommonError(ErrorNames.ERR_GENERIC);
			logger.error(de.getMessage(), de);
			return ViewPaths.INCIDENCIA;
		} catch (ServiceException se) {
			// TODO
			logger.error(se.getMessage(), se);
			errors.addCommonError(ErrorNames.ERR_GENERIC);
			return ViewPaths.INCIDENCIA;
		}catch (Exception e) {
			// TODO
			logger.error(e.getMessage(), e);
			errors.addCommonError(ErrorNames.ERR_GENERIC);
			return ViewPaths.INCIDENCIA;
		}		
		
	
		
	}
	
	
}
