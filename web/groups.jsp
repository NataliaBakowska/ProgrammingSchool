<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>All groups</title>
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
        a {
            text-decoration: white;
            color: white;
        }
    </style>
</head>
<body>
<h1>Groups</h1>
<table>
    <tr>
        <td>Id</td>
        <td>Name</td>
    </tr>
    <c:forEach items="${groups}" var="group">
        <tr>
            <td>${group.id}</td>
            <td>${group.name}</td>
            <td></td>
            <td><a href="${pageContext.request.contextPath}/users/all/group?id=${group.id}">See users in group</a></td>
        </tr>

    </c:forEach>
</table>
</body>
</html>