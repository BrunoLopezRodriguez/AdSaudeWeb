<%@include file="/common/header.jsp" %>




 <div class="col-md-12">
	 	<%
		ContratoDTO contrato = (ContratoDTO) request.getAttribute(AttributeNames.CONTRATO);
		
			%>
			
			<h3>No tienes un contrato con nosotros deseas crear uno?</h3>
			
			<h4><a href="<%=ControllerPath.MAIN_CONTEXT%>private/contrato/contrato-create.jsp">Crea tu contrato</a></h4>
	
	<%if(contrato!=null){ %>
	 <table>
	 	<tr>
			<td>Fecha inicio</td>
			<td>Fecha fin</td>
			<td>Nombre asistido</td>
			<td>Descripcion necesidad</td>
		</tr>
	<tr>
			<td><%=contrato.getFechaInicio()%></td>
			<td><%=contrato.getFechaFin()%></td>
			<td><%=contrato.getNombreAsistido()%></td>
			<td><%=contrato.getDescripcionNecesidad()%></td>
	 </tr>
	 
	 <%} %>
	
	 </table>
	 
	 </div>




<%@include file="/common/footer.jsp" %>