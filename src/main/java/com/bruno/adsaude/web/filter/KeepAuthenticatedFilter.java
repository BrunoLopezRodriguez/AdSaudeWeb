package com.bruno.adsaude.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.UsuarioDTO;
import com.bruno.adsaude.service.AsistidoService;
import com.bruno.adsaude.service.EmpleadoService;
import com.bruno.adsaude.service.FamiliarService;
import com.bruno.adsaude.service.MedicoService;
import com.bruno.adsaude.service.impl.AsistidoServiceImpl;
import com.bruno.adsaude.service.impl.EmpleadoServiceImpl;
import com.bruno.adsaude.service.impl.FamiliarServiceImpl;
import com.bruno.adsaude.service.impl.MedicoServiceImpl;
import com.bruno.adsaude.web.controller.SessionManager;
import com.bruno.adsaude.web.controller.util.AttributeNames;
import com.bruno.adsaude.web.controller.util.CookieManager;
import com.bruno.adsaude.web.controller.util.TipoUsuario;


/**
 * Servlet Filter implementation class KeepAuthenticatedFilter
 */
public class KeepAuthenticatedFilter extends HttpFilter implements Filter {
	private static Logger logger = LogManager.getLogger(KeepAuthenticatedFilter.class);
	private AsistidoService asistidoService = null;
	private EmpleadoService empleadoService = null;
	private MedicoService medicoService = null;
	private FamiliarService familiarService = null;
   
    public KeepAuthenticatedFilter() {
        super();
        asistidoService = new AsistidoServiceImpl();
        empleadoService = new EmpleadoServiceImpl();
        medicoService = new MedicoServiceImpl();
        familiarService = new FamiliarServiceImpl();
    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    	HttpServletRequest httpRequest = (HttpServletRequest) request;

    	UsuarioDTO usuario = (UsuarioDTO) SessionManager.get(httpRequest, AttributeNames.USUARIO);
    	if (usuario==null) {
    		// No esta autenticado, miro la cookie
    		String email = CookieManager.getValue(httpRequest, AttributeNames.USUARIO);
    		String tipo = CookieManager.getValue(httpRequest, AttributeNames.TIPO_USUARIO);
    		if (!StringUtils.isBlank(email)&&!StringUtils.isBlank(tipo)) {
    			// Tenemos cookie de usuario (RECORDAR QUE ESTO ES UN AGUJERO DE SEGURIDAD)
    			try {
    				if(tipo.equalsIgnoreCase(TipoUsuario.ASISTIDO_COOKIE)) {
    					usuario = (UsuarioDTO) asistidoService.findByEmail(email);
        				SessionManager.set(httpRequest, AttributeNames.USUARIO, usuario);
    				}
    				else if(tipo.equalsIgnoreCase(TipoUsuario.EMPLEADO_COOKIE)) {
    					usuario = (UsuarioDTO) empleadoService.findByEmail(email);
        				SessionManager.set(httpRequest, AttributeNames.USUARIO, usuario);
    				}
    				else if(tipo.equalsIgnoreCase(TipoUsuario.MEDICO_COOKIE)) {
    					usuario = (UsuarioDTO) medicoService.findByEmail(email);
        				SessionManager.set(httpRequest, AttributeNames.USUARIO, usuario);
    				}
    				else if(tipo.equalsIgnoreCase(TipoUsuario.FAMILIAR_COOKIE)) {
    					usuario = (UsuarioDTO) familiarService.findByEmail(email);
        				SessionManager.set(httpRequest, AttributeNames.USUARIO, usuario);
    				}
    				
    				if (logger.isInfoEnabled()) {
    					logger.info("User "+email+" authenticated form cookie");
    				}
    			}
    			catch(DataException de) {
    				logger.error("Trying to login by cookie: "+email, de);
    			}catch (ServiceException se) {
    				logger.error("Trying to login by cookie: "+email, se);
    			}
    		}
    	} else {
    		//no hay coockie
    	}
    	
    	chain.doFilter(request, response);
    }


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
