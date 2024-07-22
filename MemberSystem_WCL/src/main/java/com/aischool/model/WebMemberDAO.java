package com.aischool.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// DAO(Data Access Object : 데이터 베이스 관련 기능을 관리하는 객체
// 1. Connection 객체
// 2. PreparedStatement 객체
// 3. ResultSet 객체

public class WebMemberDAO {
   
   private Connection conn;
   private PreparedStatement pst;
   private ResultSet rs;
   
   // 데이터베이스 연결 기능
   public void connect() {
      
      try {
         // 1. OracleDriver 동적 로딩
         Class.forName("oracle.jdbc.driver.OracleDriver");
         
         // 2. Connection 객체 생성 (DB 연결)
         // - URL , User , Password
         String url = "jdbc:oracle:thin:@localhost:1521:xe";
         String user = "hr";
         String password = "hr";
         
         conn = DriverManager.getConnection(url, user, password);
         
         if (conn == null) {
            System.out.println("DB연결 실패..");
         } else {
            System.out.println("DB연결 성공^^");
         }
         
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
         
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      
   }
   
   // 데이터베이스 연결 종료 기능
   public void close() {
      
      try {
         if (rs != null) { rs.close(); }         
         if (pst != null) { pst.close(); }
         if (conn != null) { conn.close(); }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
      
      
   }
   
   // 회원가입 기능
   public int memberJoin(WebMember member) {
      
      // 1. DB연결
      connect();
      int cnt = 0;
      
      try {
         // 2. 데이터를 저장하는 SQL문 생성 & 실행
         String sql = "insert into WEB_MEMBER values(?, ?, ?, ?)";   // 1번부터 시작 (0번 아님)
         pst = conn.prepareStatement(sql);
         pst.setString(1, member.getEmail());
         pst.setString(2, member.getPw());
         pst.setString(3, member.getTel());
         pst.setString(4, member.getAddress());

         // insert , update , delete SQL문을 실행할 때 사용하는 메소드
         // select SQL문을 실핼할 때 -> executeQuery();         
         // 3. SQL실행 결과처리
         cnt = pst.executeUpdate();   // 변경에 대한 이슈 : insert , update , delete, select  ...  결과값은 항상 int형 (정수타입으로 반환)

         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {  // 무조건 실행
         // 4. DB연결 종료
         close();
      }
      
      return cnt;

   }

   
   // 로그인 기능
   public WebMember memberLogin(WebMember member) {
            
      WebMember mem = null;
            
      connect();
            
      try {
         String sql = "select * from web_member where email=? and pw=?";
         
         pst = conn.prepareStatement(sql);
         
         pst.setString(1, member.getEmail());
         pst.setString(2, member.getPw());
         
         rs = pst.executeQuery();
         
         if (rs.next()) {  // 조회된 정보가 있는 상태
         
            String email = rs.getString(1);
            String pw = rs.getString(2);
            String tel = rs.getString("tel");
            String address = rs.getString("address");
            
            mem = new WebMember(email, pw, tel, address);
            
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();
      }
            
                  
      return mem;
            
   }
   
   // 정보수정 기능
   public int memberUpdate(WebMember member) {
      
      connect();
      int cnt = 0;
      
      try {
         String sql = "UPDATE WEB_MEMBER SET PW=?, TEL=?, ADDRESS=? WHERE EMAIL=?";
         pst = conn.prepareStatement(sql);
         pst.setString(1, member.getPw());
         pst.setString(2, member.getTel());
         pst.setString(3, member.getAddress());
         pst.setString(4, member.getEmail());
         
         cnt = pst.executeUpdate();
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();
      }
     
      
      return cnt;
   }

   
   // 전체회원정보 조회 기능
   public ArrayList<WebMember> memberSelect() {
      
      ArrayList<WebMember> list = new ArrayList<WebMember>();
      
      connect();
      									//      where email not in('admin')
      try {
         String sql = "SELECT EMAIL, TEL, ADDRESS FROM WEB_MEMBER ";
         pst = conn.prepareStatement(sql);
         
         //rs객체에는 email, tel, address 3개의 컬럼을 가진 데이터셋을 보관
         rs = pst.executeQuery();
         
         //다음 행으로 넘어갈 때 데이터가 조회되지 않을 때까지 반복
         //rs.next() -> 데이터가 있으면 true / 없으면 false
         while (rs.next()) {
            String email = rs.getString(1);
            String tel = rs.getString(2);
            String address = rs.getString(3);
            
            WebMember member = new WebMember();
            member.setEmail(email);
            member.setTel(tel);
            member.setAddress(address);
            
            list.add(member);
            
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();
      }
      
      
      return list;
   }

public int memberDelete(String email) {
	
	int cnt = 0;
	
	connect();
	
	
	
	try {
		String sql = "delete from web_member where email=?";
		pst = conn.prepareStatement(sql);
		pst.setString(1, email);
		
		cnt = pst.executeUpdate();
		
	} catch (SQLException e) {		
		e.printStackTrace();
	} finally {
		close();
	}
	
	return cnt;
}

   
   
   
   
   
}


