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

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 사용자가 전달한 이메일(email), 패스워드(pw)를 변수에 저장하기
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");

		// 2. 이메일, 패스워드 콘솔창에 출력하기
		System.out.println(email + " | " + pw);

		// 3. 데이터베이스에 이메일, 패스워드를 전달하여 로그인 기능 구현하기
		WebMemberDAO dao = new WebMemberDAO();

		WebMember member = new WebMember();
		member.setEmail(email);
		member.setPw(pw);

		WebMember member2 = dao.memberLogin(member);

		if (member2 != null) {// 로그인 성공

			// 로그인한 회원정보를 서버에 저장 -> session 영역
			HttpSession session = request.getSession();
			session.setAttribute("loginM", member2);
			response.sendRedirect("index.jsp");

			
			System.out.println("로그인 성공");

		} else {// 로그인 실패
			response.sendRedirect("index.jsp");
			System.out.println("로그인 실패");
		}

	}

}
