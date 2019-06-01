<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Edit solution</title>
    <style>
        body {
            background-color: #71C5D0;
        }
    </style>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/solutions/edit">
    <input type="hidden" name="id" value="${id}">
    Description: <input type="text" name="description"/>
    <br>
    Exercise id: <input type="text" name="exerciseId"/>
    <br>
    User id: <input type="text" name="userId"/>
    <input type="submit" value="Accept">
</form>
</body>
</html>