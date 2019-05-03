<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Add solution</title>
    </head>
    <body>
    <form method="post" action="/solutions/add">
        <input type="text" name="description"/>
        <input type="text" name="exerciseId"/>
        <input type="text" name="userId"/>
        <input type="submit" value="Accept">
    </form>
    </body>
</html>