package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import model.Member;

public class GUI_BookingModify {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public GUI_BookingModify(Member loginuser) {
		initialize(loginuser);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Member loginuser) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
