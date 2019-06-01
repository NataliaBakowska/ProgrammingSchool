<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>All groups</title>
    <style>
        body {
            background-color: #71C5D0;
            text-align: center;
        }
        tr,td,th {
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
            <%--see users in group--%>
        </tr>

    </c:forEach>
</table>
</body>
</html>