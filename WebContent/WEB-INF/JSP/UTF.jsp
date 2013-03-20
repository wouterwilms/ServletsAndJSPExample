<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8" session="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UTF binairy printer</title>
</head>

<body>

	<h1>UTF binairy printer</h1>

	<c:url var="UTF" value="/TextToUTF" />

	<form action="${UTF}" method="POST">

		<p>Typ hier de brontekst in</p>

		<input type="text" name="broncode"> <br />
		<br /> <input type="submit" value="Encodeer!">

	</form>

	<h2>${error}${boodschap}</h2>

	<c:url var="index" value="/IndexServlet" />

	<a href="${index}">Home Page</a>

</body>
</html>