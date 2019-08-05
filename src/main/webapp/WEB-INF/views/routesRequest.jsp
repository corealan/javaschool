<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Routes</title>
</head>
<body>
<form action="/admin/getRoutes" method="POST">
    <h4>Введите станции отправления и назначения:</h4>
    <table>
        <tr>
            <td>Станция отправления:</td>
            <td><input type='text' name='departure' value=''></td>
        </tr>
        <tr>
            <td>Станция назначения:</td>
            <td><input type='text' name='destination' value=''><br></td>
        </tr>
    </table>
    <input type="submit" value="Показать возможные маршруты">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</body>
</html>
