<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: postgre
  Date: 04.08.2019
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TrainList</title>
</head>
<body>
<h4>Список всех поездов: </h4>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Номер поезда</td>
        <td>Число свободных мест</td>
        <td>Станция отправления</td>
        <td>Время отправления</td>
        <td>Станция назначения</td>
        <td>Время прибытия</td>
    </tr>
    <c:forEach var="train" items="${trains}">
        <tr>
            <td>${train.id}</td>
            <td>${train.trainNumber}</td>
            <td>${train.numberOfSeats}</td>

            <td>${train.schedules.get(0).station.name}</td>
            <td>${train.schedules.get(0).departureTime}</td>

            <td>${train.schedules.get(train.schedules.size()-1).station.name}</td>
            <td>${train.schedules.get(train.schedules.size()-1).arrivalTime}</td>
        </tr>
    </c:forEach>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</table>

</body>
</html>
