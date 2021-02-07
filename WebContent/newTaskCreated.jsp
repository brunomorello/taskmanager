<%
	//scriplet
	String taskDesc = (String) request.getAttribute("task");
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Task Created</h2>
	<p><%= taskDesc %></p>
</body>
</html>