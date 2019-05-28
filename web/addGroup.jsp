<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add new group</title>
    <style>
        body {
            background-color: #71C5D0;
        }
    </style>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/groups/add">
    Name: <input type="text" name="name"/>
    <br>
    Description: <input type="text" name="description"/>
    <input type="submit" value="Accept">
</form>
</body>
</html>