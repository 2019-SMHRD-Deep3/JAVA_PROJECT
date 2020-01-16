
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.model_interface.I_BookingPayment;

public class BookingPayment implements I_BookingPayment {

	public String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public String user = "hr";
	public String password = "hr";
	public Connection conn = null;
	public PreparedStatement psmt = null;
	public ResultSet rs = null;

	@Override
	// 결제하는 기능
	public int bookingPayment(Member loginUser,TransInfo selTransInfo, String input_depart, String input_dest) {

		int rows=0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			String sql = "INSERT INTO BOOK VALUES(?,?,?,?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "1");
			psmt.setString(2, loginUser.getId());
			psmt.setString(3, input_depart);
			psmt.setString(4, input_dest);
			psmt.setString(5, selTransInfo.getServ_num());
			psmt.setString(6, selTransInfo.getDep_time());
			psmt.setString(7, selTransInfo.getArr_time());
			psmt.setString(8, "인원");
			psmt.setString(9, "요금");
			psmt.setString(10, "sysdate");
			if (rows == 0) {
				System.out.println("sql error");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

