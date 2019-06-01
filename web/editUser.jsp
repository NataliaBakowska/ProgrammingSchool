<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Edit user</title>
    <style>
        body {
            background-color: #301849;
            text-align: center;
            color : white;
        }
    </style>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/users/edit">
    Id: <input type="hidden" name="id" value="${id}">
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