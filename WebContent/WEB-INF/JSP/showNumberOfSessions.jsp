<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        
<!doctype html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="styles/default.css">
<title>Number of Sessions</title>
</head>

<body>

<h1>Number of current Sessions : ${applicationScope['sessions'].size()}</h1>

<c:url var="index" value="/IndexServlet"/>

<a class="HPbutton" href="${index}">Home Page</a>

</body>

</html>