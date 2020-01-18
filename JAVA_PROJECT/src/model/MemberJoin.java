package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.model_interface.I_MemberJoin;

public class MemberJoin implements I_MemberJoin{
	public String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public String user = "hr";
	public String password = "hr";
	public Connection conn = null;
	public PreparedStatement psmt = null;
	public ResultSet rs = null;
	@Override

	public int memberjoin(Member m) {
		// TODO Auto-generated method stub
		int rows = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			String sql = "INSERT INTO user_info VALUES(?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, m.getId());
			psmt.setString(2, m.getPw());
			psmt.setString(3, m.getName());
			psmt.setString(4, m.getBirth());
			psmt.setString(5, m.getPhone());
			psmt.setString(6, m.getEmail());
			rows = psmt.executeUpdate();
			if (rows == 0) {
				System.out.println("SQL���� Ȯ���ϼ���");
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
