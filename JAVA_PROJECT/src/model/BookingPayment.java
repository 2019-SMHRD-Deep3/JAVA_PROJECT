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
	public Book bookingPayment() {

		Book bookUser = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			String sql="SELECT * FROM book WHERE user_id = ?" ;
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "TEST1" );
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String booknum=rs.getString("BOOOK_NUM");
				String dep=rs.getString("DEP_LOC_NUM");
				String arr=rs.getString("ARR_LOC_NUM");
				String servnum=rs.getString("SERV_NUM");
				String depT=rs.getString("DEP_TIME");
				String arrT=rs.getString("ARR_TIME");
				String per=rs.getString("BOOK_NOM");
				String fare=rs.getString("BOOK_FARE");
				
				bookUser = new Book(booknum, dep, arr, servnum, depT, arrT, per, fare);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
		
		
		return bookUser;
	}

}
