<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Find Trains</title>
    <link href="${pageContext.request.contextPath}/resources/css/topnav.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
</head>
<body>
<c:import url="nav.jsp"/>
<div class="form">
    <form action="/passenger/findTrains" method="post">
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
</body>
</html>
