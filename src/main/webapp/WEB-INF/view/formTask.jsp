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
	<meta name="viewport" content="widt=device-width, initial-scale=1">
	<c:import url="assets/thirdparty/bootstrap/bootstrap_css_import.jsp"/>
	<title>Task Form</title>
</head>
<body>

	<c:import url="assets/header/navbar.jsp"/>
	
	<div class="container mp-3">
	
		<c:if test="${empty task.uuid}">
			<form action="${newTaskUri}" method="post">		
		</c:if>
		
		<c:if test="${not empty task.uuid}">
			<form action="${updateTaskUri}" method="post">
		</c:if>
		
			<div class="form-floating mb-3 mt-3">
				<input type="text" class="form-control" name="taskDescription" placeholder="Task Description" value="${task.description}" />
				<label for="taskDescription" class="form-label">Description</label>
			</div>
				
			<div class="form-floating mb-3">
				<textarea class="form-control" placeholder="Provide Task Details" id="taskLongDescription" name="taskLongDescription"></textarea>
				<label for="taskLongDescription">Details</label>
			</div>
			
			<div class="form-floating mb-3">
				<fmt:parseDate value="${task.dueDate}" pattern="YYYY-MM-dd" var="taskDueDate" type="date"/>
				<input type="text" class="form-control" id="dueDate" name="dueDate" value="<fmt:formatDate value='${taskDueDate}' pattern='YYYY-MM-dd'/>" placeholder="YYYY-MM-dd"/>
				<label for="dueDate">Due Date</label>
			</div>
			
			<input type="hidden" name="uuid" value="${task.uuid}"/>
			
			
			<c:if test="${empty task.uuid}">
				<button type="submit" class="btn btn-primary mb-3">Create Task</button>	
			</c:if>
		
			<c:if test="${not empty task.uuid}">
				<button type="submit" class="btn btn-primary mb-3">Update Task</button>
			</c:if>
			
			
		</form>		
	</div>
	
	<c:import url="assets/thirdparty/bootstrap/bootstrap_js_import.jsp"/>
</body>
</html>