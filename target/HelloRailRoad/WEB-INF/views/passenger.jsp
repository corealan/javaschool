<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Клиентам</title>
    <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">

</head>
<body>
<c:import url="nav.jsp"/>
<div id="find-train" class="form">
    <form action="findTrains" method="post">
        <table>
            <caption>Поиск поездов</caption>
            <tr>
                <td>Станция отправления:</td>
                <td><input type='text' name='departure' required value=''></td>
            </tr>
            <tr>
                <td>Станция назначения:</td>
                <td><input type='text' name='destination' required value=''><br></td>
            </tr>
            <tr>
                <td>В период с:</td>
                <td><input type="datetime-local" required name="after"/></td>

            </tr>
            <tr>
                <td>По:</td>
                <td><input type="datetime-local" required name="before"/></td>

            </tr>
        </table>
        <button type="submit">Найти поезда</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</div>

</div>
<form class="form" id="schedule" action="getSchedule" method="POST">
    <label>Расписание</label>
    <input type="text" name="station" list="stationList" placeholder="Название станции"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <button type="submit">Посмотреть расписание</button>
</form>

<datalist id="stationList" >
    <c:forEach var="station" items="${stations}">
        <option value="${station.name}"/>
    </c:forEach>
</datalist>
</body>
</html>