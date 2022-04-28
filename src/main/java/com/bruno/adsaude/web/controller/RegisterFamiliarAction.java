package com.bruno.adsaude.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.model.Familiar;
import com.bruno.adsaude.service.FamiliarService;
import com.bruno.adsaude.service.impl.FamiliarServiceImpl;
import com.bruno.adsaude.web.controller.util.ActionNames;
import com.bruno.adsaude.web.controller.util.AttributeNames;
import com.bruno.adsaude.web.controller.util.ParameterNames;
import com.bruno.adsaude.web.controller.util.ViewPaths;

public class RegisterFamiliarAction extends Action{
	private static Logger logger = LogManager.getLogger(RegisterFamiliarAction.class);

	private FamiliarService familiarService=null;

public RegisterFamiliarAction() {
	super(ActionNames.REGISTER_FAMILIAR);
	familiarService = new FamiliarServiceImpl();
}

public final String doIt(HttpServletRequest request, HttpServletResponse response) {
	
	Errors errors = new Errors();
	request.setAttribute(AttributeNames.ERRORS , errors);
	Familiar f = new Familiar();
	
	String nombreStr = request.getParameter(ParameterNames.NOMBRE);
	String apellido1Str = request.getParameter(ParameterNames.APELLIDO1);
	String apellido2Str = request.getParameter(ParameterNames.APELLIDO2);
	String telefonoStr = request.getParameter(ParameterNames.TELEFONO);
	String nifStr = request.getParameter(ParameterNames.NIF);
	String direccionStr = request.getParameter(ParameterNames.DIRECCION);
	String localidadStr = request.getParameter(ParameterNames.LOCALIDAD);
	String emailStr = request.getParameter(ParameterNames.EMAIL);
	String passWordStr = request.getParameter(ParameterNames.PASSWORD);
	
	
	Integer idLocalidad = Integer.valueOf(localidadStr);
	//TODO validacion
	
	f.setNombre(nombreStr);
	f.setApellido1(apellido1Str);
	f.setApellido2(apellido2Str);
	f.setTlf(telefonoStr);
	f.setNif(nifStr);
	f.setDomicilio(direccionStr);
	f.setIdLocalidad(idLocalidad);
	f.setEmail(emailStr);
	f.setPassword(passWordStr);
	
	try {
		/*Integer idAsistido=*/familiarService.create(f);
		//UsuarioDTO usuario = usuarioService.login(emailStr, passWordStr);
		//SessionManager.set(request, AttributeNames.ASISTIDO, idAsistido);
		
		return ViewPaths.USUARIO_FAM_LOGIN;
		
	} catch (Exception e) {
		// TODO
		errors.addCommonError("Error Registro Familiar");
		logger.error(e.getMessage(), e);
		return ViewPaths.HOME;
	}		
}


}
