<%--
  Created by IntelliJ IDEA.
  User: khali
  Date: 26/10/2026
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Résultat - Adulte</title>
</head>
<body>
<h2>Bienvenue (Page Adulte)</h2>

<%-- استدعاء الكائن الذي تم إنشاؤه في الـ Servlet باستخدام type --%>
<jsp:useBean id="personBean" type="lab.mvc.model.Person" scope="request" />

<table border="1" cellpadding="10">
    <tr>
        <th>Champ</th>
        <th>Valeur</th>
    </tr>
    <tr>
        <td>Prénom</td>
        <td><jsp:getProperty name="personBean" property="firstName" /></td>
    </tr>
    <tr>
        <td>Nom</td>
        <td><jsp:getProperty name="personBean" property="lastName" /></td>
    </tr>
    <tr>
        <td>Date de naissance</td>
        <td><jsp:getProperty name="personBean" property="birthDay" /></td>
    </tr>
    <tr>
        <td>Sexe</td>
        <td><jsp:getProperty name="personBean" property="sex" /></td>
    </tr>
</table>

<br>
<a href="index.html">Retour</a>
</body>
</html>