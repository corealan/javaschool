<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Сотрудникам</title>
</head>
<body>
<h2>${welcomeMessage}</h2>
<br>

<p><strong>Выберите действие:</strong></p>
<ul type="square">

    <li><a href="/admin/addNewStation"> Добавить новую станцию</a></li>
    <li><a href="/admin/routesRequest"> Добавить новый поезд</a></li>
    <li>Просмотр зарегистрированных на поезд пассажиров</li>
    <li><a href="/admin/getAllTrains"> Просмотр всех поездов</a></li>

</ul>
<form action="logout" method="post">
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" />

    <input type="submit" value="Logout">
</form>
Click <a href="<c:url value="/"/> ">here</a>
to go back to the Homepage.
</body>
</html>