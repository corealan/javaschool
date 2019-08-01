<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>RouteStationSelect</title>
</head>
<body>
    <c:forEach var = "station" items="${route}">
        <c:out value="${station.name}"/>
    </c:forEach>
</body>
</html>
