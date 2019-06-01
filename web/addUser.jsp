<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Add user</title>
        <style>
            body {
                background-color: #71C5D0;
            }
        </style>
    </head>
    <body>
    <form method="post" action="${pageContext.request.contextPath}/users/add">
        Username: <input type="text" name="username"/>
        <br>
        Password: <input type="text" name="password"/>
        <br>
        Email: <input type="text" name="email"/>
        <br>
        UserGroupId: <input type="text" name="userGroupId">
        <input type="submit" value="Accept">
    </form>
    </body>
</html>