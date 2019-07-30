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
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td>Подтвердите пароль:</td>
            <td><input type='password' name='passwordConfirm' /></td>
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
