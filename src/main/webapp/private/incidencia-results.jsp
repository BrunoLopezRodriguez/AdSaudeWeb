<%@include file="/common/header.jsp" %>

<div class="col-md-12">
	 
	 <table>
	 	<tr>
			<td>Fecha</td>
			<td>Estado</td>
			<td>Resumen</td>
			<td>Descripcion</td>
		</tr>
	 	<%
		List<IncidenciaDTO> incidencia = (List<IncidenciaDTO>) request.getAttribute(AttributeNames.INCIDENCIA);
		for(IncidenciaDTO i: incidencia){
	%>
	<tr>
			<td><%=i.getFechaHora()%></td>
			<td><%=i.getNombreTipoEstadoIncidencia()%></td>
			<td><%=i.getResumen()%></td>
			<td><%=i.getDescripcion()%></td>
			<td><%=i.getNombreAsistidoAfectado()%></td>
	 </tr>
	 
	 
	 <%} %>
	 </table>
	 
	 </div>

 <%@include file="/common/footer.jsp" %>