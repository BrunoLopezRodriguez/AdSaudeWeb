package com.bruno.adsaude.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.UsuarioDTO;
import com.bruno.adsaude.service.AsistidoService;
import com.bruno.adsaude.service.impl.AsistidoServiceImpl;
import com.bruno.adsaude.web.controller.util.ActionNames;
import com.bruno.adsaude.web.controller.util.AttributeNames;
import com.bruno.adsaude.web.controller.util.ParameterNames;
import com.bruno.adsaude.web.controller.util.ViewPaths;

public class LoginAsistidoAction extends Action {
	private AsistidoService asistidoService=null;
	//private UsuarioService usuarioService = null;
	
	public LoginAsistidoAction() {
		super(ActionNames.LOGIN);
		//usuarioService = new UsuarioServiceImpl();
		asistidoService= new AsistidoServiceImpl();
	}

	public final String doIt(HttpServletRequest request, HttpServletResponse response) {

		String emailStr = request.getParameter(ParameterNames.EMAIL);
		String passWordStr = request.getParameter(ParameterNames.PASSWORD);


		try {
			UsuarioDTO usuario=asistidoService.login(emailStr, passWordStr);
			
			if(usuario!=null) {
			
			//UsuarioDTO usuario = usuarioService.login(emailStr, passWordStr);
			SessionManager.set(request, AttributeNames.USUARIO, usuario);
			return ViewPaths.HOME;
			}else {
				return ViewPaths.USUARIO_LOGIN;
			}
		} catch (ServiceException se) {
			// TODO
			se.printStackTrace();
			return ViewPaths.USUARIO_LOGIN;
			
			
		} catch (Exception e) {
			// TODO
			e.printStackTrace();
			return ViewPaths.USUARIO_LOGIN;
		}		
	}
	
}