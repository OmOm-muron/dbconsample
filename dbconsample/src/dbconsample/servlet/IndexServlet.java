package dbconsample.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        String username = "";
        String userpasswd = "";
        try {
            HashMap<String, String> map = getUserInfo();
            if (map.containsKey("username") && map.containsKey("userpasswd")) {
                username = map.get("username");
                userpasswd = map.get("userpasswd");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
        
        if (username.isEmpty()) {
            username = "取得できませんでした。";
        }
        if (userpasswd.isEmpty()) {
            userpasswd = "取得できませんでした。";
        }
        
        req.setAttribute("username", username);
        req.setAttribute("userpasswd", userpasswd);
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/index.jsp");
        rd.forward(req, rsp);
    }
    
    private HashMap<String, String> getUserInfo() throws Exception {
        HashMap<String, String> map = new HashMap<>();
        Connection con = null;
        String sql = "SELECT username, userpasswd FROM users LIMIT 1";
        
        try {
            String username = "";
            String userpasswd = "";
            con = getConnection();
            PreparedStatement state = con.prepareStatement(sql);
            ResultSet rs = state.executeQuery();
            if (rs.next()) {
                username = rs.getString("username");
                userpasswd = rs.getString("userpasswd");
            }
            map.put("username", username);
            map.put("userpasswd", userpasswd);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return map;
    }
    
    private Connection getConnection() throws NamingException, SQLException {
        Connection con = null;
        
        try {
            if (con == null || con.isClosed()) {
                InitialContext initCtx = new InitialContext();
                DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/sample");
                con = ds.getConnection();
            }
        } catch (NamingException | SQLException e) {
            con = null;
            throw e;
        }
        return con;
    }
}
