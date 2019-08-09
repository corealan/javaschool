<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
    <title>Регистрация</title>
    <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/topnav.css" rel="stylesheet">
</head>
<body>
<c:import url="nav.jsp"/>
    <div class="form">

        <form action="<c:url value='registration' />" method='POST' class="register-form">
            <label class="error-message" value="${message}"/>
            <input type="text" name="username" required placeholder="Логин"/>
            <input type="password" name="password" required placeholder="Пароль"/>
            <input type="password" name="passwordConfirm" required placeholder="Подтвердите пароль"/>
            <input type="text" name="firstName" required placeholder="Имя"/>
            <input type="text" name="lastName" required placeholder="Фамилия"/>
            <input type="date" name="DOB" required placeholder="Дата рождения" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <button type="submit">Зарегистрироваться</button>
            <p class="message">Уже зарегистрированы? <a href="/login">Войти</a></p>
        </form>
    </div>

</form>
</body>
</html>
