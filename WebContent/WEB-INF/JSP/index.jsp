<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        
<!doctype html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/default.css">
<title>VoorbeelProject</title>
</head>

<body>

<div class="center">

<c:url var="avatar" value="/images/GitHubAvatar.png" />

<c:url var="git" value="https://github.com/VanbockryckInstructeur/ServletsAndJSPExample" />

<a href="${git}"><img src="${avatar}" alt="avatar" title="GitHub repo"/></a>

<!--  ${initParam.cursus} spreekt rechtstreeks de servlet context initparamter cursus aan (zie DD)-->
<h1>${initParam.cursus}</h1>

<c:url var="inleidingURL" value="/EenServletIsEenController"/>

<a href="${inleidingURL}" class="button">Inleiding: een Servlet en een JSP</a> 

<c:url var="formURL" value="/ToonEnVerwerkFormServlet"/>

<a href="${formURL}" class="button">EL en een Form</a>

<c:url var="JSTLURL" value="/JSTLServlet"/>

<a href="${JSTLURL}" class="button">JSTL </a>

<c:url var="requestAndCookieURL" value="/LesVijfServlet?eersteParameter=waardeVanEersteParameter&tweedeParameter=waardeVanTweedeParameter"/>

<a href="${requestAndCookieURL}" class="button">RequestParameters en Cookies</a>

<c:url var="sessions" value="/Sessions"/>

<a href="${sessions}" class="button">Sessions</a>

<c:url var="filmTickets" value="/FilmTicket"/>

<a href="${filmTickets}" class="button">Film tickets</a>

<c:url var="init" value="/InitDestroyVoorbeeld"/>

<a href="${init}" class="button">init en destroy voorbeeld</a>

<c:url var="numberOfSessions" value="/NumberOfSessionsServlet"/>

<a href="${numberOfSessions}" class="button">SessionListenerExample</a>

<c:url var="filter" value="/voorbeeldFilter"/>

<a href="${filter}" class="button">Filter Voorbeeld</a>

<c:url var="nullPointer" value="/NullPointerServlet"/>

<a href="${nullPointer}" class="button">Throw an Exception</a>

<c:url var="cursisten" value="/CursistServlet"/>

<a href="${cursisten}" class="button">Toon al de cursisten</a>

<c:url var="UTF" value="/TextToUTF"/>

<a href="${UTF}" class="button">Text to UTF-8 binairy printer</a>

<br/>

<c:url var="SQL" value="/SQLTestDatabaseCursisten.sql"/>

<a href="${SQL}" class="HPbutton">Download .sql script voor DB</a>

<h1>${initParam.nieuwAttribuut}</h1>

</div>

</body>

</html>