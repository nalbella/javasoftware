<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.hibernate.Query,
java.util.List,
com.microforum.gestorencuestas.entities.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Query query=(Query)request.getAttribute("query");
		List<Usuario> usuarios=query.list();
		
	%>
	<table align="center" border="2">
		<tr><th>Nombre</th><th>Direccion</th></tr>
	<%
		for(Usuario user:usuarios){
	%>
	<tr><td><%=user.getNombreCompleto() %></td>
	<td><%=user.getDomicilio() %></td></tr>
	<%
		}
	%>
	</table>
</body>
</html>