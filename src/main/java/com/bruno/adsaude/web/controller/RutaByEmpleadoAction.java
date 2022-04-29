package com.bruno.adsaude.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.RutaDTO;
import com.bruno.adsaude.model.UsuarioDTO;
import com.bruno.adsaude.service.RutaService;
import com.bruno.adsaude.service.impl.RutaServiceImpl;
import com.bruno.adsaude.web.controller.util.ActionNames;
import com.bruno.adsaude.web.controller.util.AttributeNames;
import com.bruno.adsaude.web.controller.util.ErrorNames;
import com.bruno.adsaude.web.controller.util.ViewPaths;

public class RutaByEmpleadoAction extends Action{
	private static Logger logger = LogManager.getLogger(RutaByEmpleadoAction.class);
	private RutaService rutaService=null;

	
	public RutaByEmpleadoAction() {
		super(ActionNames.RUTA_BY_EMPLEADO);
		rutaService = new RutaServiceImpl();
	}
	
public final String doIt(HttpServletRequest request, HttpServletResponse response) {
		
		UsuarioDTO usuario = (UsuarioDTO) request.getSession().getAttribute(AttributeNames.USUARIO);
		Errors errors = new Errors();
		request.setAttribute(AttributeNames.ERRORS , errors);
		
		if(usuario==null) {
			return ViewPaths.USUARIO_SELECT_LOGIN;
		}
		
			try {
				
				List<RutaDTO> rutas = rutaService.findByEmpleado(usuario.getId());
				
				request.setAttribute(AttributeNames.RUTAS, rutas);
				
				return ViewPaths.RUTA_RESULTS;
				
			} catch (DataException de ) {
				errors.addCommonError(ErrorNames.ERR_GENERIC);
				logger.error(de.getMessage(), de);
				return ViewPaths.USUARIO_SELECT_LOGIN;
				
			}catch (ServiceException se) {
				
				logger.error(se.getMessage(), se);
				errors.addCommonError(ErrorNames.ERR_GENERIC);
				return ViewPaths.USUARIO_SELECT_LOGIN;
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				errors.addCommonError(ErrorNames.ERR_GENERIC);
				return ViewPaths.USUARIO_SELECT_LOGIN;
			}		
		
		
			
		}
	
}
