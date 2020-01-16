
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	public int bookingPayment(Member loginUser,TransInfo selTransInfo, String input_depart, String input_dest,int booknom) {

		int rows=0;
		try {
			int money=Integer.parseInt(selTransInfo.getFare());
			int fare=booknom*money;
			
//			System.out.println(loginUser.getId());
//			System.out.println(input_depart);
//			System.out.println(input_dest);
//			System.out.println(selTransInfo.getServ_num());
			System.out.println(selTransInfo.getDep_time());
			System.out.println(selTransInfo.getArr_time());
			System.out.println(booknom);
			System.out.println(fare);
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			String sql = "INSERT INTO BOOK VALUES(?,?,?,?,?,?,?,?,?,sysdate)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "1");
			psmt.setString(2, loginUser.getId());
			psmt.setString(3, input_depart);
			psmt.setString(4, input_dest);
			psmt.setString(5, selTransInfo.getServ_num());
			psmt.setString(6, selTransInfo.getDep_time());
			psmt.setString(7, selTransInfo.getArr_time());
			psmt.setInt(8, booknom);
			psmt.setInt(9, money);
			
			rows = psmt.executeUpdate();
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

