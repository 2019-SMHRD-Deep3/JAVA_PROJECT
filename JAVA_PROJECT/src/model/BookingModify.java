
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.model_interface.I_BookingModify;

public  class BookingModify implements I_BookingModify {
	public String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public String user = "hr";
	public String password = "hr";
	public Connection conn = null;
	public PreparedStatement psmt = null;
	public ResultSet rs = null;
	ArrayList<TransInfo> list = new ArrayList<>();
	// 예매수정하는 기능


	public ArrayList<TransInfo> transSelectDate(String depart_date) {
			

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, user, password);
				String sql = "SELECT * FROM Book " + "WHERE DEP_TIME = ? ";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1,depart_date);
				rs = psmt.executeQuery();

				while (rs.next()) {
					String dep_Loc = rs.getString("DEP_LOC_NUM");
					String arr_Loc = rs.getString("ARR_LOC_NUM");
					String s_Num = rs.getString("SERV_NUM");
					String dep_T= rs.getString("DEP_TIME");
					String arr_T = rs.getString("ARR_TIME");
					String nom = rs.getString("BOOK_NUM");
					int fare = rs.getInt("BOOK_FARE");
					String date = rs.getString("BOOK_DATE");
					
					TransInfo t = new TransInfo(dep_Loc, arr_Loc, s_Num, dep_T, arr_T, nom, fare, date );
					list.add(t);
					
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try { // ...7
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

	@Override
	public int bookingModify(TransInfo t) {
		// TODO Auto-generated method stub
		return 0;
	}

}