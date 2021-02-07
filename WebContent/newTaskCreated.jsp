<%
	//scriplet
	// String taskDesc = (String) request.getAttribute("task");
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty task}">
		<h2>Task Created</h2>
		<p> ${ task } </p>
	</c:if>
	
	<c:if test="${empty task}">
		<p>No Tasks were found</p>
	</c:if>
</body>
</html>