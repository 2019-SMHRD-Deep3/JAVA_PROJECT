package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.model_interface.I_MemberInfoModify;


public class MemberInfoModify implements I_MemberInfoModify {
	public String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public String user = "hr";
	public String password = "hr";
	Connection conn = null;
	PreparedStatement psmt = null;
//	public ResultSet rs = null;

	@Override
	public int memberinfomodify(Member m) {

		      int rows = 0;
		      try {
		         Class.forName("oracle.jdbc.driver.OracleDriver");
		         conn = DriverManager.getConnection(url, user, password);
		         String sql = "UPDATE user_info SET user_pw = ?, user_name = ?, user_birth = ?, user_phone=?, user_email=?"
		               + " WHERE user_id = ?";
		         psmt = conn.prepareStatement(sql);
		         
		         psmt.setString(1, m.getPw());
		         psmt.setString(2, m.getName());
		         String birth = m.getBirth();
		         String[] dates = birth.split(" ")[0].split("-");
		         Date date = new Date(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2]));
		         psmt.setDate(3, date);
		         psmt.setString(4, m.getPhone());
		         psmt.setString(5, m.getEmail());
		         psmt.setString(6, m.getId());
		         
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
