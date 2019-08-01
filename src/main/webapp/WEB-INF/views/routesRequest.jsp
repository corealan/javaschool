<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: postgres
  Date: 31.07.2019
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Routes</title>
</head>
<body>
<form action="/getRoutes" method="POST">
    <input type='text' name='departure' value=''>
    <input type='text' name='destination' value=''>
    <input type="submit" value="Показать возможные маршруты">
</form>
</body>
</html>
