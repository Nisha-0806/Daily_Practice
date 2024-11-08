<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.details.Employee;" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
	<h1>Edit Employee</h1>

	<form action="EditData">
		<% Employee e=(Employee)session.getAttribute("e");%>
	
	Designation<input type="text" name="desig" value="<%=e.getDesig()%>"><br>
	Salary<input type="number" name="salary  value="<%=e.getSalary()%>"><br>
	Password<input type="password" name="password" value="<%=e.getPassword()%>"><br>
		<input type="button" value="Edit"><br>
	</form>

</body>
</html>