package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.front.Command;

public class LogoutService  implements Command {

   public String execute(HttpServletRequest request, HttpServletResponse response) {
      
      HttpSession session = request.getSession();
      session.invalidate();;  // 특정 자료를 삭제하는 방법 removeAttribute, 전체 섹션을 삭제하는 방법 invalidate
      
      System.out.println("로그아웃 성공!");
      
      return "main.jsp";
      
      
   }

}
