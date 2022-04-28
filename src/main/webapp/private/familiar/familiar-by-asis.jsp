<%@include file="/common/header.jsp" %>


	 <div class="col-md-12">
	 
	 <h5><a href="<%=ControllerPath.MAIN_CONTEXT%>private/familiar/familiar-search.jsp">Aceptar familar</a></h5>
	 
	 <table>
	 	<tr>
			<td>Nombre</td>
			<td>1º Apellido</td>
			<td>2º Apellido</td>
			<td></td>
		</tr>
	 	<%
		List<FamiliarDTO> familiar = (List<FamiliarDTO>) request.getAttribute(AttributeNames.FAMILIARES);
		for(FamiliarDTO f: familiar){
	%>
	<tr>
			<td><%=f.getNombre()%></td>
			<td><%=f.getApellido1()%></td>
			<td><%=f.getApellido2()%></td>
			<td><a href="<%=ControllerPath.MAIN_CONTEXT%>asistido?action=<%=ActionNames.FAMILIAR_DELETE%>&<%=ParameterNames.FAMILIAR_ID%>=<%=f.getId()%>">Eliminar</a></td>
	 </tr>
	 
	 
	 <%} %>
	 </table>
	 
	 </div>





<%@include file="/common/footer.jsp" %>