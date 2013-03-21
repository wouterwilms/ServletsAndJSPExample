<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="styles/default.css">
<title>Exception ! </title>
</head>

<body>

<h1>Exception !</h1>

<c:url var="foutFoto" value="/images/bug.png"/>

<img class="error" src="${foutFoto}" alt="bug"/>

<p>De programmeur heeft een domme fout gemaakt of u bent het slachtoffer van een bug</p>

<c:url var="index" value="/IndexServlet"/>

<a class="HPbutton" href="${index}">Home Page</a>

</body>

</html>
