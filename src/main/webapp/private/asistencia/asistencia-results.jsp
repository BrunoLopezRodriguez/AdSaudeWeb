<%@include file="/common/header.jsp" %>


<table>
<tr>
<td>Nombre Del Asistido</td>
<td>Nombre del Empleado</td>
<td>Nombre del Servicio</td>
</tr>

<%
	Results<AsistenciaDTO> results = (Results<AsistenciaDTO>) request.getAttribute(AttributeNames.ASISTENCIA_RESULTS);
	List<AsistenciaDTO> asistencias = results.getData();
	for(AsistenciaDTO a: asistencias){
	%>
	<tr>
	<td> <%=a.getNombreAsistido()%> </td>
	<td> <%=a.getNombreEmpleado()%> </td>
	<td> <%=a.getNombreServicio()%> </td>	
	
	</tr>
	<%
	}
%>
</table>
<!--  Paginador -->
<ul>
								<%
									Integer currentPage = (Integer) request.getAttribute(AttributeNames.CURRENT_PAGE);
								
									Integer pagingFrom = (Integer) request.getAttribute(AttributeNames.PAGING_FROM);
									Integer pagingTo = (Integer) request.getAttribute(AttributeNames.PAGING_TO);
									
									Integer totalPages = (Integer) request.getAttribute(AttributeNames.TOTAL_PAGES);
									
									Map<String,String[]> parameters = new HashMap<String, String[]>(request.getParameterMap());								
									parameters.remove(ParameterNames.PAGE); // para que no arrastre el valor anterior
									
									// Ya viene terminada en &
									String baseURL = ParameterUtils.getURLPaginacion(request.getContextPath()+"/asistido", parameters);
	
									
									// Primera
									if (currentPage>1) {
										%> 
										<li><a href="<%=baseURL%>">Primera</a></li>
										<%
									}
	
									
									// Anterior
									if (currentPage>1) {
										%> 
										<li><a href="<%=baseURL+ParameterNames.PAGE+"="+(currentPage-1)%>">Anterior</a></li>
										<%
									}
									
									// Paginas antes de la actual
									for (int i = pagingFrom; i<currentPage; i++) {
											%> 
											<li>&nbsp;<a href="<%=baseURL+ParameterNames.PAGE+"="+i%>"><%=i%></a>&nbsp;</li>
											<% 
									}	
									
									// La actual
									%>&nbsp;<span class="paginacion_activa"><%=currentPage%></span>&nbsp;<%
									
									// Despues de la actual
									for (int i = currentPage+1; i<=pagingTo; i++) {
											%> 
											<li>&nbsp;<a href="<%=baseURL+ParameterNames.PAGE+"="+i%>"><%=i%></a>&nbsp;</li>
											<% 
									}
									
									// Siguiente
									if (currentPage<totalPages) {
										%>
											<li><a href="<%=baseURL+ParameterNames.PAGE+"="+(currentPage+1)%>">Siguiente</a></li>
										<%
									}
									
									
									// Última
									if (currentPage<totalPages) {
										%>
											<li><a href="<%=baseURL+ParameterNames.PAGE+"="+(totalPages)%>">Última</a></li>
										<%
								}
									
									%>
									</ul>


<%@include file="/common/footer.jsp" %>