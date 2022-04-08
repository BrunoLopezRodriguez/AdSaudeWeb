package com.bruno.adsaude.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.UsuarioDTO;
import com.bruno.adsaude.service.FamiliarService;
import com.bruno.adsaude.service.impl.FamiliarServiceImpl;
import com.bruno.adsaude.web.controller.util.ActionNames;
import com.bruno.adsaude.web.controller.util.AttributeNames;
import com.bruno.adsaude.web.controller.util.ParameterNames;
import com.bruno.adsaude.web.controller.util.ViewPaths;

public class LoginFamiliarAction extends Action {
	private FamiliarService familiarService=null;
	//private UsuarioService usuarioService = null;

	public LoginFamiliarAction() {
		super(ActionNames.LOGINEMPLEADO);
		//usuarioService = new UsuarioServiceImpl();
		familiarService= new FamiliarServiceImpl();
	}

		public final String doIt(HttpServletRequest request, HttpServletResponse response) {

			String emailStr = request.getParameter(ParameterNames.EMAIL);
			String passWordStr = request.getParameter(ParameterNames.PASSWORD);


			try {
				UsuarioDTO usuario=familiarService.login(emailStr, passWordStr);
				
				if(usuario!=null) {
				
				//UsuarioDTO usuario = usuarioService.login(emailStr, passWordStr);
				SessionManager.set(request, AttributeNames.USUARIO, usuario);
				return ViewPaths.HOME;
				}else {
					return ViewPaths.USUARIO_FAM_LOGIN;
				}
			} catch (ServiceException se) {
				// TODO
				se.printStackTrace();
				return ViewPaths.USUARIO_FAM_LOGIN;
				
				
			} catch (Exception e) {
				// TODO
				e.printStackTrace();
				return ViewPaths.USUARIO_FAM_LOGIN;
			}		
		}
		
	
}


