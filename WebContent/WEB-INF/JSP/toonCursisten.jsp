<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>De Cursisten</title>
</head>
<body>

<h1>De Cursisten</h1>

<table border = 1 >

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

</body>
</html>