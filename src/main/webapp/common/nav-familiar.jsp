


<!-- Navegador de familiar -->
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
				<li class="nav-item"><a href="/ADSaudeWeb/index.jsp" class="nav-link">Inicio</a></li>
				<li class="nav-item"><a href="/ADSaudeWeb/asistencia/asistencia-search.jsp" class="nav-link">Servicios</a></li>
				<li class="nav-item"><a href="services.html" class="nav-link">Cheking</a></li>
				<li class="nav-item"><a href="department.html" class="nav-link">Incidencias</a></li>
				<li class="nav-item"><a href="gallery.html" class="nav-link">Asistidos</a></li>
				<li class="nav-item"><a href="/ADSaudeWeb/index.jsp" class="nav-link">Mi Perfil:<%=usuario.getNombre()%></a></li>
				<li class="nav-item"><a href="/ADSaudeWeb/asistido?action=<%=ActionNames.LOGOUT%>" class="nav-link">LogOut</a></li>
			</ul>
		</div>
	</div>
</nav>