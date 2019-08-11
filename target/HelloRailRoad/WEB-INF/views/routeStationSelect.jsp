<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
    <title>RouteStationSelect</title>
</head>
<body>
<c:import url="employeeNav.jsp"/>
<h3 style="color: red"><c:out value="${message}"/></h3>
<div class="form" id="route-select-form">
    <form  action="setTrainRoute" method="POST">
        <table>
            <tr>
                <td>Введите номер поезда</td><td><input class="route-select" type="text" name="trainNumber"></td>
            </tr>
            <tr>
                <td>Введите число мест в поезеде</td><td><input class="route-select" type="text" name="numberOfSeats"></td>
            </tr>
        </table>

        <input type="hidden" value="${route}" name="route">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

        <table class="allTrains" id="route-select">
            <caption>Задайте расписание поезда</caption>
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
            <tr>
                <td colspan="4"><button type="submit">Задать маршрут</button></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
