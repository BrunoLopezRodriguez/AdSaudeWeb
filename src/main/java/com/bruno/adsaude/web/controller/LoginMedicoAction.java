package com.bruno.adsaude.web.controller;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.UsuarioDTO;
import com.bruno.adsaude.service.MedicoService;
import com.bruno.adsaude.service.impl.MedicoServiceImpl;
import com.bruno.adsaude.web.controller.util.ActionNames;
import com.bruno.adsaude.web.controller.util.AttributeNames;
import com.bruno.adsaude.web.controller.util.CookieManager;
import com.bruno.adsaude.web.controller.util.ParameterNames;
import com.bruno.adsaude.web.controller.util.TipoUsuario;
import com.bruno.adsaude.web.controller.util.ViewPaths;

public class LoginMedicoAction extends Action {
	private static Logger logger = LogManager.getLogger(LoginMedicoAction.class);
	private MedicoService medicoService=null;
	//private UsuarioService usuarioService = null;

	public LoginMedicoAction() {
		super(ActionNames.LOGINEMPLEADO);
		//usuarioService = new UsuarioServiceImpl();
		medicoService= new MedicoServiceImpl();
	}

	public final String doIt(HttpServletRequest request, HttpServletResponse response) {
		String keepAuthenticatedStr = request.getParameter(ParameterNames.KEEP_AUTHENTICATED);
		Errors errors = new Errors();
		request.setAttribute(AttributeNames.ERRORS , errors);


		String emailStr = request.getParameter(ParameterNames.EMAIL);
		String passWordStr = request.getParameter(ParameterNames.PASSWORD);


		try {
			UsuarioDTO usuario=medicoService.login(emailStr, passWordStr);

			if(usuario!=null) {

				//UsuarioDTO usuario = usuarioService.login(emailStr, passWordStr);
				SessionManager.set(request, AttributeNames.USUARIO, usuario);
				if (!StringUtils.isBlank(keepAuthenticatedStr)) {						
					//TODO Falta verificar la ip...
					CookieManager.setValue(response, AttributeNames.USUARIO, emailStr, 30*24*60*60); // Agujero! Comprobar ip
					CookieManager.setValue(response, AttributeNames.TIPO_USUARIO, TipoUsuario.ASISTIDO_COOKIE, 30*24*60*60); // Agujero! Comprobar ip
				} else {
					CookieManager.setValue(response, AttributeNames.USUARIO, emailStr, 0); // Agujero! Comprobar ip
					CookieManager.setValue(response, AttributeNames.USUARIO, TipoUsuario.ASISTIDO_COOKIE, 0); // Agujero! Comprobar ip
				}
				return ViewPaths.HOME;
			}else {
				errors.addCommonError("Usuario o contraseña desconocidos");
				return ViewPaths.USUARIO_MED_LOGIN;
			}
		} catch (ServiceException se) {
			// TODO
			errors.addCommonError("Error Login Medico");
			logger.error(se.getMessage(), se);
			return ViewPaths.USUARIO_MED_LOGIN;


		} catch (Exception e) {
			// TODO
			errors.addCommonError("Error Login Medico");
			logger.error(e.getMessage(), e);
			return ViewPaths.USUARIO_MED_LOGIN;
		}		
	}



}
