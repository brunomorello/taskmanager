<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, br.com.bmo.taskmanager.model.TaskModel" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/controller" var="taskUri"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="widt=device-width, initial-scale=1">
	<c:import url="assets/thirdparty/bootstrap/bootstrap_css_import.jsp"/>
	<title>List Tasks</title>
</head>
<body>

	<c:import url="assets/header/navbar.jsp"/>
	
	<div class="container">
		<c:forEach items="${tasksList}" var="task">
			<div class="card m-3" style="width: 18rem;">
				<div class="card-body">
					<h5 class="card-title">${task.description}</h5>
					<h6 class="card-subtitle mb-2 text-muted">
						<b>Due Date:</b> <fmt:formatDate value="${task.dueDate}" pattern="YYYY-MM-dd"/>
					</h6>
					<p class="card-text">${task.longDescription}</p>
	
					<a href="${taskUri}?action=GetTask&uuid=${task.uuid}" class="card-link">Edit</a>
					<a href="${taskUri}?action=DeleteTask&uuid=${task.uuid}" class="card-link">Remove</a>
				</div>
			</div>
		</c:forEach>		
	</div>
	
	<c:import url="assets/thirdparty/bootstrap/bootstrap_js_import.jsp"/>
</body>
</html>