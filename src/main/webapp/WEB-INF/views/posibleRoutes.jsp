<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <title>PossibleRoutes</title>
</head>
<body>
<c:import url="employeeNav.jsp"/>
<form action="/admin/routeStationSelect" method="POST">
    <select name="route" size="${routes.size()}">
        <c:forEach var = "route" items="${routes}">
            <option value="${route}">
                <c:forEach var = "station" items="${route}">
                    <c:out value="${station.name}"/>
                    <c:if test="${route.indexOf(station) != route.size()-1}">
                        <c:out value="----->"/>
                    </c:if>
                </c:forEach>
                <br/>
            </option>
        </c:forEach>
    </select>
    <input type="submit" value="Далее">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>



</body>
</html>
