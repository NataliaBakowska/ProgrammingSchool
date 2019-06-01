<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>All exercises</title>
    <style>
        body {
            background-color: #301849;
            text-align: center;
            color : white;
        }
        tr,td,th {
            border: white;
            border-style: dotted;
            border-width: 1px;
        }
        h1 {
            text-decoration: none;
            color: white;

        }
    </style>
</head>
<body>
<h1>Exercises</h1>
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
    </c:forEach>
</table>
</body>
</html>