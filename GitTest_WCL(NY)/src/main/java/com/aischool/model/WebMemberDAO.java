package com.aischool.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WebMemberDAO {
	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	// 데이터베이스 연결 기능
	public void connect() {
		try {
			// 1. OracleDriver 동적 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 객체 생성 (DB 연결)
			// - URL, User, Password
			String url = "jdbc:oracle:thin:@project-db-stu3.smhrd.com:1524:xe";
			String user = "Insa5_SpringA_hacksim_3";
			String password = "aishcool3";

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
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 회원정보 수정 기능
	public int memberUpdate(WebMember member) {
		connect();
		int cnt = 0;
		String sql = "UPDATE WEB_MEMBER SET pw=?, name=?, tel=?, address=? WHERE email=?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, member.getPw());
			pst.setString(2, member.getName());
			pst.setString(3, member.getTel());
			pst.setString(4, member.getAddress());
			pst.setString(5, member.getEmail());

			cnt = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// 비밀번호 확인 메서드
	public boolean checkPassword(String vendor_id, String pw) {
		boolean isValid = false;
		connect();

		String sql = "SELECT COUNT(*) FROM VENDOR WHERE VENDOR_ID = ? AND VENDOR_PW = ?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, vendor_id);
			pst.setString(2, pw);

			rs = pst.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				isValid = (count > 0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return isValid;
	}

	// 기업회원 삭제 메서드
    public int deleteVendor(String vendor_id, String vendor_pw) {
        int cnt = 0;
        connect();
        
        String sql = "DELETE FROM VENDOR WHERE VENDOR_ID = ? AND VENDOR_PW = ?";
        
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, vendor_id);
            pst.setString(2, vendor_pw);
            
            cnt = pst.executeUpdate();
            System.out.println("삭제된 행의 수: " + cnt);  // 디버깅 출력
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        
        return cnt;
    }
}