<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <title>TrainList</title>
    <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">

</head>
<body>
<c:if test="${role==1}"><c:import url="nav.jsp"/></c:if>
<c:if test="${role!=1}"><c:import url="employeeNav.jsp"/></c:if>

<table class="allTrains">
    <caption>Список поездов</caption>
    <tr>
        <td>ID</td>
        <td>Номер поезда</td>
        <td>Число мест</td>
        <td>Станция отправления</td>
        <td>Время отправления</td>
        <td>Станция назначения</td>
        <td>Время прибытия</td>
        <c:if test="${role==1}"><td>Билет</a> </td></c:if>

    </tr>
    <c:forEach var="train" items="${trains}">
        <tr>
            <td>${train.id}</td>
            <td>${train.trainNumber}</td>
            <td>${train.numberOfSeats}</td>

            <td>${train.schedules.get(0).station.name}</td>
            <td>${train.schedules.get(0).departureTime.toLocaleString()}</td>

            <td>${train.schedules.get(train.schedules.size()-1).station.name}</td>
            <td>${train.schedules.get(train.schedules.size()-1).arrivalTime.toLocaleString()}</td>
            <c:if test="${role==1}"><td><a href="passenger/ticketPurchase/${train.id}/${departure}/${destination}">Купить билет</a> </td></c:if>
        </tr>
    </c:forEach>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</table>

</body>
</html>
