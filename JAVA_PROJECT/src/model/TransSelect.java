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
	ArrayList<TransInfo> list = new ArrayList<>();

	@Override
	public ArrayList<TransInfo> transSelect(String depart_date, String depart, String dest) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			String sql = "SELECT TRANS_SERV_NUM, TRANS_TYPE, TRANS_NUM, TRANS_DEP_TIME,TRANS_ARR_TIME,TRANS_GRADE,TRANS_SEAT,TRANS_FARE"+
					    " FROM TRANS_INFO"+ 
					    " WHERE TRANS_DEP_TIME =? AND TRANS_DEP_LOC =? AND TRANS_DEST_LOC =?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, depart_date);
			psmt.setString(2, depart);
			psmt.setString(3, dest);
			//psmt.setString();
			rs = psmt.executeQuery();

			if (rs.next()) {
				String serv_num = rs.getString("TRANS_SERV_NUM");
				String type = rs.getString("TRANS_TYPE");
				String num = rs.getString("TRANS_NUM");
				String dep_time = rs.getString("TRANS_DEP_TIME");
				String arr_time = rs.getString("TRANS_ARR_TIME");
				String grade = rs.getString("TRANS_GRADE");
				String seat = rs.getString("TRANS_SEAT");
				String fare = rs.getString("TRANS_FARE");
				TransInfo m = new TransInfo(serv_num, type, num, dep_time, arr_time, grade,seat,fare);
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
