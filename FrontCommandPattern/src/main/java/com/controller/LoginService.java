package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.WMemberDAO;
import com.model.WMemberVO;


@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
   
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      String id = request.getParameter("id");  // 파라미터는 문자열 형태로 넘어온다
      String pw = request.getParameter("pw");
      
      WMemberVO vo = new WMemberVO(id, pw);
      
      WMemberDAO dao = new WMemberDAO(); //db랑 아이디, 비번
      WMemberVO info = dao.login(vo); //dao 통해서 로그인 성공하면 아/패/닉네임 가져오고 실패하면 null가져옴.
      
      if (info != null) {
    	  System.out.println("로그인 성공!");
    	  HttpSession session = request.getSession();
    	  session.setAttribute("info", info); //아/패/닉이 전부 저장된 info 넣기
      }else {
    	  System.out.println("로그인 실패!");
      }
      response.sendRedirect("main.jsp");
      
      
   }
}
