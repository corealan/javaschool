
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/resources/css/topnav.css" rel="stylesheet">
</head>
<body>
<div class="topnav">
    <a class="active" href="#home">Home</a>
    <a href="/passenger/findTrains">Найти поезд</a>
    <a href="/passenger/getSchedule">Расписание</a>
    <div class="topnav-right">
        <a href="/admin">Сотрудникам</a>
        <a href="/logout">Выход</a>
    </div>
</div>
</body>
</html>
