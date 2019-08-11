<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

                <td><fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${schedule.arrivalTime}" /></td>
                <td><fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${schedule.departureTime}"/></td>

            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
