<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: postgre
  Date: 11.08.2019
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Покупка успешна!</title>
    <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
</head>
<body>
<c:import url="nav.jsp"/>
<c:if test="${message.equals('late')}">
    <div id="error" class="msg">
        <a id="close" title="Закрыть"  href="#" onClick="document.getElementById('error').setAttribute('style','display: none;');">&times;</a>
        <span>Внимание!</span> Нельзя приобрести билет менее чем за 10 минут до отправления!
    </div>
</c:if>

<c:if test="${message.equals('duplicate')}">
    <div id="error" class="msg">
        <span>Внимание!</span> Пассажир с такими данными уже зарегистрирован!
    </div>
</c:if>

<c:if test="${message.equals('success')}">
    <div id="success" class="msg">
        <span>Поздравляем!</span> Билет успешно приобретен!
    </div>
</c:if>


</body>
</html>
