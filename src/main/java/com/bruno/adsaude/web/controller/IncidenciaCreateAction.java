package com.bruno.adsaude.web.controller;

import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.model.Incidencia;
import com.bruno.adsaude.model.UsuarioDTO;
import com.bruno.adsaude.service.IncidenciaService;
import com.bruno.adsaude.service.impl.IncidenciaServiceImpl;
import com.bruno.adsaude.web.controller.util.ActionNames;
import com.bruno.adsaude.web.controller.util.AttributeNames;
import com.bruno.adsaude.web.controller.util.ParameterNames;
import com.bruno.adsaude.web.controller.util.TipoUsuario;
import com.bruno.adsaude.web.controller.util.ViewPaths;

public class IncidenciaCreateAction extends Action{

	private static Logger logger = LogManager.getLogger(IncidenciaCreateAction.class);
	private IncidenciaService incidenciaService=null;
	
	public IncidenciaCreateAction() {
		super(ActionNames.INCIDENCIA_CREATE);
		incidenciaService= new IncidenciaServiceImpl();
	}
	
public final String doIt(HttpServletRequest request, HttpServletResponse response) {
	UsuarioDTO usuario = (UsuarioDTO) request.getSession().getAttribute(AttributeNames.USUARIO);
		Map<String, String[]> mapParameter = request.getParameterMap();
		Errors errors = new Errors();
		request.setAttribute(AttributeNames.ERRORS , errors);
		Incidencia incidencia = new Incidencia();
		Date fechaIncidencia=null;
		Integer tipoIncidencia = null;
		Integer asistidoAfectado=null;
		Integer tipo = usuario.getTipo();
		String fechaIncidenciaStr = request.getParameter(ParameterNames.FECHA_INCIDENCIA);
		String tipoIncidenciaStr =request.getParameter(ParameterNames.TIPO_INCIDENCIA);
		String resumenStr =request.getParameter(ParameterNames.RESUMEN);
		String descripcionStr = request.getParameter(ParameterNames.DESCRPCION);
		
		//TODO depende de quien este logueado
		String asistidoAfectadoStr = request.getParameter(ParameterNames.ASISTIDO_AFECTADO);
		
		if(!StringUtils.isBlank(fechaIncidenciaStr)) {
			fechaIncidencia= Date.valueOf(fechaIncidenciaStr);	
			incidencia.setFechaHora(fechaIncidencia);
		}else {
			errors.addParameterError(ParameterNames.FECHA_INCIDENCIA, "El parametro no coincide");
		}

		if(!StringUtils.isBlank(tipoIncidenciaStr)) {
			tipoIncidencia= Integer.valueOf(tipoIncidenciaStr);	
			incidencia.setIdTipoIncidencia(tipoIncidencia);
		}else {
			errors.addParameterError(ParameterNames.TIPO_INCIDENCIA, "El parametro no coincide");
		}

		if(!StringUtils.isBlank(resumenStr)) {
			incidencia.setResumen(resumenStr);
		}else {
			errors.addParameterError(ParameterNames.RESUMEN, "El parametro no coincide");
		}

		if(!StringUtils.isBlank(descripcionStr)) {
			incidencia.setDescripcion(descripcionStr);
		}else {
			errors.addParameterError(ParameterNames.DESCRPCION, "El parametro no coincide");
		}
		if (tipo==TipoUsuario.ASISTIDO||tipo==TipoUsuario.ASISTIDO_DTO) {
			incidencia.setIdAsistido(usuario.getId());
			incidencia.setIdAsistidoAfectado(usuario.getId());
		} else if(tipo==TipoUsuario.EMPLEADO||tipo==TipoUsuario.EMPLEADO_DTO) {
			incidencia.setIdEmpleado(usuario.getId());
		} else if(tipo==TipoUsuario.FAMILIAR||tipo==TipoUsuario.FAMILIAR_DTO) {
			incidencia.setIdFamiliar(usuario.getId());
		}
		
		
		
		try {
			if(!errors.hasErrors()) {

				incidenciaService.create(incidencia);
				return ViewPaths.INCIDENCIA_CREADA;

			} else {
				errors.addCommonError("Hay campos con errores en el formuarlio. Por favor revíselos.");
				return ViewPaths.INCIDENCIA;
			}

		} catch (Exception e) {
			// TODO
			errors.addCommonError("Error Creacion Asistencia");
			logger.error(e.getMessage(), e);
			return ViewPaths.INCIDENCIA;
		}		
	}
	
}
