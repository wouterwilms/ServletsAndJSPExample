<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Een JSP</title>
</head>

<body>

<h1>${naamDieInJSPKanAangesprokenWorden} Java cursist!</h1>

<c:url var="index" value="/IndexServlet"/>

<a href="${index}">Home Page</a>

</body>

</html>