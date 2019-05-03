<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
       <html>
       <head>
           <title>All users</title>
       </head>
       <body>
       <p>Users:</p>
       <table>
           <tr>
               <td>Id</td>
               <td>Username</td>
               <td>Group id</td>
               <td>Email</td>
           </tr>
           <c:forEach items="${users}" var="user">
               <tr>
                   <td>${user.id}</td>
                   <td>${user.username}</td>
                   <td>${user.userGroupId}</td>
                   <td>${user.email}</td>
                   <%--<td><a href="/groups/users/"?id=<%out.println(rs.getString("id"));%>>See all users</a></td>--%>
               </tr>
           </c:forEach>
       </table>
       </body>
       </html>