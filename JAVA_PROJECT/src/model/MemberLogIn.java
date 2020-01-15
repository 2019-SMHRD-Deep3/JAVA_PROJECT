package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.model_interface.I_MemberLogIn;

public class MemberLogIn implements I_MemberLogIn {
	public String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public String user = "hr";
	public String password = "hr";
	public Connection conn = null;
	public PreparedStatement psmt = null;
	public ResultSet rs = null;
	@Override
	// 로그인 하는 기능
	public Member meberlogin(Member m) {
		// TODO Auto-generated method stub
		Member loginUser = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			String sql = "SELECT * FROM user_info WHERE user_id = ? AND user_pw = ?";
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
