<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
${message}
<form action="<c:url value='registration' />" method='POST'>

    <table>
        <tr>
            <td>Имя пользователя:</td>
            <td><input type='text' name='username' value='' required></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type='password' name='password' required/></td>
        </tr>
        <tr>
            <td>Подтвердите пароль:</td>
            <td><input type='password' name='passwordConfirm' required/></td>
        </tr>
        <tr>
            <td>Имя</td>
            <td><input type='text' name='firstName' required/></td>
        </tr>
        <tr>
            <td>Фамилия</td>
            <td><input type='text' name='lastName' required/></td>
        </tr>
        <tr>
            <td>Дата рождения</td>
            <td><input type="date" name="DOB" required/></td>
        </tr>

        <tr>
            <td><input name="submit" type="submit" value="Зарегистрироваться" /></td>
            <td><input name="reset" type="reset" />
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /></td>
        </tr>
    </table>

</form>
</body>
</html>
