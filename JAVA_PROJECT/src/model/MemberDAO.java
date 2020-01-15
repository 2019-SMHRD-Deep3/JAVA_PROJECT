package model;

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
	public void memberinfoselect() {
		// TODO Auto-generated method stub
		
	}
	public void memberinfomodify() {
		// TODO Auto-generated method stub
		
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
