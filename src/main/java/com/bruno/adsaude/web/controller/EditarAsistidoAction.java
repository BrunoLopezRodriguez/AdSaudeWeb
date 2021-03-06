package com.bruno.adsaude.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.Asistido;
import com.bruno.adsaude.model.AsistidoDTO;
import com.bruno.adsaude.model.UsuarioDTO;
import com.bruno.adsaude.service.AsistidoService;
import com.bruno.adsaude.service.impl.AsistidoServiceImpl;
import com.bruno.adsaude.web.controller.util.ActionNames;
import com.bruno.adsaude.web.controller.util.AttributeNames;
import com.bruno.adsaude.web.controller.util.ErrorNames;
import com.bruno.adsaude.web.controller.util.ParameterNames;
import com.bruno.adsaude.web.controller.util.ValidationUtils;
import com.bruno.adsaude.web.controller.util.ViewPaths;

public class EditarAsistidoAction extends Action{

	private static Logger logger = LogManager.getLogger(EditarAsistidoAction.class);
	private AsistidoService asistidoService=null;
	
	public EditarAsistidoAction() {
		super(ActionNames.EDITAR_ASISTIDO);
		asistidoService = new AsistidoServiceImpl();
	}
	public final String doIt(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String[]> mapParameter = request.getParameterMap();
		Errors errors = new Errors();
		request.setAttribute(AttributeNames.ERRORS , errors);
		
		AsistidoDTO asistido = (AsistidoDTO) request.getSession().getAttribute(AttributeNames.USUARIO);
		Asistido a = new Asistido();
		
		String nombreStr = ValidationUtils.numberNotValidator(mapParameter, ParameterNames.NOMBRE, errors);
		String apellido1Str =ValidationUtils.numberNotValidator(mapParameter, ParameterNames.APELLIDO1, errors);
		String apellido2Str =ValidationUtils.numberNotValidator(mapParameter, ParameterNames.APELLIDO2, errors);
		String telefonoStr = ValidationUtils.telefonoValidator(mapParameter, errors, ParameterNames.TELEFONO);
		String nifStr = ValidationUtils.dniValidation(mapParameter, errors);
		String direccionStr = request.getParameter(ParameterNames.DIRECCION);
		String emailStr = ValidationUtils.emailValidator(mapParameter, errors);
		
		if(nombreStr!=null) {
			a.setNombre(nombreStr);
		}
		if(apellido1Str!=null) {
			a.setApellido1(apellido1Str);
		}
		if(apellido2Str!=null) {
			a.setApellido2(apellido2Str);
		}
		if(telefonoStr!=null) {
			a.setTlf(telefonoStr);
		}
		if(nifStr!=null) {
			a.setNif(nifStr);
		}
		if(!StringUtils.isBlank(direccionStr)) {
			a.setDomicilio(direccionStr);
		}
		if(emailStr!=null) {
			a.setEmail(emailStr);
		}
		
		//si no cambia la contrase?a
		a.setPasswordEncriptada(asistido.getPassword());
		a.setId(asistido.getId());
		a.setIdLocalidad(asistido.getIdLocalidad());
		a.setIdMedico(asistido.getIdMedico());

		try {
			if(!errors.hasErrors()) {
				asistidoService.update(a);
				
				UsuarioDTO usdto = asistidoService.findByEmail(emailStr);

				if(usdto!=null) {
				
				//UsuarioDTO usuario = usuarioService.login(emailStr, passWordStr);
				SessionManager.set(request, AttributeNames.USUARIO, usdto);
				return ViewPaths.USUARIO_MY_PROFILE;
				}else {
					return ViewPaths.USUARIO_SELECT_LOGIN;
				}
			} else {
				errors.addCommonError("Hay campos con errores en el formuarlio. Por favor rev?selos.");
				return ViewPaths.USUARIO_MY_PROFILE_EDITAR;
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
