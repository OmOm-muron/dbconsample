<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>DB連携サンプル</title>
  </head>
  
  <body>
    <!--header-->
    <header align="center">
      <h1>DB連携サンプル</h1>
    </header>
    
    <main align="center">
      <form method="post" action="/dbconsample/modify">
        <table border="1">
          <tr>
            <th>USERNAME</th>
            <th>BIRTHDAY</th>
          </tr>
          <tr>
            <td><c:out value="${user.username}"/></td>
            <td><fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/></td>
          </tr>
        </table>
        <input type="hidden" name="userid" value="<c:out value="${user.userid}"/>">
        <input type="hidden" name="mode" value="del"/>
        <input type="submit" value="SUBMIT">
      </form>
    </main>
    
    <a href="/dbconsample">BACK</a>
    
  </body>
</html>
