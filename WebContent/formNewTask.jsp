<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/task" var="newTaskUri"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${newTaskUri}" method="post">
		<label>Name</label>
		<input type="text" name="taskName"/>
		
		<label>Due Date</label>
		<input type="text" name="dueDate"/>
		
		<input type="submit" value="Submit" />
	</form>
</body>
</html>