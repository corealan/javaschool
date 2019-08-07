
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Покупка билета</title>
</head>
<body>
<h4> Введите ваши данные для покупки билета</h4>
<form action="/passenger/purchaseTicket" method="POST">
    <h4>На данный маршрут доступно ${numOfTickets} билетов.</h4>
    <table>
        <tr>
            <td>Имя: </td> <td><input type="text" name="firstName" value="${passenger.firstName}" required></td>
            <td>Фамилия: </td> <td><input type="text" name="lastName" value="${passenger.lastName}" required></td>
            <td>Дата рождения: </td> <td><input type="date" name="DOB" value="${passenger.dateOfBirth}" required></td>
            <td>Станция отправления: </td><td> <input type="text" name="departureStation" value="${departure.name}" required></td>
            <td>Станция назначения: </td><td><input type="text" name="destinationStation" value="${destination.name}" required></td>
        </tr>
    </table>
    <input type="submit" value="Купить билет">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="hidden" value="${train.id}" name="trainId">

</form>
</body>
</html>
