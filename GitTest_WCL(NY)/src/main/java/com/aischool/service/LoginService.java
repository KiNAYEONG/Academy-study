package com.aischool.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aischool.model.WCLMember_Vendor;
import com.aischool.model.WeddingChocieDAO;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        WeddingChocieDAO dao = new WeddingChocieDAO();
        WCLMember_Vendor member = dao.loginById(id, pw);

        if (member != null) { // 로그인 성공
            HttpSession session = request.getSession();
            session.setAttribute("loginM", member);
            response.sendRedirect("index.jsp");
        } else { // 로그인 실패
            response.sendRedirect("login.jsp");
        }
    }
}
