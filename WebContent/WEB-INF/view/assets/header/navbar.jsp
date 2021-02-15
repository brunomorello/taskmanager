<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/controller?action=NewTaskForm" var="formTask" />
<c:url value="/controller" var="taskUri"/>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Taskmanager</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navitagion">
			<span class="navbar-toggler-icon"></span>
		</button> 
		
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item">
					<a class="nav-link active" aria-current="page" href="/taskmanager/controller?action=ListTask">Home</a>
				</li>
				
				<c:if test="${not empty logedUser}">
					<li class="nav-item">
						<a class="nav-link" href="${formTask}">Create Task</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">Create Task Category</a>
					</li>
				</c:if>
			</ul>
			
			<c:if test="${not empty logedUser}">
				<span class="navbar-text me-2">
					Hello ${logedUser.firstName}
				</span>
				<form class="d-flex" method="get" action="${taskUri}?action=GetTask&uuid=a8814fbf-f023-4442-8661-c4a7997084fc">
					<input class="form-control me-2" type="search" placeholder="Search a Task" aria-label="Search">
					<button class="btn btn-light me-2" type="submit">Search</button>
				</form>
				<a class="btn btn-danger" href="controller?action=Logout">Logout</a>
			</c:if>
		</div>
	</div>
</nav>