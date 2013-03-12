<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="false"%>

<!-- 
 	Dit is een taglib directive : hiermee laat je weten dat je de core 
	tag library van JSTL wilt gebruiken in deze JSP. Je bepaalt hier tevens 
	een zelf gekozen prefix die je in deze JSP gebruikt om aan te duiden
	dat de tag onderdeel is van de core tag library
-->	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/default.css">
<title>JSTL Expample</title>
</head>

<body>

<h2><c:out value="<c:forEach>"/> om over een verzameling itereren</h2>

<ul>
<c:forEach var="instructeur" items="${instructeurs}">

<li>${instructeur}</li>

</c:forEach>
</ul>

<h2>Over een verzameling JavaBeans itereren</h2>

<table border=1>

<tr>
<th> Merk </th>
<th> Model </th>
<th> Motor </th>
<th> Prijs </th>
</tr>

<c:forEach var="auto" items="${collectie}">

<tr>
<td> ${auto.merk} </td>
<td> ${auto.model} </td>
<td> ${auto.motor} </td>
<td> ${auto.prijs} &dollar; </td>
</tr>

</c:forEach>

</table>

<h2>Over een map itereren</h2>

<table border=1>

<tr>
<th> Key <br/>(owner)</th>
<th> Merk </th>
<th> Model </th>
<th> Motor </th>
<th> Prijs </th>
</tr>

<c:forEach var="auto" items="${collectieMap}" begin="0" step="1" end="2">

<tr>
<td> ${auto.key} </td>
<td> ${auto.value.merk} </td>
<td> ${auto.value.model} </td>
<td> ${auto.value.motor} </td>
<td> ${auto.value.prijs} &dollar; </td>
</tr>

</c:forEach>

</table>

<h2>De forEach attributen 'begin', 'step' en 'end'</h2>

<ul>
<c:forEach begin="1" step="2" end="5">
<li>Herhaal dit</li>
</c:forEach>
</ul>

<h2>Het forEach attribuut 'varStatus'</h2>

<table border=1>

<tr>
<th>status.count</th>
<th>status.index</th>
<th>status.first</th>
<th>status.last</th>
</tr>
<c:forEach begin="5" step="3" end="15" varStatus="status">
<tr>
<td>${status.count}</td>
<td>${status.index}</td>
<td>${status.first}</td>
<td>${status.last}</td>
</tr>
</c:forEach>

</table>

<h2>varStatus gebruiken voor afwisselende kleuren</h2>

<c:forEach begin="0" end="5" varStatus="status">

<li class="${status.count % 2 == 0 ? 'even' : 'oneven'}">
${status.count % 2 == 0 ? 'even' : 'oneven'}
</li>

</c:forEach>

<h2><c:out value="<c:if>"/> tag voorbeeld</h2>

<c:if test="${'Ferrari' == collectie[0].merk}">
de eerste auto is een Ferrari !
</c:if>

<h2><c:out value="<c:choose>"/> en <c:out value="<c:when>"/> tag voorbeeld</h2>

<c:forEach var="auto" items="${collectie}" varStatus="status">

<li>

<c:choose>

	<c:when test="${auto.merk == 'Ferrari'}">
	
	Element ${status.index} is een Ferrari 
	
	</c:when>
	
	<c:when test="${auto.merk == 'Aston Martin'}">
	
	Element ${status.index} is een Aston Martin
		
	</c:when>
	
	<c:when test="${auto.merk == 'Pagani'}">
	
	Element ${status.index} is een Pagani
		
	</c:when>

</c:choose>

</li>

</c:forEach>

<c:import url="/WEB-INF/JSP/teImporterenJSP.jsp"/>

<c:set var="eenVariabeleDieGesetIs" value='ik ben gemaakt door een c:set tag!'/>

<h2> ${eenVariabeleDieGesetIs}</h2>

<h2> <c:out value="<c:url>"/> tag voorbeeld</h2>

<c:url var="eenURL" value="/RedirectServlet">
	<c:param name="eersteParameter" value="Eerste"/>
	<c:param name="tweedeParameter" value="Tweede"/>
</c:url>

<a href="${eenURL}">LinkNaarRedirectServletDieTerugNaarHierRedirect!</a>

</body>

</html>