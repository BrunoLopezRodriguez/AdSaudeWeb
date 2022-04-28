


<!-- Navegador por defecto -->
<nav
	class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
	id="ftco-navbar">
	<div class="container">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#ftco-nav" aria-controls="ftco-nav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="fa fa-bars"></span> Menu
		</button>

		<div class="collapse navbar-collapse" id="ftco-nav">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a href="<%=ControllerPath.MAIN_CONTEXT%>index.jsp" class="nav-link">Inicio</a></li>
				<li class="nav-item"><a href="<%=ControllerPath.MAIN_CONTEXT%>private/servicios/servicios-search.jsp" class="nav-link">Servicios</a></li>
				<li class="nav-item"><a href="<%=ControllerPath.MAIN_CONTEXT%>asistido?action=<%=ActionNames.COMPRA_SEARCH %>" class="nav-link">Comprar</a></li>
				<li class="nav-item"><a href="<%=ControllerPath.MAIN_CONTEXT%>private/asistencia/asistencia-search.jsp" class="nav-link">Asistencias</a></li>
				<li class="nav-item"><a href="<%=ControllerPath.MAIN_CONTEXT%>private/incidencia.jsp" class="nav-link">Incidencias</a></li>
				<li class="nav-item"><a href="<%=ControllerPath.MAIN_CONTEXT%>asistido?action=<%=ActionNames.FAMILIAR_BY_ASIS%>" class="nav-link">Familiares</a></li>
				<li class="nav-item"><a href="<%=ControllerPath.MAIN_CONTEXT%>common/select-login.jsp" class="nav-link">Iniciar Sesion</a></li>
				<li class="nav-item"><a href="<%=ControllerPath.MAIN_CONTEXT%>common/select-register.jsp" class="nav-link">Registrate</a></li>
			</ul>
		</div>
	</div>
</nav>