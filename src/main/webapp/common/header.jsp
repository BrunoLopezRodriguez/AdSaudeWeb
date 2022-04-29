<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!--  <meta charset="utf-8">-->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/ADSaudeWeb/css/css/myownstyle.css">
<link rel="stylesheet" href="/ADSaudeWeb/css/css/animate.css">

<link rel="stylesheet" href="/ADSaudeWeb/css/css/owl.carousel.min.css">
<link rel="stylesheet" href="/ADSaudeWeb/css/css/owl.theme.default.min.css">
<link rel="stylesheet" href="/ADSaudeWeb/css/css/magnific-popup.css">

<link rel="stylesheet" href="/ADSaudeWeb/css/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="/ADSaudeWeb/css/css/jquery.timepicker.css">

<link rel="stylesheet" href="/ADSaudeWeb/css/css/flaticon.css">
<link rel="stylesheet" href="/ADSaudeWeb/css/css/style.css">
<meta charset="ISO-8859-1">
<script src="/ADSaudeWeb/css/js/jquery.min.js"></script>


<title>AdSaude - Tu aplicación de ayuda social</title>

<%@ page import="com.bruno.adsaude.model.*, com.bruno.adsaude.web.controller.*, com.bruno.adsaude.web.controller.util.*, java.util.*"%>
</head>
<body>

	<div class="wrap">
		<div class="container">
			<div class="row justify-content-between">
				<div class="col-md-3 mb-md-0 mb-4 d-flex align-items-center">
					<a class="navbar-brand" href="index.jsp">AdSaude</a>
				</div>
				<div class="col-md-7">
					<div class="row">
						<div class="col-md-8 mb-md-0 mb-3">
							<div class="top-wrap d-flex">
								<div
									class="icon d-flex align-items-center justify-content-center">
									<span class="fa fa-location-arrow"></span>
								</div>
								<div class="text">
									<span>Direccion</span><span> Galicia, Chantada 27500</span>
								</div>
							</div>
						</div>
						<div class="col">
							<div class="top-wrap d-flex">
								<div
									class="icon d-flex align-items-center justify-content-center">
									<span class="fa fa-phone"></span>
								</div>
								<div class="text">
									<span>Telefono</span><span>(+36) 982 000 000</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
			<%
          	UsuarioDTO usuario = (UsuarioDTO) SessionManager.get(request, AttributeNames.USUARIO);
          	
          	if (usuario==null) {
          %>   
		<%@include file="/common/nav-default.jsp"%>
		<% } else if (usuario.getTipo() == AsistidoDTO.TIPO) { %>
		<%@include file="/common/nav-asistido.jsp"%>
		<% } else if  (usuario.getTipo() == FamiliarDTO.TIPO) { %>
		<%@include file="/common/nav-familiar.jsp"%>
		<% } else if  (usuario.getTipo() == MedicoDTO.TIPO) { %>
		<%@include file="/common/nav-medico.jsp"%>
		<% } else if  (usuario.getTipo() == EmpleadoDTO.TIPO) { %>
		<%@include file="/common/nav-empleado.jsp"%>
		<% } %>
		
		<%@include file="/common/errors.jsp"%>
		
		
		
		
	