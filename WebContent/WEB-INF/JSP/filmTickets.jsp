<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/default.css">
<title>Voorstellingen</title>
</head>
<body>

	<c:if test="${not empty voorstellingen}">

		<c:url var="filmTicket" value="/FilmTicket" />

		<form action="${filmTicket}" method="POST">

			<input type="hidden" name="taak" value="bestellen">

			<h1>Beschikbare voorstellingen</h1>

			<table border=1>

				<tr>
					<th>Titel</th>
					<th>Prijs</th>
					<th>Score</th>
					<th>Duur</th>
				</tr>

				<c:forEach var="film" items="${voorstellingen}">

					<tr>
						<td>${film.titel}</td>
						<td>${film.prijs} &#36;</td>
						<td>${film.score}</td>
						<td>${film.duur} minuten</td>
						<td class="noBorder" ><input class="submit" type="submit" value="bestel" name="${film.titel}" /></td>
					</tr>

				</c:forEach>

			</table>

		</form>

	</c:if>

	<c:if test="${not empty bestellingen}">

		<c:url var="filmTicket" value="/FilmTicket" />

		<form action="${filmTicket}" method="POST">

			<input type="hidden" name="taak" value="verwijderen">

			<h1>Voorstelling mandje</h1>

			<table border=1>

				<tr>
					<th>Titel</th>
					<th>Prijs</th>
					<th>Score</th>
					<th>Duur</th>
				</tr>

				<c:forEach var="film" items="${bestellingen}">

					<tr>
						<td>${film.titel}</td>
						<td>${film.prijs} &#36;</td>
						<td>${film.score}</td>
						<td>${film.duur} minuten</td>
						<td class="noBorder" ><input class="submit" type="submit" value="verwijder" name="${film.titel}" /></td>
					</tr>

				</c:forEach>

			</table>

		</form>

	</c:if>

	<br/>

	<c:url var="index" value="/IndexServlet" />

	<a class="HPbutton" href="${index}">Home Page</a>

</body>
</html>