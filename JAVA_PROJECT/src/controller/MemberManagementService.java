package controller;

import java.util.ArrayList;

import model.Book;
import model.Member;
import model.MemberDAO;
import model.TransInfo;

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

	public boolean memberOut(Member m) {
		int rows = dao.memberout(m);
		if (rows == 0)
			return false;
		else
			return true;
	}

	public Book memberInfoSelect(Member loginuser) {
		return dao.memberinfoselect(loginuser);
	}

	public boolean memberInfoModify(Member m) {
		int rows = dao.memberinfomodify(m);
		if (rows == 0)
			return false;
		else
			return true;
	}

	public int bookingCancle(Member m) {
		dao.bookingcancle(m);
		return 0;
	}

	public int bookingModify(Member m) {
		dao.bookingmodify(m);
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

	public ArrayList<TransInfo> transSelect(String depart_date,String depart, String dest) {
		ArrayList<TransInfo> rslist = null;
		rslist = dao.transselect(depart_date,depart,dest);
		// TODO Auto-generated method stub
		return rslist;
	}
}

