<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, br.com.bmo.taskmanager.model.TaskModel" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/controller" var="taskUri"/>
<c:url value="/controller?action=NewTaskForm" var="formTask" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Tasks</title>
</head>
<body>
	<p>TODO Tasks:</p>
	<ul>
		<c:forEach items="${tasksList}" var="task">
			<li>
				<b>Task:</b> ${task.description} -
				<b>Created At:</b> <fmt:formatDate value="${task.createdAt}" pattern="YYYY-MM-dd"/> -
				<b>Due Date:</b> <fmt:formatDate value="${task.dueDate}" pattern="YYYY-MM-dd"/>
				<a href="${taskUri}?action=GetTask&uuid=${task.uuid}">Edit</a>
				<a href="${taskUri}?action=DeleteTask&uuid=${task.uuid}">Remove</a>
			</li>
		</c:forEach>
	</ul>
	<p>
		<a href="${formTask}">New task</a>
	</p>
</body>
</html>