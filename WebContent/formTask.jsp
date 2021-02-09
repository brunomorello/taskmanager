<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/task" var="newTaskUri"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task Form</title>
</head>
<body>
	<form action="${newTaskUri}" method="post">
		<label>Description</label>
		<input type="text" name="taskName" value="${task.description}"/>
		
		<label>Due Date</label>
		<input type="text" name="dueDate" value="<fmt:formatDate value='${task.dueDate}' pattern='YYYY-MM-dd'/>"/>
		
		<input type="hidden" name="uuid" value="${task.uuid}"/>
		
		<input type="submit" value="Submit" />
	</form>
</body>
</html>