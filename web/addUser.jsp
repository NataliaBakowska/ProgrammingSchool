<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Add user</title>
    </head>
    <body>
    <form method="post" action="${pageContext.request.contextPath}/users/add">
        Username: <input type="text" name="username"/>
        Password: <input type="text" name="password"/>
        Email: <input type="text" name="email"/>
        <input type="submit" value="Accept">
    </form>
    </body>
</html>