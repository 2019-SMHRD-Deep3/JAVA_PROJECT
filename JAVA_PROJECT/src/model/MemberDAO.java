package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "hr";
	private String password = "hr";
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;

	public int insert(Member m) {
		int rows = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			String sql = "INSERT INTO member VALUES(?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, m.getId());
			psmt.setString(2, m.getPw());
			psmt.setString(3, m.getName());
			psmt.setString(4, m.getBirth());
			psmt.setString(5, m.getPhone());
			psmt.setString(6, m.getEmail());
			rows = psmt.executeUpdate();
			if (rows == 0) {
				System.out.println("SQL문을 확인하세요");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 연결을 끊어주는 작업
			try {
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return rows;
	}

	public Member selectOne(Member m) { 
		Member loginUser = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			String sql = "SELECT * FROM member WHERE user_id = ? AND user_pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, m.getId());
			psmt.setString(2, m.getPw());
			rs = psmt.executeQuery();

			System.out.println(m.getId());
			System.out.println(m.getPw());
			if (rs.next()) {
				String id = rs.getString("USER_ID");
				String pw = rs.getString("USER_PW");
				String name = rs.getString("USER_NAME");
				String birth = rs.getString("USER_BIRTH");
				String phone = rs.getString("USER_PHONE");
				String email = rs.getString("USER_EMAIL");

				loginUser = new Member(id, pw, name, birth, phone, email);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return loginUser;
	}
}
