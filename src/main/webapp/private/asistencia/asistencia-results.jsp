<%@ page import="java.util.List, com.bruno.adsaude.model.AsistenciaDTO" %>
<%@include file="/common/header.jsp" %>


<table>
<tr>
<td>Nombre Del Asistido</td>
<td>Nombre del Empleado</td>
<td>Nombre del Servicio</td>
</tr>

<%
	List<AsistenciaDTO> asistencia = (List<AsistenciaDTO>) request.getAttribute("asistencias");
	for(AsistenciaDTO a: asistencia){
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

<%@include file="/common/footer.jsp" %>