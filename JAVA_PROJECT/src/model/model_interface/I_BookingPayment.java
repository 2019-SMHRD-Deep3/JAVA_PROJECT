
package model.model_interface;

import model.Book;
import model.Member;
import model.TransInfo;

public interface I_BookingPayment {
	public int bookingPayment(Member loginUser,TransInfo selTransInfo, String input_depart, String input_dest);
}

