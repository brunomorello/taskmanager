<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/controller" var="controllerRoot"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="widt=device-width, initial-scale=1">
	
	<c:import url="assets/thirdparty/bootstrap/bootstrap_css_import.jsp"/>
	
	<title>Login</title>
</head>
<body>
	
	<c:import url="assets/header/navbar.jsp"/>
	
	<div class="container mt-5">
		<div class="row">
			<div class="col-sm">
				<form action="${controllerRoot}" method="post">
					<div class="mb-3">
						<label for="login" class="form-label">Login</label>
						<input type="text" class="form-control" id="login" name="login" placeholder="Your ID" />
					</div>
					
					<div class="mb-3">
						<label for="pwd" class="form-label">Password</label>
						<input type="password" class="form-control" id="pwd" name="pwd" />
					</div>
					
					<input type="hidden" name="action" value="Login" />
					
					<c:if test="${not empty errorMessage}">
						<p>Not Authorized</p>
					</c:if>
					
					<div class="col-auto">
						<button type="submit" class="btn btn-primary mb-3">Login</button>
					</div>
				
				</form>				
			</div>
		</div>
	</div>
	<c:import url="assets/thirdparty/bootstrap/bootstrap_js_import.jsp"/>
</body>
</html>