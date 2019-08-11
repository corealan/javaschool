<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Add New Station</title>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.4.1.min.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
</head>
<body>
<c:import url="employeeNav.jsp"/>
<div class="form">
    <form action="addNewStation" method='POST'>
        <table>
            <caption>Добавить новую станцию/Связать существующие</caption>
            <tr>
                <td>Название станции:</td>
                <td><input type='text' name='stationName' value=''></td>
            </tr>
            <tr>
                <td>Название смежной станции</td>
                <td><input id="test" type='text' name='adjacentStation' /></td>
            </tr>
            <tr>
                <td>Название 2й смежной станции<br/>
                    (если новая станция между существующими)</td>
                <td><input id="adjacent2" type='text' name='adjacentStation2' /></td>
            </tr>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /></td>
        </table>
        <button type="submit">Добавить станцию</button>
    </form>
</div>

</body>
</html>
