<%@ page import="java.util.List,com.bruno.adsaude.model.*,com.bruno.adsaude.web.controller.util.*, com.bruno.adsaude.web.controller.*" %>
 <%
 	Errors errors = (Errors) request.getAttribute(AttributeNames.ERRORS);
 	if (errors == null) {
 		errors = new Errors(); // Primera renderizacion
 	}
 
 	// Variable comun para los errors por parametro
 	String parameterError = null;
              	
 	List<String> commonErrors = errors.getCommonErrors();
 	if (commonErrors.size()>0) {
 %>
 	<div class="errors">
 		<%
 			for (String error: commonErrors) {
 				%><li><%=error %></li>
 			<%
        	}
        %>
    </div>
              
	<%
    }
	%>