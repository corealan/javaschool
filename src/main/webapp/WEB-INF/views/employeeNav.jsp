<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/topnav.css" rel="stylesheet">
</head>
<body>
<div class="topnav">

    <a class="active" href="#home">Главная</a>
    <a href="/admin/addNewStation">Добавить станцию</a>
    <a href="/admin/routesRequest">Добавить поезд</a>
    <a href="/admin/getAllTrains">Список поездов</a>
    <a href="/passenger/getSchedule">Зарегистрированные пассажиры</a>
    <div class="topnav-right">
        <a href="/logout">Выход</a>
    </div>
</div>
</body>
</html>
