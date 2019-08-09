<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Выбор маршрута</title>
    <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
</head>
<body>
<c:import url="employeeNav.jsp"/>
<div class="form">
    <form action="/admin/getRoutes" method="POST">
        <table>
            <caption>Введите станции отправления и назначения:</caption>
            <tr>
                <td>Станция отправления:</td>
                <td><input type='text' name='departure' value=''></td>
            </tr>
            <tr>
                <td>Станция назначения:</td>
                <td><input type='text' name='destination' value=''><br></td>
            </tr>
        </table>
        <button type="submit">"Показать возможные маршруты"</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</div>

</body>
</html>
