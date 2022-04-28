package com.bruno.adsaude.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.model.Asistido;
import com.bruno.adsaude.service.AsistidoService;
import com.bruno.adsaude.service.impl.AsistidoServiceImpl;
import com.bruno.adsaude.web.controller.util.ActionNames;
import com.bruno.adsaude.web.controller.util.AttributeNames;
import com.bruno.adsaude.web.controller.util.ParameterNames;
import com.bruno.adsaude.web.controller.util.ValidationUtils;
import com.bruno.adsaude.web.controller.util.ViewPaths;

public class RegisterAction extends Action {
	private static Logger logger = LogManager.getLogger(RegisterAction.class);
	private AsistidoService asistidoService=null;
	
	public RegisterAction() {
		super(ActionNames.REGISTER);
		asistidoService= new AsistidoServiceImpl();
	}
	
	
	public final String doIt(HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, String[]> mapParameter = request.getParameterMap();
		Errors errors = new Errors();
		request.setAttribute(AttributeNames.ERRORS , errors);
		Asistido as = new Asistido();
		
		
		String nombreStr = ValidationUtils.numberNotValidator(mapParameter, ParameterNames.NOMBRE, errors);
		String apellido1Str =ValidationUtils.numberNotValidator(mapParameter, ParameterNames.APELLIDO1, errors);
		String apellido2Str =ValidationUtils.numberNotValidator(mapParameter, ParameterNames.APELLIDO2, errors);
		String telefonoStr = ValidationUtils.telefonoValidator(mapParameter, errors, ParameterNames.TELEFONO);
		String nifStr = ValidationUtils.dniValidation(mapParameter, errors);
		String direccionStr = request.getParameter(ParameterNames.DIRECCION);
		String localidadStr = request.getParameter(ParameterNames.LOCALIDAD);
		String emailStr = ValidationUtils.emailValidator(mapParameter, errors);
		String passWordStr = ValidationUtils.passwordValidation(mapParameter, errors);
		Integer idLocalidad = null;
		if(!StringUtils.isBlank(localidadStr)) {
		idLocalidad = Integer.valueOf(localidadStr);
		}else {
			errors.addParameterError(ParameterNames.LOCALIDAD, "El parametro no coincide");
		}
		//TODO validacion
		
		as.setNombre(nombreStr);
		as.setApellido1(apellido1Str);
		as.setApellido2(apellido2Str);
		as.setTlf(telefonoStr);
		as.setNif(nifStr);
		if(!StringUtils.isBlank(direccionStr)) {
		as.setDomicilio(direccionStr);
		}else {
			as.setDomicilio(null);
			errors.addParameterError(ParameterNames.DIRECCION, "El parametro no concide");
		}
		as.setIdLocalidad(idLocalidad);
		as.setEmail(emailStr);
		as.setPassword(passWordStr);
		//seteo obligatorio de un medico que posteriormente en otra aplicacion de gestion seria cambiado por su medico adecuado
		as.setIdMedico(1);
		try {
			if(!errors.hasErrors()) {

				asistidoService.create(as);
				return ViewPaths.USUARIO_LOGIN;

			} else {
				errors.addCommonError("Hay campos con errores en el formuarlio. Por favor revíselos.");
				return ViewPaths.REGISTRO_AS;
			}

		} catch (Exception e) {
			// TODO
			errors.addCommonError("Error Registro Asistido");
			logger.error(e.getMessage(), e);
			return ViewPaths.REGISTRO_AS;
		}		
	}
}
