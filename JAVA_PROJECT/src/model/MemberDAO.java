package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	

}
