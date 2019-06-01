<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
       <html>
       <head>
           <title>All users</title>
           <style>
               body {
                   background-color: #71C5D0;
                   text-align: center;
               }
               td,tr,th {
                   border: darkblue;
                   border-style: dotted;
                   border-width: 1px;
                   color: #301849;
               }
               h1 {
                   text-decoration: underline;
                   color: #C1E3AB;

               }
           </style>
       </head>
       <body>
       <h1>Users</h1>
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
                   <td><a href="${pageContext.request.contextPath}/users/edit?id=${user.id}" >Add to group</a></td>
               </tr>
           </c:forEach>
       </table>
       </body>
       </html>