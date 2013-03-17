<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
						<td><input type="submit" value="bestel" name="${film.titel}" /></td>
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
						<td>${film.prijs} &dollar;</td>
						<td>${film.score}</td>
						<td>${film.duur} minuten</td>
						<td><input type="submit" value="verwijder"
							name="${film.titel}" /></td>
					</tr>

				</c:forEach>

			</table>

		</form>

	</c:if>


	<c:url var="index" value="/IndexServlet" />

	<a href="${index}">Home Page</a>

</body>
</html>