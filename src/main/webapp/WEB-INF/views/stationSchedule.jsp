<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Расписание</title>
    <link href="${pageContext.request.contextPath}/resources/css/topnav.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
</head>
<body>
<c:import url="nav.jsp"/>
<form class="form" id="schedule" action="/passenger/getSchedule" method="POST">
    <input type="text" name="station" list="stationList" placeholder="Название станции"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit">
</form>

<datalist id="stationList" >
    <c:forEach var="station" items="${stations}">
        <option value="${station.name}"/>
    </c:forEach>
</datalist>

<c:if test="${schedules.size() > 0}">
    <table class="allTrains" id="schedule-table">
        <caption>Расписание движения поездов по станции ${schedules.get(0).station.name}</caption>
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
                <td>${schedule.arrivalTime.toLocaleString()}</td>
                <td>${schedule.departureTime.toLocaleString()}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
