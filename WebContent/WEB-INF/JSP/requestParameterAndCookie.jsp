<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        
<!doctype html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="styles/default.css">
<title>RequestParameters en Cookies</title>
</head>

<body>

<h2>${eersteParameter}</h2>

<h2>${tweedeParameter}</h2>

<h2>${userAgent}</h2>

<c:if test="${not empty headers}"><h2>De meegestuurde request headers waren</h2></c:if>

<c:forEach var="eenHeaderName" items="${headers}">

<li>${eenHeaderName} : ${header[eenHeaderName]}</li>

</c:forEach>

<h1>Een form met POST method</h1>

<c:url var="formURL" value="/LesVijfServlet"/>

<form action="${formURL}" method="POST">

<input type="checkbox" name="meerWaardigeParameter" value="eersteOptie"/>Eerste Optie<br/>
<input type="checkbox" name="meerWaardigeParameter" value="tweedeOptie"/>Tweede Optie<br/>
<input type="checkbox" name="meerWaardigeParameter" value="derdeOptie"/>Derde Optie<br/>
<input type="checkbox" name="meerWaardigeParameter" value="vierdeOptie"/>Vierde Optie<br/>
<input type="checkbox" name="meerWaardigeParameter" value="vijfdeOptie"/>Vijfde Optie<br/><br/>

<input type="hidden" name="eersteParameter" value="WaardeUitEersteHiddenInput"/>
<input type="hidden" name="tweedeParameter" value="WaardeUitTweedeHiddenInput"/>

<input class="button" type="submit" value="Stuur een POST request"/>

</form>

<c:if test="${! empty meerwaardigeParameter}"><h1>De aangevinkte opties!</h1>

<c:forEach var="item" items="${meerwaardigeParameter}">
<li>${item}</li>
</c:forEach>

</c:if>

<br/>

<c:url var="cookieTestURL" value="/LeesCookieServlet"/>

<a class="button" href="${cookieTestURL}">Heeft deze site een cookie geplaatst ?</a> 

<br/>

<c:if test="${not empty cookieWaarde}">

${cookieWaarde}<c:if test="${not empty cookie.testCookie.value}">  ...en nog eens de value : "${cookie.testCookie.value}"</c:if>

<br/><br/>

</c:if>




<c:url var="index" value="/IndexServlet"/>

<a class="HPbutton" href="${index}">Home Page</a>

</body>

</html>