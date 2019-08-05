<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Passenger: postgres
  Date: 28.07.2019
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Station</title>
</head>
<body>
<form action="<c:url value='addNewStation' />" method='POST'>

    <table>
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
            <td><input type='text' name='adjacentStation2' /></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="Добавить станцию" /></td>
            <td><input name="reset" type="reset" />
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /></td>
        </tr>
    </table>

</form>
</body>
</html>
