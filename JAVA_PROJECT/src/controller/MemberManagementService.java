package controller;

import model.Member;
import model.MemberDAO;

public class MemberManagementService {
	
	private MemberDAO dao = new MemberDAO();
	
	
	public boolean memberJoin(Member m) {
		int rows = dao.memberjoin(m);
		if (rows == 0)
			return false;
		else
			return true;
	}
	public Member memberLogin(Member m) {
		Member loginUser = dao.memberlogin(m);
		return loginUser;
	}
	
	public int memberOut() {
		dao.memberout();
		return 0;
	}
	
	public boolean memberInfoSelect() {
		dao.memberinfoselect();
		return false;
	}
	
	public int memberInfoModify() {
		dao.memberinfomodify();
		return 0;
	}
	
	public int bookingCancle() {
		dao.bookingcancle();
		return 0;
	}
	
	public int bookingModify() {
		dao.bookingmodify();
		return 0;
	}
	
	public boolean booking() {
		dao.booking();
		return false;
	}
	
	public int bookingPayment() {
		dao.bookingpayment();
		return 0;
	}
}
