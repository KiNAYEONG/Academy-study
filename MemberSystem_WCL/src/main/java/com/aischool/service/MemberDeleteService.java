package com.aischool.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aischool.model.WebMemberDAO;


@WebServlet("/MemberDeleteService")
public class MemberDeleteService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		System.out.println("삭제할 이메일: "+email);
		
		//1.WebMemberDAO객체 생성
		WebMemberDAO dao = new WebMemberDAO();
		
		//2.넘겨받을 이메일을 memberDelete()에 전달
		//  반환타입 : int
		int cnt = dao.memberDelete(email);
		
		//3.성공 시, MemberSelectAllService(멤버는 이름 길어서 뺐음)로 이동
		if(cnt > 0) {
			response.sendRedirect("SelectAllService");
		}
		
	}

}
