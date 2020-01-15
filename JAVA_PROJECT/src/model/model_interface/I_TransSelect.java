package model.model_interface;

import java.util.ArrayList;

import model.Member;

public interface I_TransSelect {
	public ArrayList<Member> transSelect(String depart_date, String depart, String dest);
}
