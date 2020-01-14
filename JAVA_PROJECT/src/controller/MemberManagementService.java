package controller;

import model.Member;
import model.MemberDAO;

public class MemberManagementService {
	
	private MemberDAO dao = new MemberDAO();
	
	public boolean memberJoin(Member m) {
		int rows = dao.insert(m);
		if (rows == 0)
			return false;
		else
			return true;
	}

	public Member memberLogin(Member m) {
		Member loginUser = dao.selectOne(m);
		return loginUser;
	}

}
