<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
      <form method="get" action="/dbconsample/inquiry?mode=ls">
        <table border="1">
          <tr>
            <th>SEARCH USERNAME</th>
            <td><input type="text" name="keyword"></td>
          </tr>
        </table>
        <input type="hidden" name="mode" value="ls">
        <input type="submit" value="SEARCH">
      </form>
    </main>
    
    <a href="/dbconsample">BACK</a>
    
  </body>
</html>
