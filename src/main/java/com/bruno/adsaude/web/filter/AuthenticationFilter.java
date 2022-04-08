package com.bruno.adsaude.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.model.UsuarioDTO;
import com.bruno.adsaude.web.controller.SessionManager;
import com.bruno.adsaude.web.controller.util.AttributeNames;
import com.bruno.adsaude.web.controller.util.ViewPaths;

/**
 * Filtro de autentificacion
 */
@WebFilter("")
public class AuthenticationFilter extends HttpFilter implements Filter {
       
  
	private static Logger logger = LogManager.getLogger(AuthenticationFilter.class);
	
	public AuthenticationFilter() {
		super();
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		UsuarioDTO usuario = (UsuarioDTO) SessionManager.get(httpRequest, AttributeNames.USUARIO);
		if (usuario==null) {	
			if (logger.isWarnEnabled()) {
				logger.warn("Trying to GET "+httpRequest.getRequestURI());
			}
			httpRequest.getRequestDispatcher(ViewPaths.USUARIO_SELECT_LOGIN).forward(httpRequest, httpResponse);
		} else {
			chain.doFilter(request, response);
		}

	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

	
	
	public void destroy() {
		
	}

	
}
