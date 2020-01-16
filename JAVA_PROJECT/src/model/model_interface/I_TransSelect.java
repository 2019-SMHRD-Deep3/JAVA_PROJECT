package model.model_interface;

import java.util.ArrayList;

import model.Member;
import model.TransInfo;

public interface I_TransSelect {
	public ArrayList<TransInfo> transSelect(String depart_date, String depart, String dest);
}
