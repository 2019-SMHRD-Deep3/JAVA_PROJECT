package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.model_interface.I_MemberInfoModify;
import model.model_interface.I_MemberInfoSelect;
import model.model_interface.I_MemberJoin;
import model.model_interface.I_MemberLogIn;

public class MemberDAO {

	
	
	public int memberjoin(Member m) {
		I_MemberJoin member = new MemberJoin();
		int rows = member.memberjoin(m);
		return rows;
	}
	public Member memberlogin(Member m) {
		I_MemberLogIn member = new MemberLogIn();
		Member loginuser = member.meberlogin(m);
		return loginuser;
	}
	
	public void memberout() {
		// TODO Auto-generated method stub
		
	}
	public Book memberinfoselect(Member loginuser) {
		// TODO Auto-generated method stub
		I_MemberInfoSelect info = new MemberInfoSelect();
		return info.memberInfoSelect(loginuser);
	}
	public int memberinfomodify(Member m) {
		I_MemberInfoModify member = new MemberInfoModify();
		int rows = member.memberinfomodify(m);
		return rows;
		
	}
	public void bookingcancle() {
		// TODO Auto-generated method stub
		
	}
	public void bookingmodify() {
		// TODO Auto-generated method stub
		
	}
	public void booking() {
		// TODO Auto-generated method stub
		
	}
	public Book bookingpayment() {
		BookingPayment bp = new BookingPayment();
		return bp.bookingPayment();
		
	}



	

}
