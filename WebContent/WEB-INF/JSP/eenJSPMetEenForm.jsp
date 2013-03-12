<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EenJSPMetEenForm</title>
</head>

<body>

<!-- EL bij primitieve types -->
<p>Er zijn ${cursisten} cursisten.</p>


<!-- EL bij object types -->
<p>Er zijn ${cursistenStringObject} cursisten.</p>


<!-- EL die verwijst naar een onbestaand attribuut -->
<p>Er zijn ${onbestaandAttribuut} cursisten.</p>


<!-- EL expressies voor hardgecodeerde waarden -->
<p>een geheel getal : ${42}<br/>
een decimaal getal : ${3.14}<br/>
een string : ${"dubbel"} en ${'enkel'}<br/>
de booleans : ${true} en ${false}</p>

<!-- EL expressies voor wiskundige operaties -->
<p>som : cursisten + 4 = ${cursisten + 4}<br/>
verschil : cursisten - 1 = ${cursisten - 1}<br/>
product : cursisten * 3 = ${cursisten * 3}<br/>
deling : cursisten / 4 = ${cursisten / 4}<br/>
modulus : cursistes % 4 = ${cursisten % 4}</p>

<!-- EL expressies voor vergelijkings operaties -->
<p>Aantal cursisten gelijk aan 6 : ${cursisten == 6}<br/>
Aantal cursisten niet gelijk aan 6 : ${cursisten != 6}<br/>
Aantal cursisten groter dan 8 : ${cursisten > 8}<br/>
Aantal cursisten groter of gelijk aan 4 : ${cursisten >= 4}<br/>
Aantal cursisten kleiner dan 4 : ${cursisten < 4}<br/>
Aantal cursisten kleiner of gelijk aan 18 : ${cursisten <= 18}</p>

<!-- EL expressies voor logische operaties -->
<p>NOT (cursisten == 6): ${! (cursisten == 6) }<br/>
cursisten &rsaquo; 1 AND cursisten &lsaquo; 24 : ${cursisten > 1 && cursisten < 24}<br/>
cursisten &rsaquo; 8 OR cursisten &lsaquo; 7 : ${cursisten > 8 || cursisten < 7}</p>

<!-- EL expressie voor de conditionele operator -->
<p>conditionele : ${cursisten == 3.14 ? "Gelijk aan Pi!" : "Niet gelijk aan Pi!"}</p>

<!-- EL expressie met empty -->
<p>empty : ${empty onbestaandAttribuut}</p>

<!-- EL expressies om elementen uit verzamelingen te halen -->
<p>Eerste element uit Array : ${instructeursArray[0]}<br/>
Tweede element uit List : ${instructeursList[1]}<br/>
Java is ${eigenschappen["Java"]}</p>

<!-- EL expressie om een methode aan te spreken van een object -->
<p>In ${cursistenStringObject} zitten ${cursistenStringObject.length()} karakters.</p>

<!-- Een form voorbeeld -->

<form action="ToonEnVerwerkFormServlet" method="POST">

<input type="text" value="Tik hier je naam" name="naam"><br/>

<input type="submit" value="Stuur een POST request">

</form>

</body>

</html>