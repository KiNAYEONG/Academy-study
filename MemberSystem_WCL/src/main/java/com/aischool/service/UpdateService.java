package com.aischool.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aischool.model.WebMember;
import com.aischool.model.WebMemberDAO;
@WebServlet("/UpdateService")
public class UpdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//update.jsp에서 입력한 pw, tel, address 정보를 가져온 후 WebMember 객체로 생성
		request.setCharacterEncoding("UTF-8");
		
				HttpSession session = request.getSession(); 
				WebMember loginM = (WebMember)session.getAttribute("loginM");
				
				String email = loginM.getEmail(); 
				String pw = request.getParameter("pw");
				String tel = request.getParameter("tel");
				String address = request.getParameter("address");

				// 데이터베이스에 수정할 회원정보를 담는 객체 생성
				WebMember member = new WebMember(email, pw, tel, address);
				
				WebMemberDAO dao = new WebMemberDAO();
				
				int cnt = dao.memberUpdate(member);
				
				if (cnt > 0) {//회원정보 수정 완료
					session.setAttribute("loginM", member);
					response.sendRedirect("index.jsp");
				}else { //회원정보 수정 실패
					response.sendRedirect("update.jsp");
				}
		

			
		
	}

}
