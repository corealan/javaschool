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

<p><strong>Чем займешься?</strong></p>
<ul type="square">

    <li>Добавить новую станцию</li>
    <li>Добавить новый поезд</li>
    <li>Просмотр зарегистрированных на поезд пассажиров</li>
    <li>Просмотр всех поездов</li>

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