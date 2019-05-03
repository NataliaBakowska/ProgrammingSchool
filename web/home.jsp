<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/users/all">All users</a>
<br>
<a href="${pageContext.request.contextPath}/exercises/all">All exercises</a>
<br>
<a href="${pageContext.request.contextPath}/solutions/all">All solutions</a>
<br>
<a href="${pageContext.request.contextPath}/groups/all">All groups</a>
<br>
<a href="${pageContext.request.contextPath}/users/add">Register user</a>
<br>
<a href="${pageContext.request.contextPath}/exercises/add">Add exercise</a>
<br>
<a href="${pageContext.request.contextPath}/solutions/add">Add solution</a>
<br>
<a href="${pageContext.request.contextPath}/groups/add">Add new group</a>

</body>
</html>
