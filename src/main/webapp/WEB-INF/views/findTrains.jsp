<%--
  Created by IntelliJ IDEA.
  User: postgre
  Date: 04.08.2019
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find Trains</title>
</head>
<body>
<h4>Введите станции отправления и назначения:</h4>
<form action="/passenger/findTrains" method="post">
    <table>
        <tr>
            <td>Станция отправления:</td>
            <td><input type='text' name='departure' value=''></td>
            <td><input type="datetime-local" name="after"/></td>
        </tr>
        <tr>
            <td>Станция назначения:</td>
            <td><input type='text' name='destination' value=''><br></td>
            <td><input type="datetime-local" name="before"/></td>

        </tr>
    </table>
    <input type="submit" value="Найти поезда">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</body>
</html>
