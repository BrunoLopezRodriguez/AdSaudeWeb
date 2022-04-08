package com.bruno.adsaude.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bruno.adsaude.model.Asistido;
import com.bruno.adsaude.service.AsistidoService;
import com.bruno.adsaude.service.impl.AsistidoServiceImpl;
import com.bruno.adsaude.web.controller.util.ActionNames;
import com.bruno.adsaude.web.controller.util.ParameterNames;
import com.bruno.adsaude.web.controller.util.ViewPaths;

public class RegisterAction extends Action {

	private AsistidoService asistidoService=null;
	
	public RegisterAction() {
		super(ActionNames.REGISTER);
		asistidoService= new AsistidoServiceImpl();
	}
	
	
	public final String doIt(HttpServletRequest request, HttpServletResponse response) {
		Asistido as = new Asistido();
		
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
		
		as.setNombre(nombreStr);
		as.setApellido1(apellido1Str);
		as.setApellido2(apellido2Str);
		as.setTlf(telefonoStr);
		as.setNif(nifStr);
		as.setDomicilio(direccionStr);
		as.setIdLocalidad(idLocalidad);
		as.setEmail(emailStr);
		as.setPassword(passWordStr);
		as.setIdMedico(1);
		try {
			/*Integer idAsistido=*/asistidoService.create(as);
			//UsuarioDTO usuario = usuarioService.login(emailStr, passWordStr);
			//SessionManager.set(request, AttributeNames.ASISTIDO, idAsistido);
			
			return ViewPaths.USUARIO_LOGIN;
			
		} catch (Exception e) {
			// TODO
			e.printStackTrace();
			return ViewPaths.HOME;
		}		
	}
}
