package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.WMemberDAO;
import com.model.WMemberVO;


@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      request.setCharacterEncoding("UTF-8");
      
      String id = request.getParameter("id");  // 파라미터는 문자열 형태로 넘어온다
      String pw = request.getParameter("pw");
      String nick = request.getParameter("nick");
      
      WMemberVO vo = new WMemberVO(id, pw, nick);
      
      WMemberDAO dao = new WMemberDAO();
      
      int cnt = dao.join(vo);
      
      if(cnt > 0) {
         System.out.println("회원가입 성공!");
      } else {
         System.out.println("회원가입 실패.");
      }
      response.sendRedirect("main.jsp");
   }

}
