package com.bruno.adsaude.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.TipoServicio;
import com.bruno.adsaude.service.TipoServicioService;
import com.bruno.adsaude.service.impl.TipoServicioServiceImpl;
import com.bruno.adsaude.web.controller.util.ActionNames;
import com.bruno.adsaude.web.controller.util.AttributeNames;
import com.bruno.adsaude.web.controller.util.ErrorNames;
import com.bruno.adsaude.web.controller.util.ParameterNames;
import com.bruno.adsaude.web.controller.util.ViewPaths;

public class HijaByPadreAction extends Action{

	private static Logger logger = LogManager.getLogger(HijaByPadreAction.class);
	private TipoServicioService tipoServicioService=null;
	
	public HijaByPadreAction() {
		super(ActionNames.HIJA_BY_PADRE);
		tipoServicioService = new TipoServicioServiceImpl();
	}
	
public final String doIt(HttpServletRequest request, HttpServletResponse response) {
		
		Errors errors = new Errors();
		request.setAttribute(AttributeNames.ERRORS , errors);
		String idHijaStr = request.getParameter(ParameterNames.ID_HIJA);
		Integer idHija = null;
			try {
				if(!StringUtils.isBlank(idHijaStr)) {
					idHija=Integer.valueOf(idHijaStr);
				}else {
					errors.addCommonError("Ha ocurrido un error lo sentimos");
				}
				if(!errors.hasErrors()) {
				TipoServicio tipoServicio = tipoServicioService.findById(idHija);
				request.setAttribute(AttributeNames.TIPO_SERVICIO_HIJA, tipoServicio);
				return ViewPaths.SERVICIO_DETAIL;
				}else {
					errors.addCommonError("Ha ocurrido un error lo sentimos");
					return ViewPaths.SERVICIO_SEARCH;
				}
				
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
