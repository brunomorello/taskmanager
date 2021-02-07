<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, br.com.bmo.taskmanager.model.TaskModel" %>
<%  List<TaskModel> tasksList = (List<TaskModel>) request.getAttribute("tasksList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Tasks</title>
</head>
<body>
	<ul>
	<% for (TaskModel taskModel : tasksList) { %>
		<li> <%= taskModel.getDescription() %></li>
	<% } %>
	</ul>
</body>
</html>