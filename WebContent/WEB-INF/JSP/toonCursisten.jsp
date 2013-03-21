<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="styles/default.css">
<title>De Cursisten</title>
</head>

<body>

	<h1>De Cursisten</h1>
	
	<h2>opgehaald uit DB met CursistDAO.findAll()</h2>

	<table border=1>

		<tr>

			<th>ID</th>
			<th>Naam</th>
			<th>CursisNummer</th>

		</tr>

		<c:forEach var="cursist" items="${cursisten}">

			<tr>

				<td>${cursist.idCursist}</td>
				<td>${cursist.naam}</td>
				<td>${cursist.cursisNummer}</td>

			</tr>

		</c:forEach>

	</table>
	
	<h1>De Cursisten</h1>
	
	<h4>opgehaald uit DB met CursistDAO.read(int idCursist)</h4>
	
		<table border=1>

		<tr>

			<th>ID</th>
			<th>Naam</th>
			<th>CursisNummer</th>

		</tr>

		<c:forEach var="cursist" items="${cursistenTwee}">

			<tr>

				<td>${cursist.idCursist}</td>
				<td>${cursist.naam}</td>
				<td>${cursist.cursisNummer}</td>

			</tr>

		</c:forEach>

	</table>
	
	<br/>

	<c:url var="index" value="/IndexServlet" />

	<a class="HPbutton" href="${index}">Home Page</a>

</body>

</html>