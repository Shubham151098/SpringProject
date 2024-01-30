<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
	<h1>Update Student Data</h1>
	<form action="update" method="post">
	<pre>
		<input type="hidden" name="id" value="${stud.id}"/>
		Name: <input type="text" name="name" value="${stud.name}"/>
		City: <input type="text" name="city" value="${stud.city}"/>
		Email: <input type="text" name="email" value="${stud.email}"/>
		Mobile: <input type="text" name="mobile" value="${stud.mobile}"/> 
		<input type="submit" value="Update" />
	</pre>
	</form>
</body>
</html>