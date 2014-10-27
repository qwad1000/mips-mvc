<%--
  Created by IntelliJ IDEA.
  User: Сергій
  Date: 21.10.2014
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
    <title>${title}</title>
  </head>
  <body>
  <table>
  <thead>
    <tr>
        <th>Email</th>
        <th>Password</th>
    </tr>
  </thead>
      <c:forEach var="user" items="${list}">
          <tr>
              <td> <c:out value="${user.email}"/> </td>
              <td> <c:out value="${user.password}"/> </td>
          </tr>
      </c:forEach>
  </table>

  фждылвмлыоватмлд

  </body>
</html>
