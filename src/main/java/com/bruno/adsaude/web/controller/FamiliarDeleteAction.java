package com.bruno.adsaude.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.UsuarioDTO;
import com.bruno.adsaude.service.AsistidoFamiliarService;
import com.bruno.adsaude.service.impl.AsistidoFamiliarServiceImpl;
import com.bruno.adsaude.web.controller.util.ActionNames;
import com.bruno.adsaude.web.controller.util.AttributeNames;
import com.bruno.adsaude.web.controller.util.ErrorNames;
import com.bruno.adsaude.web.controller.util.ParameterNames;
import com.bruno.adsaude.web.controller.util.ViewPaths;

public class FamiliarDeleteAction extends Action{

	
	private static Logger logger = LogManager.getLogger(FamiliarDeleteAction.class);
	private AsistidoFamiliarService asistidoFamiliarService=null;
	
	public FamiliarDeleteAction() {
		super(ActionNames.FAMILIAR_DELETE);
		asistidoFamiliarService = new AsistidoFamiliarServiceImpl();
	}
	
public final String doIt(HttpServletRequest request, HttpServletResponse response) {
		
		UsuarioDTO usuario = (UsuarioDTO) request.getSession().getAttribute(AttributeNames.USUARIO);
		Errors errors = new Errors();
		request.setAttribute(AttributeNames.ERRORS , errors);
		
		String idFamiliarStr = request.getParameter(ParameterNames.FAMILIAR_ID);
		Integer idFamiliar=Integer.parseInt(idFamiliarStr);
		
		
		if(usuario==null) {
			return ViewPaths.USUARIO_SELECT_LOGIN;
		}
		
			try {
				if(idFamiliar!=null) {
				asistidoFamiliarService.delete(usuario.getId(), idFamiliar);;
				}
				
				
				return ViewPaths.FAMILIARES_BY_ASIS_RETURN;
				
				
				
			
				
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
