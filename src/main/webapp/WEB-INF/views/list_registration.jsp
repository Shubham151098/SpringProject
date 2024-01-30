<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="menu.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Students</title>
</head>
<body>
	<h1>All Students</h1>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>City</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Delete</th>
			<th>Update</th>
			
		</tr>
		<c:forEach var="stud" items="${studs}">
		<tr>
			<td>${stud.name}</td>
			<td>${stud.city}</td>
			<td>${stud.email}</td>
			<td>${stud.mobile}</td>
			<td><a href="delete?id=${stud.id}">delete</a></td>
			<td><a href="getStudById?id=${stud.id}">Update</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>