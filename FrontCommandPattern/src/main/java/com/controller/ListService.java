package com.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.front.Command;
import com.model.WMemberDAO;
import com.model.WMemberVO;

public class ListService implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		WMemberDAO dao = new WMemberDAO();
		ArrayList<WMemberVO> list = dao.list();
		
		HttpSession session = request.getSession();
		session.setAttribute("list", list);	
		
		return "list.jsp";
	}

}
