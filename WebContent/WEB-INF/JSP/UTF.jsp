<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="styles/default.css">
<title>UTF binairy printer</title>
</head>

<body>

	<h1>UTF binairy printer</h1>

	<c:url var="UTF" value="/TextToUTF" />

	<form action="${UTF}" method="POST">

		<p>Typ hier de brontekst in</p>

		<input class="input" type="text" name="broncode"> <br />
		<br /> <input class="submit" type="submit" value="Encodeer!">

	</form>

	<h2>${error}${boodschap}</h2>

	<c:url var="index" value="/IndexServlet" />

	<a class="HPbutton" href="${index}">Home Page</a>

</body>
</html>