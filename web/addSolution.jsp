<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Add solution</title>
        <style>
            body {
                background-color: #301849;
                text-align: center;
                color : white;
            }
        </style>
    </head>
    <body>
    <form method="post" action="${pageContext.request.contextPath}/solutions/add">
        Description: <input type="text" name="description"/>
        <br>
        Exercise id: <input type="text" name="exerciseId"/>
        <br>
        User id: <input type="text" name="userId"/>
        <input type="submit" value="Accept">
    </form>
    </body>
</html>