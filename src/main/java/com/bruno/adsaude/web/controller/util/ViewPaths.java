package com.bruno.adsaude.web.controller.util;

public class ViewPaths {
	
	public static final String ASISTIDO = "/asistido/....";

	public static final String HOME = "/index.jsp";
	
	public static final String ASISTENCIA_RESULTS = "/private/asistencia/asistencia-results.jsp";
	public static final String ASISTENCIA_SEARCH = "/private/asistencia/asistencia-search.jsp";
	public static final String USUARIO_LOGIN = "/common/login-asistido.jsp";
	public static final String USUARIO_EMPL_LOGIN = "/common/login-empleado.jsp";
	public static final String USUARIO_SELECT_LOGIN = "/common/select-login.jsp";
	public static final String USUARIO_MED_LOGIN = "/common/login-medico.jsp";
	public static final String USUARIO_FAM_LOGIN = "/common/login-familiar.jsp";
	public static final String USUARIO_MY_PROFILE = "/private/my-profile.jsp";
	public static final String USUARIO_MY_PROFILE_EDITAR = "/private/my-profile-editar.jsp";
	public static final String USUARIO_SEARCH = "/asistido/asistido-search";
	public static final String USUARIO_RESULTS = "/asistido/asistido-results";
	public static final String REGISTRO_AS = "/common/register-asistido.jsp";
	public static final String REGISTRO_FA = "/common/register-familiar.jsp";
	public static final String FAMILIARES_BY_ASIS = "/private/familiar/familiar-by-asis.jsp";

	public static final String FAMILIARES_BY_ASIS_RETURN = "/asistido?action="+ActionNames.FAMILIAR_BY_ASIS;
	public static final String FAMILIAR_RESULTS = "/private/familiar/familiar-results.jsp";
	public static final String INCIDENCIA = "/private/incidencia.jsp";
	public static final String INCIDENCIA_CREADA = "/private/incidencia-creada.jsp";
	public static final String INCIDENCIA_RESULTS = "/private/incidencia-results.jsp";
	public static final String CONTRATO_RESULTS = "/private/contrato/contrato-results.jsp";
	public static final String SERVICIO_DETAIL = "/private/servicios/servicio-detail.jsp";
	public static final String SERVICIO_SEARCH = "/private/servicios/servicio-search.jsp";
	public static final String RUTA_RESULTS = "/private/ruta/ruta-results.jsp";
	public static final String CONTRATO_RESULTS_RETURN = "/asistido?action="+ActionNames.COMPRA_SEARCH;
}
