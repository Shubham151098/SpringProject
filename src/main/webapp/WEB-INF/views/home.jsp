<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<h1>Welcome Page</h1>
	
	<form action="saveReg" method="post">
	<pre>
		Name: <input type="text" name="name" />
		City: <input type="text" name="city" />
		Email: <input type="text" name="email" />
		Mobile: <input type="text" name="mobile" /> 
		<input type="submit" value="Submit" />
	</pre>
	</form>
	${msg}
</body>
</html>