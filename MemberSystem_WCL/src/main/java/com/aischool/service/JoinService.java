package com.aischool.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.aischool.model.WebMember;
import com.aischool.model.WebMemberDAO;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
   
//      // POST 방식일 경우 한글 데이터 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		//실습) index.jsp에서 입력한 회원가입 정보를 가져와서 콘솔창에 출력해보기!  
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
      
//      System.out.println(email+ "/" + pw + "/" + tel + "/" + address);

		WebMember member = new WebMember(email, pw, tel, address);

		WebMemberDAO dao = new WebMemberDAO();
		//SQL 성공 -> 1(행의 수에 따라 달라질 수 있음)
		//SQL 실패 -> 0		
		int cnt = dao.memberJoin(member);
		
		if(cnt > 0) { //회원가입 성공
		
			
			//회원 성공 페이지에 이메일을 출력하기 위해서 forward 방식으로 이동
			//이때 request 객체에 전달할 데이터를 저장
			request.setAttribute("email", email);
			
			RequestDispatcher dis 
				= request.getRequestDispatcher("joinSuccess.jsp");
			dis.forward(request, response);
			
		}else {//회원가입 실패
			response.sendRedirect("index.jsp");
		}

	}

}