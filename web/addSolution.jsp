<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Add solution</title>
    </head>
    <body>
    <form method="post" action="${pageContext.request.contextPath}/solutions/add">
        Name: <input type="text" name="name"/>
        Exercise id: <input type="text" name="exerciseId"/>
        User id: <input type="text" name="userId"/>
        <input type="submit" value="Accept">
    </form>
    </body>
</html>