package com.aischool.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmailCheckService")
public class EmailCheckService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		System.out.println("비동기통신으로 이메일 받아오기 >>" + email);

		PrintWriter out = response.getWriter();
		if (email.equals("admin")) {
			out.print("1");// 중복된 이메일
		} else {
			out.print("0");// 가입가능한 이메일
		}
	}

}
