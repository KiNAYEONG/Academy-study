package com.aischool.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aischool.model.WCLMember_Vendor;
import com.aischool.model.WebMemberDAO;

@WebServlet("/DeleteService_Vendor")
public class DeleteService_Vendor extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        WCLMember_Vendor member = (WCLMember_Vendor) session.getAttribute("loginM");

        if (member == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String vendor_id = member.getId();
        String pw = request.getParameter("pw");

        WebMemberDAO dao = new WebMemberDAO();
        boolean isValidPassword = dao.checkPassword(vendor_id, pw);

        if (isValidPassword) {
            int cnt = dao.deleteVendor(vendor_id, pw);

            if (cnt > 0) {
                session.invalidate(); // 로그아웃
                response.sendRedirect("delete_success.jsp");
            } else {
                response.sendRedirect("delete_failure.jsp");
            }
        } else {
            response.sendRedirect("delete_failure.jsp");
        }
    }
}
