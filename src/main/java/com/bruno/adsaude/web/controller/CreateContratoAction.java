package com.bruno.adsaude.web.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.model.Contrato;
import com.bruno.adsaude.model.ContratoTipoServicio;
import com.bruno.adsaude.model.UsuarioDTO;
import com.bruno.adsaude.service.ContratoService;
import com.bruno.adsaude.service.impl.ContratoServiceImpl;
import com.bruno.adsaude.web.controller.util.ActionNames;
import com.bruno.adsaude.web.controller.util.AttributeNames;
import com.bruno.adsaude.web.controller.util.ParameterNames;
import com.bruno.adsaude.web.controller.util.ViewPaths;

public class CreateContratoAction extends Action{
	
	private static Logger logger = LogManager.getLogger(CreateContratoAction.class);
	private ContratoService contratoService=null;
	
	
	public CreateContratoAction(){
		super(ActionNames.CREATE_CONTRATO);
		contratoService= new ContratoServiceImpl();
	}
	public final String doIt(HttpServletRequest request, HttpServletResponse response) {
		UsuarioDTO usuario = (UsuarioDTO) request.getSession().getAttribute(AttributeNames.USUARIO);
			Map<String, String[]> mapParameter = request.getParameterMap();
			Errors errors = new Errors();
			request.setAttribute(AttributeNames.ERRORS , errors);
			Contrato contrato = new Contrato();
			ContratoTipoServicio cts = new ContratoTipoServicio();
			Date fechaInicio=null;
			Date fechaFin = null;
			Integer servicioHija=null;
			List<ContratoTipoServicio> contratos = new ArrayList<ContratoTipoServicio>();
			
			
			String fechaInicioStr = request.getParameter(ParameterNames.FECHA_INICIO);
			String fechaFinStr =request.getParameter(ParameterNames.FECHA_FIN);
			String idServicioStr =request.getParameter(ParameterNames.SERVICIO_HIJA);
			String descripcionContratoStr = request.getParameter(ParameterNames.DESCRPCION_CONTRATO);
			
			
			if(!StringUtils.isBlank(fechaInicioStr)) {
				fechaInicio= Date.valueOf(fechaInicioStr);	
				contrato.setFechaInicio(fechaInicio);;
			}else {
				errors.addParameterError(ParameterNames.FECHA_INICIO, "El parametro no coincide");
			}

			if(!StringUtils.isBlank(fechaFinStr)) {
				fechaFin= Date.valueOf(fechaFinStr);	
				contrato.setFechaFin(fechaFin);
			}else {
				errors.addParameterError(ParameterNames.FECHA_FIN, "El parametro no coincide");
			}

			if(!StringUtils.isBlank(idServicioStr)) {
				servicioHija = Integer.valueOf(idServicioStr);
				cts.setIdTipoServicio(servicioHija);
			}else {
				errors.addParameterError(ParameterNames.SERVICIO_HIJA, "El parametro no coincide");
			}

			if(!StringUtils.isBlank(descripcionContratoStr)) {
				cts.setDescripcion(descripcionContratoStr);
			}else {
				errors.addParameterError(ParameterNames.DESCRPCION_CONTRATO, "El parametro no coincide");
			}
			
			try {
				if(!errors.hasErrors()) {
					contrato.setIdAsistido(usuario.getId());
					contratos.add(cts);
					contratoService.create(contrato,contratos);
					return ViewPaths.CONTRATO_RESULTS;

				} else {
					errors.addCommonError("Hay campos con errores en el formuarlio. Por favor revíselos.");
					return ViewPaths.CONTRATO_RESULTS;
				}

			} catch (Exception e) {
				// TODO
				errors.addCommonError("Error Creacion Asistencia");
				logger.error(e.getMessage(), e);
				return ViewPaths.CONTRATO_RESULTS;
			}		
		}

}
