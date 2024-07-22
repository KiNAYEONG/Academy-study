package com.aischool.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aischool.model.WebMember;
import com.aischool.model.WebMemberDAO;

@WebServlet("/SelectAllService")
public class MemberSelectAllService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");	
	
	//1.WebMemberDAO 객체 생성
	WebMemberDAO dao = new WebMemberDAO();
	//2.DAO 객체 내 memberSelect() 메소드 호출
	//- DB에 저장된 모든 회원 정보를 조회하는 기능
	//- 반환타입: ArrayList<WebMember>
	ArrayList<WebMember> members = dao.memberSelect();
			
	//3.조회된 정보를 select.jsp로 전달
	//- forward 방식
	//- request객체 내 모든 회원 정보를 저장
	request.setAttribute("getMembers", members);
	
	RequestDispatcher dis = request.getRequestDispatcher("select.jsp");
	dis.forward(request, response);
	
	
	}

}
