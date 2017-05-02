<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Testando JSP</title>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ page import="persistencia.GerenteConexao" %>
<%@ page import="teste.TestaEmpregado" %>
<%@ page import="teste.User" %>
<%@ page import="teste.UserDAO" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
</head>
<body>
	<form action="Teste.jsp">
		<input type="text" class="form-control" name="nome" />
	</form>
	<%
		if(request.getParameter("nome") != null){
			User user = new User();
			user.setNome(request.getParameter("nome"));
			out.print("rolou");
			UserDAO userDAO = new UserDAO();
			userDAO.addUser(user);
		}
	%>
</body>
</html>