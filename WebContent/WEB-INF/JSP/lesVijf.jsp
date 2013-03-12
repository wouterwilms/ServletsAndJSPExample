<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" session="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Les Vijf</title>
</head>

<body>

<h2>${eersteParameter}</h2>

<h2>${tweedeParameter}</h2>

<h2>${userAgent}</h2>

<c:if test="${not empty headers}"><h2>De meegestuurde request headers waren</h2></c:if>

<ul>
<c:forEach var="eenHeaderName" items="${headers}">

<li>${eenHeaderName} : ${header[eenHeaderName]}</li>

</c:forEach>
</ul>

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

<input type="submit" value="Stuur een POST request"/>

</form>

<c:if test="${! empty meerwaardigeParameter}"><h1>De aangevinkte opties!</h1></c:if>

<ul>
<c:forEach var="item" items="${meerwaardigeParameter}">
<li>${item}</li>
</c:forEach>
</ul>

<c:url var="cookieTestURL" value="/LeesCookieServlet"/>

<a href="${cookieTestURL}">Heeft deze site een cookie geplaatst ?</a> 
${cookieWaarde}<c:if test="${not empty cookie.testCookie.value && not empty cookieWaarde}">  ...en nog eens de value : "${cookie.testCookie.value}"</c:if>

</body>

</html>