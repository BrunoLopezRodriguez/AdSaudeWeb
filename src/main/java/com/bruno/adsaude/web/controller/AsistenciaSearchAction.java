package com.bruno.adsaude.web.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.model.AsistenciaCriteria;
import com.bruno.adsaude.model.AsistenciaDTO;
import com.bruno.adsaude.model.Results;
import com.bruno.adsaude.model.UsuarioDTO;
import com.bruno.adsaude.service.AsistenciaService;
import com.bruno.adsaude.service.impl.AsistenciaServiceImpl;
import com.bruno.adsaude.web.controller.util.ActionNames;
import com.bruno.adsaude.web.controller.util.AttributeNames;
import com.bruno.adsaude.web.controller.util.ErrorNames;
import com.bruno.adsaude.web.controller.util.ParameterNames;
import com.bruno.adsaude.web.controller.util.ViewPaths;
import com.bruno.adsaude.web.controller.util.WebPagingUtils;

public class AsistenciaSearchAction extends Action{

	private static Logger logger = LogManager.getLogger(AsistenciaSearchAction.class);
	private AsistenciaService asistenciaService=null;
	// TODO sacar de configuracion
		private static int PAGE_SIZE = 1; 
		private static int PAGE_COUNT = 3;
	public AsistenciaSearchAction() {
		super(ActionNames.ASISTENCIA_SEARCH);
		asistenciaService = new AsistenciaServiceImpl();
	
	}
	
	public final String doIt(HttpServletRequest request, HttpServletResponse response) {
		UsuarioDTO usuario = (UsuarioDTO) request.getSession().getAttribute(AttributeNames.USUARIO);
		Integer tipo = usuario.getTipo();
		Errors errors = new Errors();
		request.setAttribute(AttributeNames.ERRORS , errors);
		Integer asistidoId=null;
		Integer asistenciaId=null;
		Integer empleadoId=null;
		Date fechaDesde=null;
		Date fechaHasta=null;
		try {
			
		String fechaDesdeStr= request.getParameter(ParameterNames.FECHA_DESDE);
		String fechaHastaStr= request.getParameter(ParameterNames.FECHA_HASTA);
		String asistidoIdStr=request.getParameter(ParameterNames.ASISTIDO_ID);
		String asistenciaIdStr= request.getParameter(ParameterNames.ASISTENCIA_ID);
		String empleadoIdStr= request.getParameter(ParameterNames.EMPLEADO_ID);
		
		if(!StringUtils.isBlank(fechaDesdeStr)) {
			fechaDesde= Date.valueOf(fechaDesdeStr);
		}else {
			Date a = new Date(System.currentTimeMillis());
			fechaDesde= a;
		}
		if(!StringUtils.isBlank(fechaDesdeStr)) {
			fechaHasta= Date.valueOf(fechaHastaStr);
		}else {
			Date a = new Date(System.currentTimeMillis());
			fechaDesde= a;
		}
		if (!StringUtils.isBlank(asistidoIdStr)) {
			asistidoId=Integer.valueOf(asistidoIdStr);
		}else {
			asistidoId=Integer.valueOf(null);
		}
		if (!StringUtils.isBlank(asistenciaIdStr)) {
			asistenciaId=Integer.valueOf(asistenciaIdStr);
		}else {
			asistenciaId=Integer.valueOf(null);
		}
		if(!StringUtils.isBlank(empleadoIdStr)) {
			 empleadoId=Integer.valueOf(empleadoIdStr);
		}else {
			empleadoId=Integer.valueOf(null);
		}
			 
		AsistenciaCriteria c = new AsistenciaCriteria();
		
		c.setFechaHoraInicio(fechaDesde);
		c.setFechaHoraFin(fechaHasta);
		
		if(tipo==20||tipo==10) {
			c.setIdAsistido(usuario.getId());
		}else {
			c.setIdAsistido(asistidoId);
		}
		if(tipo==30||tipo==40) {
			c.setIdAsistido(usuario.getId());
		}else {
			c.setIdEmpleado(empleadoId);
		}
		c.setIdServicio(asistenciaId);
		
		Integer currentPage = WebPagingUtils.getCurrentPage(request);
		Results<AsistenciaDTO> as = asistenciaService.findByCriteria(c,(currentPage-1)*PAGE_SIZE +1, PAGE_SIZE);
		
		request.setAttribute(AttributeNames.ASISTENCIA_RESULTS, as);
		// Atributos para paginacion
		request.setAttribute(AttributeNames.CURRENT_PAGE, currentPage);					
		request.setAttribute(AttributeNames.PAGING_FROM, WebPagingUtils.getPageFrom(currentPage, PAGE_COUNT, (int) as.getTotal()));
		request.setAttribute(AttributeNames.PAGING_TO, WebPagingUtils.getPageTo(currentPage, PAGE_COUNT, (int) as.getTotal()) );
		request.setAttribute(AttributeNames.TOTAL_PAGES, WebPagingUtils.getTotalPages((int)as.getTotal(), PAGE_SIZE));
		

		
		}catch(Exception e) {
			logger.error(e.getMessage(), e);
			errors.addCommonError(ErrorNames.ERR_GENERIC);
			return ViewPaths.ASISTENCIA_SEARCH;
		}
		return ViewPaths.ASISTENCIA_RESULTS;
	}
}
