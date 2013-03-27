<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="styles/default.css">
<title>Logging in User</title>
</head>

<body>

	<div class="title">

		<h3>SecurityFilter</h3>

	</div>

	<br />
	<br />

	<c:url var="secret" value="/SecretPart" />

	<form action="${secret}" method="POST">

		<label for="userName">Username</label> <input class="input"
			type="text" name="loginUserName" /><br /> <label for="password">Password</label>
		<input class="input" type="password" name="loginPassword" /><br /> <input
			class="login" type="submit" value="Log In" />

	</form>

	<br/>
	
	<c:if test="${userNotFound}">
	
	<h5>Nu such user!</h5>
	
	</c:if>
	
	<c:if test="${wrongPassword}">
	
	<h5>Password is wrong!</h5>
	
	</c:if>
	
	<br/>

	<c:url var="reg" value="/RegisterServlet" />

	<a class="HPbutton" href="${reg}">Registreer</a>
	
	<br/>

	<c:url var="index" value="/IndexServlet" />

	<a class="HPbutton" href="${index}">Home Page</a>


</body>

</html>