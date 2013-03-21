<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/default.css">
<title>Een JSP</title>
</head>

<body>

<div class="center">

<h1>${naamDieInJSPKanAangesprokenWorden} Java cursist!</h1>

<c:url var="index" value="/IndexServlet"/>

<a class="HPbutton" href="${index}">Home Page</a>

</div>

</body>

</html>