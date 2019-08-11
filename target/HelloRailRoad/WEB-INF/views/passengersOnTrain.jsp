<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пассажиры поезда</title>
    <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
</head>
<body>

<div class="form">
    <form action="passengersOnTrain" method="post">
        <table>
            <tr>
                <td>Номер поезда:</td>
                <td><input type="text" name="trainNumber"></td>
            </tr>
            <tr><td colspan="2"><button type="submit">Найти пассажиров</button> </td></tr>
        </table>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</div>

<c:if test="${tickets.size()>0}">
    <div>
        <table class="allTrains">
            <caption>Пассжиры зарегистрированные на поезд № ${tickets.get(0).train.trainNumber}</caption>
            <tr>
                <td>Имя пассажира</td>
                <td>Фамилия пассажира</td>
                <td>Дата рождения пассажира</td>
                <td>Станция посадки</td>
                <td>Стация высадки</td>
            </tr>
            <c:forEach items="${tickets}" var="ticket">
                <tr>
                    <td>${ticket.passenger.firstName}</td>
                    <td>${ticket.passenger.lastName}</td>
                    <td><fmt:formatDate type = "date"
                                        value = "${ticket.passenger.dateOfBirth}" /></td>
                    <td>${ticket.departure.name}</td>
                    <td>${ticket.destination.name}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>


</body>
</html>
