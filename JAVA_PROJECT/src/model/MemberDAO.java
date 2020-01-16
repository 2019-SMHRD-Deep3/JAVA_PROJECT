package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.model_interface.I_BookingCancle;
import model.model_interface.I_MemberInfoModify;
import model.model_interface.I_MemberJoin;
import model.model_interface.I_MemberLogIn;
import model.model_interface.I_MemberOut;

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

	public int memberout(Member m) {
		I_MemberOut member = new MemberOut();
		int rows = member.memberOut(m);
		return rows;

	}

	public void memberinfoselect() {
		// TODO Auto-generated method stub

	}

	public int memberinfomodify(Member m) {
		I_MemberInfoModify member = new MemberInfoModify();
		int rows = member.memberinfomodify(m);
		return rows;

	}

	public int bookingcancle(Member m) {
		I_BookingCancle book = new BookingCancle();
		int rows = book.bookingcancle(m);
		return rows;

	}

	public void bookingmodify() {
		// TODO Auto-generated method stub

	}

	public void booking() {
		// TODO Auto-generated method stub

	}

	public void bookingpayment() {
		// TODO Auto-generated method stub

	}


}
