<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>RouteStationSelect</title>
</head>
<body>
<form action="/setTrainRoute" method="POST">
    <table border="1">
        <tr>
            <td>Название станции</td>
            <td>Остановка</td>
            <td>Время прибытия</td>
            <td>Время отправления</td>
        </tr>
        <c:forEach var="station" items="${route}">
            <tr>
                <td>${station.name}</td>
                <td><input type="checkbox" name="${station.id}stop" value="${station.id}"></td>
                <td><input type="datetime-local" name="${station.id}arrive"/></td>
                <td><input type="datetime-local" name="${station.id}departure"/></td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Задать">
</form>

</body>
</html>
