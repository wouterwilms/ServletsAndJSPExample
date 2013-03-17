<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VoorbeelProject</title>
</head>

<body>

<!--  ${initParam.cursus} spreekt rechtstreeks de servlet context initparamter cursus aan (zie DD)-->
<h1>Voorbeeld Project : ${initParam.cursus}</h1>

<ul>

<li>
<c:url var="inleidingURL" value="/EenServletIsEenController"/>

<a href="${inleidingURL}">Inleiding: een Servlet en een JSP</a> 
</li>

<li>
<c:url var="formURL" value="/ToonEnVerwerkFormServlet"/>

<a href="${formURL}">EL en een Form</a> 
</li>

<li>
<c:url var="JSTLURL" value="/JSTLServlet"/>

<a href="${JSTLURL}">JSTL </a> 
</li>

<li>
<c:url var="requestAndCookieURL" value="/LesVijfServlet?eersteParameter=waardeVanEersteParameter&tweedeParameter=waardeVanTweedeParameter"/>

<a href="${requestAndCookieURL}">RequestParameters en Cookies</a>
</li>

<li>
<c:url var="sessions" value="/Sessions"/>

<a href="${sessions}">Sessions</a>
</li>

<li>
<c:url var="filmTickets" value="/FilmTicket"/>

<a href="${filmTickets}">Film tickets</a>
</li>

<li>
<c:url var="init" value="/InitDestroyVoorbeeld"/>

<a href="${init}">init en destroy voorbeeld</a>
</li>

<li>
<c:url var="numberOfSessions" value="/NumberOfSessionsServlet"/>

<a href="${numberOfSessions}">SessionListenerExample</a>

</li>

<li>
<c:url var="filter" value="/voorbeeldFilter"/>

<a href="${filter}">Filter Voorbeeld</a>

</li>

</ul>

<h1>${initParam.nieuwAttribuut}</h1>

</body>

</html>