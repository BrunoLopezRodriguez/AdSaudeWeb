package com.bruno.adsaude.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.model.AsistidoDTO;
import com.bruno.adsaude.model.UsuarioDTO;
import com.bruno.adsaude.service.AsistidoService;
import com.bruno.adsaude.service.impl.AsistidoServiceImpl;
import com.bruno.adsaude.web.controller.util.ActionNames;
import com.bruno.adsaude.web.controller.util.AttributeNames;
import com.google.gson.Gson;

public class AsistidoSearchAsistenciaAction extends Action{

	private static Logger logger = LogManager.getLogger(AsistidoSearchAsistenciaAction.class);
	private AsistidoService asistidoService=null;
	private Gson gson = null; 
	
	public AsistidoSearchAsistenciaAction() {
		super(ActionNames.ASISTIDO_SEARCH_ASISTENCIA);
		asistidoService = new AsistidoServiceImpl();
		gson = new Gson();
	}
	
		public final String doIt(HttpServletRequest request, HttpServletResponse response) {
			UsuarioDTO usuario = (UsuarioDTO) request.getSession().getAttribute(AttributeNames.USUARIO);
			List<AsistidoDTO> asistido = new ArrayList<AsistidoDTO>();
		try {
			
			asistido = asistidoService.findByFamiliar(usuario.getId());
			String json = gson.toJson(asistido);

			response.setContentType("application/json");
			
			ServletOutputStream sos = response.getOutputStream();
			// TODO mimetype
			sos.write(json.getBytes());

			sos.flush();
		} catch (Exception e) {
			logger.error("AsistidoSearch: "+e);
		}	
		
		//return request.getContextPath();
		return null;
	}
	
}
