<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>All users</title>
</head>
<body>
<p>Users:</p>
<table>
    <tr>
        <td>Id</td>
        <td>Title</td>
        <td>Description</td>
    </tr>
    <c:forEach items="${exercises}" var="exercise">
        <tr>
            <td>${exercise.id}</td>
            <td>${exercise.title}</td>
            <td>${exercise.description}</td>
        </tr>
        <br>
    </c:forEach>
</table>
</body>
</html>