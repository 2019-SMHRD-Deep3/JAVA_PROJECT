package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import model.model_interface.I_TransSelect;

public class TransSelect implements I_TransSelect {
	public String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public String user = "hr";
	public String password = "hr";
	public Connection conn = null;
	public PreparedStatement psmt = null;
	public ResultSet rs = null;
	ArrayList<TransInfo> list = new ArrayList<>();
	
	// value값으로 key를 찾는 메소드
	 public static <K, V> K getKey(Map<K, V> map, V value) {
	        // 찾을 hashmap 과 주어진 단서 value
	        for (K key : map.keySet()) {
	            if (value.equals(map.get(key))) {
	                return key;
	            }
	        }
	        return null;
	 }
	 
	@Override
	public ArrayList<TransInfo> transSelect(String depart_date, String depart, String dest) {
		try {
			Map<String, String> map = new HashMap();
			map.put("L1","서울");
			map.put("L2","부산");
			map.put("L3","대구");
			map.put("L4","인천");
			map.put("L5","광주");
			map.put("L6","대전");
			map.put("L7","울산");
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			String sql = "SELECT TRANS_SERV_NUM, TRANS_TYPE, TRANS_NUM, TRANS_DEP_TIME,TRANS_ARR_TIME,TRANS_GRADE,TRANS_SEAT,TRANS_FARE"+
					    " FROM TRANS_INFO"+ 
					    " WHERE TRANS_DEP_TIME =? AND TRANS_DEP_LOC =? AND TRANS_DEST_LOC =?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, depart_date);
			psmt.setString(2, getKey(map, depart));
			psmt.setString(3, getKey(map, dest));
			//psmt.setString();
			rs = psmt.executeQuery();

			if (rs.next()) {
				String serv_num = rs.getString("TRANS_SERV_NUM");
				String type = rs.getString("TRANS_TYPE");
				String num = rs.getString("TRANS_NUM");
				String dep_time = rs.getString("TRANS_DEP_TIME");
				String arr_time = rs.getString("TRANS_ARR_TIME");
				String grade = rs.getString("TRANS_GRADE");
				int seat = rs.getInt("TRANS_SEAT");
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
