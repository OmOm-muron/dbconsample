<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>DB接続テスト</title>
  </head>
  
  <body>
    <!--header-->
    <header align="center">
      <h1>DB接続テスト</h1>
    </header>
    
    <main align="center">
      <table border="1">
        <tr>
          <th>ユーザー名</th>
          <th>パスワード</th>
        </tr>
        <tr>
          <td><c:out value="${username}"/></td>
          <td><c:out value="${userpasswd}"/></td>
        </tr>
      </table>
    </main>
    
  </body>
</html>
