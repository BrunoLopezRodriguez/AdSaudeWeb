<%@include file="/common/header.jsp" %>
	<%
		TipoServicio tipoServicio = (TipoServicio) request.getAttribute(AttributeNames.TIPO_SERVICIO_HIJA);
	%>
	

	<div class="col-md-12">
	
	<img src="/ADSaudeWeb/css/img/tipo-servicio<%=tipoServicio.getId()%>.jpg" alt="Imagen del tipo de servicio" width="400" height="300">
	
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