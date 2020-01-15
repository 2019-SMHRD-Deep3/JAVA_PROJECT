package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.model_interface.I_TransSelect;

public class TransSelect implements I_TransSelect {
	public String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public String user = "hr";
	public String password = "hr";
	public Connection conn = null;
	public PreparedStatement psmt = null;
	public ResultSet rs = null;
	ArrayList<Member> list = new ArrayList<>();

	@Override
	public ArrayList<Member> transSelect(String depart_date, String depart, String dest) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			String sql = "SELECT * FROM";
			psmt = conn.prepareStatement(sql);
			//psmt.setString();
			rs = psmt.executeQuery();

			if (rs.next()) {
				String id = rs.getString("USER_ID");
				String pw = rs.getString("USER_PW");
				String name = rs.getString("USER_NAME");
				String birth = rs.getString("USER_BIRTH");
				String phone = rs.getString("USER_PHONE");
				String email = rs.getString("USER_EMAIL");
				Member m = new Member(id, pw, name, birth, phone, email);
				list.add(m) ;
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
		return list;
		
	}

}
