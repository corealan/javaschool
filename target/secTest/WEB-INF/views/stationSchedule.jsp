<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: postgre
  Date: 05.08.2019
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Расписание</title>
</head>
<body>
<form action="/passenger/getSchedule" method="POST">

    <input type="text" name="station" list="stationList"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit">
</form>

<datalist id="stationList" >
    <c:forEach var="station" items="${stations}">
        <option value="${station.name}"/>
    </c:forEach>
</datalist>

<c:if test="${schedules.size() > 0}">
    <h4>Расписание движения поездов по станции ${schedules.get(0).station.name}</h4>
    <table border="1">
        <tr>
            <td>Номер поезда</td>
            <td>Станция назначения</td>
            <td>Время прибытия</td>
            <td>Время отправления</td>
        </tr>
        <c:forEach var="schedule" items="${schedules}">
            <tr>
                <td>${schedule.train.trainNumber}</td>
                <td>${schedule.train.route.get(schedule.train.route.size()-1).name}</td>
                <td>${schedule.arrivalTime}</td>
                <td>${schedule.departureTime}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
