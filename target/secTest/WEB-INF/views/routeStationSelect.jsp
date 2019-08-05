<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>RouteStationSelect</title>
</head>
<body>
<h3 style="color: red"><c:out value="${message}"/></h3>
<form action="/admin/setTrainRoute" method="POST">
    <label>Введите номер поезда <input type="text" name="trainNumber"></label>
    <label>Введите число мест в поезеде <input type="text" name="numberOfSeats"></label>
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
    <input type="hidden" value="${route}" name="route">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="Задать">
</form>

</body>
</html>
