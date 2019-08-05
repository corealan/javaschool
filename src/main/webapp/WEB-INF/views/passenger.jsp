<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Клиентам</title>
</head>
<body>
<h2>${welcomeMessage}</h2>

<p><strong>Чего бы вы хотели?</strong></p>
<ul type="square">

    <li><a href="/passenger/findTrains">Найти поезд</a></li>
    <li>Посмотреть расписание</li>
    <li>Купить билет</li>

</ul>
<a href="<c:url value="/"/> ">На Главную!</a>

<form action="logout" method="post">
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" />

    <input type="submit" value="Logout">
</form>

</body>
</html>