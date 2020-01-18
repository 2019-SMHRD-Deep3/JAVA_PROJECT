
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.model_interface.I_MemberOut;

public class MemberOut implements I_MemberOut {
	public String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public String user = "hr";
	public String password = "hr";
	Connection conn = null;
	PreparedStatement psmt = null;
	PreparedStatement psmtBookDel = null;

	@Override
	// 회원탈퇴 하는 기능
	public int memberOut(Member m) {
		int rows = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			String sqlBookDel = "DELETE FROM book WHERE user_id = ?";
			String sql = "DELETE FROM user_info WHERE user_id = ?";
			psmtBookDel = conn.prepareStatement(sqlBookDel);
			psmt = conn.prepareStatement(sql);
			psmtBookDel.setString(1, m.getId());
			psmt.setString(1, m.getId());
			
			psmtBookDel.executeUpdate();
			rows = psmt.executeUpdate();
			
			if (rows == 0) {
				System.out.println("SQL문을 확인하세요");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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


}