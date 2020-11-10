package dbconsample.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconsample.dto.UserInfo;
import dbconsample.util.UserInfoUtil;

public class InquiryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String MODE_LIST = "ls";
    private final String MODE_WORD = "word";

    public void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        RequestDispatcher rd = null;
        String mode = req.getParameter("mode");
        
        switch(mode) {
        case MODE_LIST:
            String keyword = req.getParameter("keyword");
            List<UserInfo> userList = new ArrayList<>();
            
            if (keyword == null || keyword.isEmpty()) {
                try {
                    userList = UserInfoUtil.selectAllUsers();
                } catch (Exception e) {
                    throw new ServletException(e);
                }
            } else {
                try {
                    userList = UserInfoUtil.selectMatchUsers(keyword);
                } catch (Exception e) {
                    throw new ServletException(e);
                }
            }
            
            req.setAttribute("userList", userList);
            rd = req.getRequestDispatcher("/jsp/list.jsp");
            break;
        case MODE_WORD:
            rd = req.getRequestDispatcher("/jsp/search.jsp");
            break;
        }
        
        if (rd == null) {
            rd = req.getRequestDispatcher("/jsp/index.jsp");
        }
        rd.forward(req, rsp);
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        doGet(req, rsp);
    }
}