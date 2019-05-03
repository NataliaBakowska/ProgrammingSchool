<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Add exercise</title>
    </head>
    <body>
    <form method="post" action="/exercises/add">
        <input type="text" name="title"/>
        <input type="text" name="description"/>
        <input type="submit" value="Accept">
    </form>
    </body>
</html>