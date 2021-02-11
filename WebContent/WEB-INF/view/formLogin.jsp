<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/controller" var="controllerRoot"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="${controllerRoot}" method="post">
		<label>Login:</label>
		<input type="text" name="login" />
		
		<label>Password:</label>
		<input type="password" name="pwd" />
		
		<input type="hidden" name="action" value="Login" />
		
		<input type="submit" value="Login" />
	</form>
</body>
</html>