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
	public int bookingPayment() {

		int rows=0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			String sql = "INSERT INTO BOOK VALUES(?,?,?,?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "ti.getbooknum");
			psmt.setString(2, "ti.getuserid");
			psmt.setString(3, "ti.getdep_locnum");
			psmt.setString(4, "ti.getarr_ocnum");
			psmt.setString(5, "ti.getserv_num");
			psmt.setString(6, "ti.getdep_t");
			psmt.setString(7, "ti.getarrT");
			psmt.setString(8, "ti.getbooknum");
			psmt.setString(9, "ti.getbookfare");
			psmt.setString(10, "ti.getbookdate");
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
