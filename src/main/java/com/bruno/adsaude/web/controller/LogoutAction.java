package com.bruno.adsaude.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bruno.adsaude.model.UsuarioDTO;
import com.bruno.adsaude.web.controller.util.ActionNames;
import com.bruno.adsaude.web.controller.util.AttributeNames;
import com.bruno.adsaude.web.controller.util.CookieManager;
import com.bruno.adsaude.web.controller.util.TipoUsuario;
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
		UsuarioDTO usuario = (UsuarioDTO) SessionManager.get(request, AttributeNames.USUARIO);
		
		if(usuario!=null) {
		SessionManager.set(request, AttributeNames.USUARIO, null);
		CookieManager.setValue(response, AttributeNames.USUARIO, usuario.getEmail(), 0); // Agujero! Comprobar ip
		CookieManager.setValue(response, AttributeNames.USUARIO, TipoUsuario.ASISTIDO_COOKIE, 0); // Agujero! Comprobar ip
		}
		
			return ViewPaths.HOME;
			
	}
	
}
