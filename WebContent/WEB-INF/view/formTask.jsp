<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/controller?action=CreateTask" var="newTaskUri"/>
<c:url value="/controller?action=UpdateTask" var="updateTaskUri"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task Form</title>
</head>
<body>

	<c:if test="${empty task.uuid}">
		<form action="${newTaskUri}" method="post">		
	</c:if>
	
	<c:if test="${not empty task.uuid}">
		<form action="${updateTaskUri}" method="post">
	</c:if>
		<label>Description</label>
		<input type="text" name="taskName" value="${task.description}"/>
		
		<label>Due Date</label>
		<input type="text" name="dueDate" value="<fmt:formatDate value='${task.dueDate}' pattern='YYYY-MM-dd'/>"/>
		
		<input type="hidden" name="uuid" value="${task.uuid}"/>
		
		<input type="submit" value="Submit" />
	</form>
</body>
</html>