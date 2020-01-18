
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

	public ArrayList<Book> memberInfoSelect(Member loginuser) {
		return dao.memberinfoselect(loginuser);
	}

	public boolean memberInfoModify(Member m) {
		int rows = dao.memberinfomodify(m);
		if (rows == 0)
			return false;
		else
			return true;
	}

	public boolean bookingCancle(Member m) {
		int rows = dao.bookingcancle(m);
		if(rows == 0)
			return false;
		else
			return true;
	}

	public int bookingModify(TransInfo t) {
		dao.bookingmodify(t);
		return 0;
	}



	public int bookingPayment(Member loginUser, TransInfo selTransInfo, String input_depart, String input_dest,int booknom) {
		dao.bookingpayment(loginUser, selTransInfo, input_depart, input_dest,booknom);
		return 0;
	}

	public ArrayList<TransInfo> transSelect(String depart_date, String depart, String dest) {
		ArrayList<TransInfo> rslist = null;
		rslist = dao.transselect(depart_date, depart, dest);
		// TODO Auto-generated method stub
		return rslist;
	}

}
