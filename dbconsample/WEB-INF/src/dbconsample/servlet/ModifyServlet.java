package dbconsample.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconsample.dto.UserInfo;
import dbconsample.util.UserInfoUtil;

public class ModifyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String MODE_INSERT = "ins";
    private final String MODE_UPDATE = "upd";
    private final String MODE_DELETE = "del";

    public void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        RequestDispatcher rd = null;
        
        String useridStr = req.getParameter("userid");
        if (useridStr != null) {
            try {
                UserInfo user = UserInfoUtil.selectUser(useridStr);
                req.setAttribute("user", user);
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }
        
        String mode = req.getParameter("mode");
        req.setAttribute("mode", mode);
        switch(mode) {
        case MODE_INSERT:
        case MODE_UPDATE:
            rd = req.getRequestDispatcher("/jsp/register.jsp");
            break;
        case MODE_DELETE:
            rd = req.getRequestDispatcher("/jsp/delete.jsp");
            break;
        }

        rd.forward(req, rsp);
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        String useridStr = req.getParameter("userid");
        String username = req.getParameter("username");
        String birthdayStr = req.getParameter("birthday");
        UserInfo user = new UserInfo(useridStr, username, birthdayStr);
        
        String mode = req.getParameter("mode");
        try {
            switch(mode) {
            case MODE_INSERT:
                UserInfoUtil.insertUser(user);
                break;
            case MODE_UPDATE:
                UserInfoUtil.updateUser(user);
                break;
            case MODE_DELETE:
                UserInfoUtil.deleteUser(user);
                break;
            }
        } catch(Exception e) {
            throw new ServletException(e);
        }
        
        RequestDispatcher rd = req.getRequestDispatcher("/inquiry?mode=ls");
        rd.forward(req, rsp);
    }
}