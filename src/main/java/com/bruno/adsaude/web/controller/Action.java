package com.bruno.adsaude.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Action {
	
	private static Logger logger = LogManager.getLogger(Action.class);
	private String name = null;
	
	public Action(String name) {
		setName(name);
	}
	
	public final void doAction(HttpServletRequest request, HttpServletResponse response) {
		try {
			logger.trace("Ejecutando "+getName()+"...");
			long t0 = System.currentTimeMillis();
			String targetView = doIt(request, response);
			long t1 = System.currentTimeMillis();
			logger.trace(getName()+" ejecutada en "+ (t1-t0)+"ms! ");
			request.getRequestDispatcher(targetView).forward(request, response);
			
		} catch (Exception e) {
			// TODO
			logger.error(request+" "+response, e);
		}
	}
	
	
	protected abstract String doIt(HttpServletRequest request, HttpServletResponse response);
	
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return getName();
	}
}
