<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>De Cursisten</title>
</head>
<body>

	<h1>De Cursisten: opgehaald uit DB met be.intecbrussel.dao.CursistDAO.findAll()</h1>

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
	
	<h1>De Cursisten: opgehaald uit DB met be.intecbrussel.dao.CursistDAO.read(int idCursist)</h1>
	
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

	<a href="${index}">Home Page</a>

</body>
</html>