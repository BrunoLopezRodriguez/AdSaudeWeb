


<!-- Navegador de medico -->
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
				<li class="nav-item"><a href="<%=ControllerPath.MAIN_CONTEXT%>private/asistencia/asistencia-search.jsp" class="nav-link">Asistencias</a></li>
				<li class="nav-item"><a href="<%=ControllerPath.MAIN_CONTEXT%>index.jsp" class="nav-link">Mi Perfil:<%=usuario.getNombre()%></a></li>
				<li class="nav-item"><a href="<%=ControllerPath.MAIN_CONTEXT%>asistido?action=<%=ActionNames.LOGOUT%>" class="nav-link">LogOut</a></li>
			</ul>
		</div>
	</div>
</nav>