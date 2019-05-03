<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>All solutions</title>
</head>
<body>
<p>Users:</p>
<table>
    <tr>
        <td>Exercise id</td>
        <td>User id</td>
        <td>Updated</td>
        <td>Created</td>
        <td>Description</td>
    </tr>
    <c:forEach items="${solutions}" var="solution">
        <tr>
            <td>${solution.exerciseId}</td>
            <td>${solution.userId}</td>
            <td>${solution.updated}</td>
            <td>${solution.created}</td>
            <td>${solution.description}</td>
        </tr>
        <br>
    </c:forEach>
</table>
</body>
</html>