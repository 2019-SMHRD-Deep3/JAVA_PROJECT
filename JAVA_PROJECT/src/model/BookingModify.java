package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.model_interface.I_BookingModify;

public class BookingModify implements I_BookingModify {
	public String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public String user = "hr";
	public String password = "hr";
	public Connection conn = null;
	public PreparedStatement psmt = null;
	public ResultSet rs = null;

	// 예매수정하는 기능

	@Override
	public int bookingModify() {
		// TODO Auto-generated method stub
		return 0;
	}

}
