<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!doctype html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="styles/default.css">
<title>Sessions</title>
</head>

<body>

<ul>

<c:forEach var="string" items="${lijst}">

<li>${string}</li>

</c:forEach>

</ul>

<c:url var="postURL" value="/Sessions"/>

<form action="${postURL}" method="POST">

<input class="input" type="text" name="nieuweString"/><br/>

<input class="button" type="submit" value="Voeg String toe"/>

</form>

<!-- 
	Met deze EL expressie kan je een session attribuut
	rechtstreeks aanspreken in de JSP. Als dit session
	attribuut niet bestaat krijg je hier niets te zien.
	Als er session attribuut dezelfde naam heeft als een
	request attribuut moet je expliciet verwijzen naar de
	session op de volgende manier : ${sessionScope.eenSessionAttribuut}
	Anders krijg je het requet attribuut. (probeer dit uit)
	Het sessionScope object is een voorbeeld van een
	impliciet object in de JSP. (cfr. cookie object)
 -->
<h2>${eenSessionAttribuut}</h2>

<c:url var="invalidateSessionURL" value="/Invalidate"/>

<a class="button" href="${invalidateSessionURL}">Verwijder de session !</a><br/>

<c:url var="index" value="/IndexServlet"/>

<a class="HPbutton" href="${index}">Home Page</a>

</body>

</html>