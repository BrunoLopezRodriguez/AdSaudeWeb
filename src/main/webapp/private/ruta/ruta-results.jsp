<%@include file="/common/header.jsp" %>

<div class="col-md-12">

 <table>
	 	<tr>
			<td>Dia de la semana</td>
			<td>Descripcion</td>
			
			
		</tr>
	 	<%
		List<RutaDTO> rutas = (List<RutaDTO>) request.getAttribute(AttributeNames.RUTAS);
		for(RutaDTO r: rutas){
	%>
	<tr>
			<td><%=r.getDiaSemana()%></td>
			<td><%=r.getDescripcion()%></td>
			
			
	 </tr>
	 
	 
	 <%} %>
	 </table>


</div>


 <%@include file="/common/footer.jsp" %>