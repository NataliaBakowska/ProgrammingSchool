<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>School management service</title>
    <style type="text/css">
        body {
            background-color: white;
            text-align: center;
        }
        a{
            color: #C1E3AB;
            background-color: #301849;
        }
        /* Add a black background color to the top navigation */
        .topnav {
            background-color: #333;
            overflow: hidden;
        }
        .topnav a {
            float: left;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }
        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }
        .topnav a.active {
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>
<div class="topnav">
<a href="${pageContext.request.contextPath}/users/all">All users</a>
<a href="${pageContext.request.contextPath}/exercises/all">All exercises</a>
<a href="${pageContext.request.contextPath}/solutions/all">All solutions</a>
<a href="${pageContext.request.contextPath}/groups/all">All groups</a>
<a href="${pageContext.request.contextPath}/users/add">Register user</a>
<a href="${pageContext.request.contextPath}/exercises/add">Add exercise</a>
<a href="${pageContext.request.contextPath}/solutions/add">Add solution</a>
<a href="${pageContext.request.contextPath}/groups/add">Add new group</a>
</div>
</body>
</html>
