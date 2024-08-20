package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.WMemberDAO;
import com.model.WMemberVO;


@WebServlet("/ListService")
public class ListService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WMemberDAO dao = new WMemberDAO();
		ArrayList<WMemberVO> list = dao.list();
		
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		
		response.sendRedirect("list.jsp");
	}

}
