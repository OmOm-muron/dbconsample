<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>DB Connection Sample携サンプル</title>
  </head>
  
  <body>
    <!--header-->
    <header align="center">
      <h1>DB Connection Sample</h1>
    </header>
    
    <main align="center">
      <form method="post" action="/dbconsample/modify">
        <table border="1">
          <tr>
            <th>USERNAME</th>
            <th>BIRTHDAY</th>
          </tr>
          <tr>
            <td><input type="text" size="64" maxlength="64" name="username" value="<c:out value="${user.username}"/>"></td>
            <td><input type="date" name="birthday" value="<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>"></td>
          </tr>
        </table>
        <input type="hidden" name="userid" value="<c:out value="${user.userid}"/>">
        <input type="hidden" name="mode" value="<c:out value="${mode}"/>">
        <input type="submit" value="SUBMIT">
      </form>
    </main>
    
    <a href="/dbconsample">BACK</a>
    
  </body>
</html>
