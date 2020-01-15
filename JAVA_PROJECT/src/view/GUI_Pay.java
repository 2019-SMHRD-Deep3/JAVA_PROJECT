package view;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Book;
import model.Member;
import model.MemberDAO;

public class GUI_Pay {

	private JFrame frame;
	private JTextField departure;
	private JTextField arrival;
	private JTextField serv_num;
	private JTextField departime;
	private JTextField arrivaltime;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField money;

// 객체생성
	MemberDAO dao = new MemberDAO();
// 객체생성
	Book bookUser;
	
	

	
	
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public GUI_Pay(Member loginUser) {
	
		initialize(loginUser);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Member loginUser) {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_1614660541439400");
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("출발");
		lblNewLabel.setBounds(55, 49, 57, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("도착");
		lblNewLabel_1.setBounds(55, 93, 57, 15);
		panel.add(lblNewLabel_1);
/////////////////////////////////////////////////////////////////////////////		
		departure = new JTextField();
		
		departure.setBounds(185, 46, 116, 21);
		panel.add(departure);
		departure.setColumns(10);
		
		arrival = new JTextField();
		arrival.setBounds(185, 90, 116, 21);
		panel.add(arrival);
		arrival.setColumns(10);
		
		JLabel 교통수단 = new JLabel("New label");
		교통수단.setBounds(55, 175, 57, 15);
		panel.add(교통수단);
		
		serv_num = new JTextField();
		serv_num.setBounds(185, 172, 116, 21);
		panel.add(serv_num);
		serv_num.setColumns(10);
		
		departime = new JTextField();
		departime.setBounds(414, 46, 116, 21);
		panel.add(departime);
		departime.setColumns(10);
		
		arrivaltime = new JTextField();
		arrivaltime.setBounds(414, 90, 116, 21);
		panel.add(arrivaltime);
		arrivaltime.setColumns(10);
		
		JLabel per = new JLabel("인원수");
		per.setBounds(414, 175, 57, 15);
		panel.add(per);
		
		textField_5 = new JTextField();
		textField_5.setBounds(538, 172, 116, 21);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(414, 247, 57, 15);
		panel.add(lblNewLabel_4);
		
		textField_6 = new JTextField();
		textField_6.setBounds(548, 244, 116, 21);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(414, 321, 57, 15);
		panel.add(lblNewLabel_5);
		
		textField_7 = new JTextField();
		textField_7.setBounds(548, 318, 116, 21);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton = new JButton("결제하기");
		btnNewButton.setBounds(631, 506, 97, 23);
		panel.add(btnNewButton);
		
		money = new JTextField();
		money.setBounds(414, 507, 116, 21);
		panel.add(money);
		money.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("총 금액");
		lblNewLabel_6.setBounds(297, 510, 57, 15);
		panel.add(lblNewLabel_6);
	}
}
