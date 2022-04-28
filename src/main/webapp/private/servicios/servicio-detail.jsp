<%@include file="/common/header.jsp" %>
	<%
		TipoServicio tipoServicio = (TipoServicio) request.getAttribute(AttributeNames.TIPO_SERVICIO_HIJA);
	%>
	

	<div class="col-md-12">
	
	<img src="/ADSaudeWeb/css/img/tipo-servicio<%=tipoServicio.getId()%>.png" alt="Imagen del tipo de servicio" width="500" height="600">
	
	<table>
	 	<tr>
			<td><%=tipoServicio.getNombre() %></td>
		</tr>
		<tr>
			<td><%=tipoServicio.getTiempoEstimado() %></td>
		</tr>
		<tr>
			<td><%=tipoServicio.getDescripcion()%></td>
		</tr>
	 </table>
	</div>


<%@include file="/common/footer.jsp" %>