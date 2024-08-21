package com.front;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.JoinService;
import com.controller.ListService;
import com.controller.LoginService;
import com.controller.LogoutService;
import com.model.WMemberDAO;
import com.model.WMemberVO;

// 모든것을 뜻하는 * + .do
@WebServlet("*.do")
public class FrontController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("프론트 컨트롤러 실행");
		// client가 요청한 url
		String url = request.getRequestURI();

		// Context-path값 가져오기
		String contextPath = request.getContextPath();

		// client 요청 url만 가져오기
		String command = url.substring(contextPath.length());

		request.setCharacterEncoding("UTF-8");
		
		String moveURL = null;
		
		Command com = null;
		
		if (command.equals("/Join.do")) {		
			com = new JoinService();
		} else if (command.equals("/Login.do")) {
			com = new LoginService();
		} else if (command.equals("/Logout.do")) {
			com = new LogoutService();
		} else if (command.equals("/List.do")) {
			com = new ListService();			
		}
		moveURL = com.execute(request,response);
		response.sendRedirect(moveURL);	
	}
}