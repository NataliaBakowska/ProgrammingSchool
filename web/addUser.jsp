<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Add user</title>
    </head>
    <body>
    <form method="post" action="/user/add">
        <input type="text" name="username"/>
        <input type="text" name="password"/>
        <input type="text" name="email"/>
        <input type="submit" value="Accept">
    </form>
    </body>
</html>