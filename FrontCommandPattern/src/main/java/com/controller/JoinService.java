package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.front.Command;
import com.model.WMemberDAO;
import com.model.WMemberVO;

public class JoinService implements Command{

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id"); // 파라미터는 문자열 형태로 넘어온다
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nick");

		WMemberVO vo = new WMemberVO(id, pw, nick);

		WMemberDAO dao = new WMemberDAO();

		int cnt = dao.join(vo);

		if (cnt > 0) {
			System.out.println("회원가입 성공!");
		} else {
			System.out.println("회원가입 실패.");
		}
		return "main.jsp";
		
		
		
		
	}

}
