package com.bruno.adsaude.web.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bruno.adsaude.web.controller.util.AttributeNames;

public class SessionManager {
	
	
	
	public static final void set (HttpServletRequest request, String name, Object value) {
		getSession(request).setAttribute(name, value);
	}
	
	public static final Object get(HttpServletRequest request, String name) {
		 return getSession(request).getAttribute(name);
	}
	
	
	private static final HttpSession getSession(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		if( session ==null) {
			
			//TODO pasar un filtro
			
			session = request.getSession();

			//anhadir cualquier otro objeto que tenga que estar desde el inicio
			Locale locale = new Locale("es", "ES");
			session.setAttribute(AttributeNames.LOCALE, locale);
					
		}		
		return session;
	}

}
