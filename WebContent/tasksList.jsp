<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, br.com.bmo.taskmanager.model.TaskModel" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Tasks</title>
</head>
<body>
	<ul>
		<c:forEach items="${tasksList}" var="task">
			<li>
				<b>Task:</b> ${task.description} -
				<b>Created At:</b> <fmt:formatDate value="${task.createdAt}" pattern="YYYY-MM-dd"/> -
				<b>Due Date:</b> <fmt:formatDate value="${task.dueDate}" pattern="YYYY-MM-dd"/>
			</li>
		</c:forEach>
	</ul>
</body>
</html>