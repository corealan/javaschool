<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/topnav.css" rel="stylesheet">
</head>
<body>
<div class="topnav">

    <a class="active" href="/HelloRailRoad/admin/">Главная</a>
    <a href="/HelloRailRoad/admin/addNewStation">Добавить станцию</a>
    <a href="/HelloRailRoad/admin/routesRequest">Добавить поезд</a>
    <a href="/HelloRailRoad/admin/getAllTrains">Список поездов</a>

    <a href="/HelloRailRoad/admin/passengersOnTrain">Зарегистрированные пассажиры</a>
    <div class="topnav-right">
        <a href="/HelloRailRoad/logout">Выход</a>
    </div>
</div>
</body>
</html>
