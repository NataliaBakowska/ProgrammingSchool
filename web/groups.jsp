<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>All groups</title>
</head>
<body>
<p>Users:</p>
<table>
    <tr>
        <td>Id</td>
        <td>Name</td>
    </tr>
    <c:forEach items="${groups}" var="group">
        <tr>
            <td>${group.id}</td>
            <td>${group.name}</td>
            <%--<td><a href="/groups/users/"?id=<%out.println(rs.getString("id"));%>>See all users</a></td>--%>
        </tr>
        <br>
    </c:forEach>
</table>
</body>
</html>