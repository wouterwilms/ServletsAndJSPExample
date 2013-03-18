<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="nl">
<head>
<title>Null Pointer Exception ! </title>
</head>
<body>

<h1>Null pointer Exception !</h1>


<c:url var="foutFoto" value="/images/bug.png"/>

<img src="${foutFoto}" alt="bug"/>

<p>De programmeur heeft een domme fout gemaakt of u bent het slachtoffer van een bug</p>

<c:url var="index" value="/IndexServlet"/>

<a href="${index}">Home Page</a>

</body>
</html>
