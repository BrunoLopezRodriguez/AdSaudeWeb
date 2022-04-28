package com.bruno.adsaude.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.FamiliarDTO;
import com.bruno.adsaude.service.FamiliarService;
import com.bruno.adsaude.service.impl.FamiliarServiceImpl;
import com.bruno.adsaude.web.controller.util.ActionNames;
import com.bruno.adsaude.web.controller.util.AttributeNames;
import com.bruno.adsaude.web.controller.util.ErrorNames;
import com.bruno.adsaude.web.controller.util.ParameterNames;
import com.bruno.adsaude.web.controller.util.ViewPaths;

public class FamiliarSearchAction extends Action{

	private static Logger logger = LogManager.getLogger(FamiliarSearchAction.class);
	private FamiliarService familiarService=null;

	
	public FamiliarSearchAction() {
		super(ActionNames.FAMILIAR_SEARCH);
		familiarService = new FamiliarServiceImpl();
	}
	
public final String doIt(HttpServletRequest request, HttpServletResponse response) {
		String dni = null;
		Errors errors = new Errors();
		request.setAttribute(AttributeNames.ERRORS , errors);
		
		String dniStr= request.getParameter(ParameterNames.DNI_FAMILIAR);
		
			try {
				
				if(!StringUtils.isBlank(dniStr)) {
					dni = dniStr;
				}
				FamiliarDTO familiar = familiarService.findByDni(dni);
				
				request.setAttribute(AttributeNames.FAMILIAR, familiar);
				
				return ViewPaths.FAMILIAR_RESULTS;
				
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
