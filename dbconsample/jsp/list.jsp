<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>DB Connection Sample</title>
  </head>
  
  <body>
    <!--header-->
    <header align="center">
      <h1>DB Connection Sample</h1>
    </header>
    
    <main align="center">
      <table border="1">
        <tr>
          <th>USERNAME</th>
          <th>BIRTHDAY</th>
          <th>UPDATE</th>
          <th>DELETE</th>
        </tr>
        <c:forEach items="${userList}" var="user">
          <tr>
            <td><c:out value="${user.username}"/></td>
            <td><fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/></td>
            <td>
              <form method="get" action="/dbconsample/modify">
                <input type="hidden" name="mode" value="upd">
                <input type="hidden" name="userid" value="<c:out value="${user.userid}"/>">
                <input type="submit" value="UPDATE">
              </form>
            </td>
            <td>
              <form method="get" action="/dbconsample/modify">
                <input type="hidden" name="mode" value="del"/>
                <input type="hidden" name="userid" value="<c:out value="${user.userid}"/>">
                <input type="submit" value="DELETE">
              </form>
            </td>
          </tr>
        </c:forEach>
      </table>
    </main>
    
    <br>
    <a href="/dbconsample">BACK</a>
    
  </body>
</html>
