
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

	public int num=4;
	public String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public String user = "hr";
	public String password = "hr";
	public Connection conn = null;
	public PreparedStatement psmt = null;
	public PreparedStatement psmtSeq = null;
	public ResultSet rs = null;
	public ResultSet rsSeq = null;

	@Override
	// 결제하는 기능
	public int bookingPayment(Member loginUser,TransInfo selTransInfo, String input_depart, String input_dest,int book_nom1, int book_nom2) {

		int rows=0;
		try {
			int money=Integer.parseInt(selTransInfo.getFare());
			int fare=(int)((book_nom1*money)+(book_nom2*0.5*money));
			

			if(input_depart.equals("서울")) {
				input_depart="L1";
			}
			if(input_depart.equals("부산")) {
				input_depart="L2";
			}
			if(input_depart.equals("광주")) {
				input_depart="L3";
			}
			if(input_depart.equals("울산")) {
				input_depart="L4";
			}
			if(input_depart.equals("대구")) {
				input_depart="L5";
			}
			if(input_depart.equals("대전")) {
				input_depart="L6";
			}
			
			if(input_dest.equals("서울")) {
				input_dest="L1";
			}
			if(input_dest.equals("부산")) {
				input_dest="L2";
			}
			if(input_dest.equals("광주")) {
				input_dest="L3";
			}
			if(input_dest.equals("울산")) {
				input_dest="L4";
			}
			if(input_dest.equals("대구")) {
				input_dest="L5";
			}
			if(input_dest.equals("대전")) {
				input_dest="L6";
			}
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			String sql = "INSERT INTO BOOK VALUES(?,?,?,?,?,?,?,?,?,sysdate)";
			String sqlGetSeqnum = "SELECT book_seq.NEXTVAL FROM DUAL";
			psmtSeq = conn.prepareStatement(sqlGetSeqnum);
			psmt = conn.prepareStatement(sql);
			rsSeq = psmtSeq.executeQuery();
			String value = "";
			if(rsSeq.next()) {
				value = rsSeq.getString(1);
			}
			psmt.setString(1, "booking"+value);
			psmt.setString(2, loginUser.getId());
			psmt.setString(3, input_depart);
			psmt.setString(4, input_dest);
			psmt.setInt(5, selTransInfo.getServ_num());
			psmt.setString(6, selTransInfo.getDep_time());
			psmt.setString(7, selTransInfo.getArr_time());
			psmt.setInt(8, book_nom1+book_nom2);
			psmt.setInt(9, fare);
			
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

