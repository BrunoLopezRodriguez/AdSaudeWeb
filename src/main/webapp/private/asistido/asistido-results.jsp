<%@ page import="java.util.List, com.bruno.adsaude.model.AsistidoDTO" %>
<%@include file="/common/header.jsp" %>


<%
	List<AsistidoDTO> asistidos = (List<AsistidoDTO>) request.getAttribute("asistidos");
	for(AsistidoDTO a: asistidos){
	%>
	<p><%=a.getNombre()%> a <%=a.getApellido1()%></p>	
	
	
	
	<%
	}
%>


<%@include file="/common/footer.jsp" %>