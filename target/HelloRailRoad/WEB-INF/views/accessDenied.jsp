<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <title>Access Denied</title>
    <link href="${pageContext.request.contextPath}/resources/css/topnav.css" rel="stylesheet">

</head>
<body>
<c:import url="nav.jsp"/>
<h2>Sorry, you do not have permission to view this page.</h2>

Click <a href="<c:url value="/"/> ">here</a>
to go back to the Homepage.
</body>
</html>
