<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>All solutions</title>
    <style>
        body {
            background-color: #71C5D0;
            text-align: center;
        }
        td,tr,th {
            border: white;
            border-style: dotted;
            border-width: 1px;
        }
        h1 {
            text-decoration: underline;
            color: #301849;

        }
    </style>
</head>
<body>
<h1>Solutions</h1>
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
            <td><a href="${pageContext.request.contextPath}/solutions/edit?id=${solution.id}">Edytuj</a></td>
            <td><a href="${pageContext.request.contextPath}/solutions/delete?id=${solution.id}">Usuń</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>