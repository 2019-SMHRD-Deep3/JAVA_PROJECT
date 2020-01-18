
package model.model_interface;

import java.util.ArrayList;

import model.Book;
import model.Member;

public interface I_MemberInfoSelect {
	public ArrayList<Book> memberInfoSelect(Member loginuser);
}

