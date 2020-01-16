
package controller;

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

	public boolean memberInfoSelect() {
		dao.memberinfoselect();
		return false;
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

	public int bookingModify(TransInfo t) {
		dao.bookingmodify(t);
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

	public void transSelect(String depart_date,String depart, String dest) {
		dao.transselect(depart_date,depart,dest);
		// TODO Auto-generated method stub
		
	}
}

