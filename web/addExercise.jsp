<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Add exercise</title>
        <style>
            body {
                background-color: #71C5D0;
                text-align: center;
            }
        </style>
    </head>
    <body>
    <form method="post" action="${pageContext.request.contextPath}/exercises/add">
        Name: <input type="text" name="title"/>
        <br>
        Description: <input type="text" name="description"/>
        <input type="submit" value="Accept">
    </form>
    </body>
</html>