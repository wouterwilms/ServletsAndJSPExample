<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="nl">
<head>
<title>pagina niet gevonden</title>
</head>
<body>

<h1>Pagina niet gevonden</h1>


<c:url var="foutFoto" value="/images/fout.png"/>

<img src="${foutFoto}" alt="fout"/>

<p>De pagina die u zocht bestaat niet!</p>

<c:url var="index" value="/IndexServlet"/>

<a href="${index}">Home Page</a>

</body>
</html>
