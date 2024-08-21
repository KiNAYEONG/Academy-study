package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		int cnt = 0; // 여기는 null 아니어도 되나?

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

	public WMemberVO login(WMemberVO vo) {

		WMemberVO info = null;

		connect();
		String sql = "SELECT * FROM WMEMBER WHERE ID = ? AND PW = ?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			pst.setString(2, vo.getPw());
			rs = pst.executeQuery(); // select는 반드시 rs로 담아준다.

			// 로그인 성공, 커서 이동
			if (rs.next()) {
				String id = rs.getString(1); // getString("id")도 가능
				String pw = rs.getString(2);
				String nick = rs.getString(3); // 닉네임도 가져오기

				info = new WMemberVO(id, pw, nick); // 로그인 성공하면 info 바꿔치기
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}
		return info; // 로그인 실패하면 null 성공하면 아/패/닉
	}

	// 회원목록은 계속 추가되니까 가변성 있는 ArrayList 사용
	public ArrayList<WMemberVO> list() {

		ArrayList<WMemberVO> list = new ArrayList<WMemberVO>();

		connect();
		String sql = "SELECT * FROM WMEMBER";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String nick = rs.getString(3);

				WMemberVO vo = new WMemberVO(id, pw, nick);
				list.add(vo);
			}
		} catch (SQLException e) {
			close();
			e.printStackTrace();
		}

		return list;
	}

}
