<%@include file="/common/header.jsp"%>


	<div class="col-md-12">
		<%
			FamiliarDTO familiar = (FamiliarDTO) request.getAttribute(AttributeNames.FAMILIAR);
		%>
		
		<table>
			<tr>
				<td>Nombre</td>
				<td>1º Apellido</td>
				<td>2º Apellido</td>
				<td>NIF</td>
				<td>Telefono</td>
				<td>E-Mail</td>
				<td></td>
			</tr>
			<tr>
				<td><%=familiar.getNombre()%></td>
				<td><%=familiar.getApellido1()%></td>
				<td><%=familiar.getApellido2()%></td>
				<td><%=familiar.getNif()%></td>
				<td><%=familiar.getTlf()%></td>
				<td><%=familiar.getEmail()%></td>
				<td><a href="<%=ControllerPath.MAIN_CONTEXT%>asistido?action=<%=ActionNames.FAMILIAR_ASISTIDO_CREATE%>&<%=ParameterNames.FAMILIAR_ID%>=<%=familiar.getId()%>">Aceptar Relacion</a></td>
			</tr>
		</table>
	</div>


<%@include file="/common/footer.jsp"%>