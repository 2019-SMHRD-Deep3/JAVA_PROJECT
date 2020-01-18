
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Member;
import model.model_interface.I_MemberInfoSelect;

public class MemberInfoSelect implements I_MemberInfoSelect {
	public String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public String user = "hr";
	public String password = "hr";
	public Connection conn = null;
	public PreparedStatement psmt = null;
	public ResultSet rs = null;
	ArrayList<Book> list = new ArrayList<>();

	@Override
	// 예매정보를 조회하는 기능
	public ArrayList<Book> memberInfoSelect(Member loginuser) {
		
		// TODO Auto-generated method stub
			Book loginUser = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, user, password);
				String sql = "select * from BOOK WHERE USER_ID=?";

				psmt = conn.prepareStatement(sql);
				psmt.setString(1, loginuser.getId());
				rs = psmt.executeQuery();

				while (rs.next()) {
					//
					String booknum = rs.getString("BOOK_NUM");
					String dep = rs.getString("DEP_LOC_NUM");
					String arr = rs.getString("ARR_LOC_NUM");
					String servnum = rs.getString("SERV_NUM");
					String depT = rs.getString("DEP_TIME");
					String arrT = rs.getString("ARR_TIME");
					int per = rs.getInt("BOOK_NOM"); // 이용객의 명수
					String fare = rs.getString("BOOK_FARE"); // 요금

					Book b = new Book (booknum, dep, arr, servnum, depT, arrT, per, fare);
					list.add(b);
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
