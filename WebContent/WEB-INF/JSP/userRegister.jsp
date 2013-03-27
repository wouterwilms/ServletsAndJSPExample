<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="styles/default.css">
<title>Register</title>
</head>

<body>

	<div class="title">

		<h3>Registreer</h3>

	</div>

	<br/>

	<br/>

	<c:url var="add" value="/RegisterServlet" />

	<form action="${add}" method="POST">

		<label for="userName">Username</label> <input class="input"
			type="text" name="registerUserName" /><br /> <label for="password">Password</label>
		<input class="input" type="password" name="registerPassword" /><br />

		<input class="login" type="submit" value="Registreer" />
		
	</form>
	
	<br/>

	<c:url var="index" value="/IndexServlet" />

	<a class="HPbutton" href="${index}">Home Page</a>

	<c:if test="${addError}">
	
	<h5>FOUT! Username bestaat al!</h5>

	</c:if>
	
</body>

</html>