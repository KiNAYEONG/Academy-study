package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WMemberDAO {

	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	// 데이터베이스 연결기능
	public void connect() {

		try {
			// 1.OracleDriver 동적 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.Connection객체 생성(DB연결)
			// - url, user, password 필요
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";

			conn = DriverManager.getConnection(url, user, password);

			if (conn == null) {
				System.out.println("DB연결 실패...");
			} else {
				System.out.println("DB연결 성공!");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 데이터베이스 연결종료 기능
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

	public int join(WMemberVO vo) {
		int cnt = 0;

		connect();

		String sql = "INSERT INTO WMEMBER VALUES(?,?,?)";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			pst.setString(2, vo.getPw());
			pst.setString(3, vo.getNick());
			cnt = pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

}
