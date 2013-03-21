<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="styles/default.css">
<title>pagina niet gevonden</title>
</head>

<body>

<h1>Pagina niet gevonden</h1>

<c:url var="foutFoto" value="/images/fout.png"/>

<img class="error" src="${foutFoto}" alt="fout"/>

<p>De pagina die u zocht bestaat niet!</p>

<c:url var="index" value="/IndexServlet"/>

<a class="HPbutton" href="${index}">Home Page</a>

</body>

</html>
