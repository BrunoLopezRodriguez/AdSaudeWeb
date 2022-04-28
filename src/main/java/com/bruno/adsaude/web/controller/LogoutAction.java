package com.bruno.adsaude.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bruno.adsaude.web.controller.util.ActionNames;
import com.bruno.adsaude.web.controller.util.AttributeNames;
import com.bruno.adsaude.web.controller.util.ViewPaths;

public class LogoutAction extends Action {
	//private AsistidoService asistidoService=null;
	//private UsuarioService usuarioService = null;
	
	public LogoutAction() {
		super(ActionNames.LOGOUT);
		//usuarioService = new UsuarioServiceImpl();
		//asistidoService= new AsistidoServiceImpl();
	}

	public final String doIt(HttpServletRequest request, HttpServletResponse response) {

		SessionManager.set(request, AttributeNames.USUARIO, null);
			
			return ViewPaths.HOME;
			
	}
	
}
