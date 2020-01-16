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
		
		JLabel serv_num = new JLabel("운행정보");
		serv_num.setBounds(55, 205, 57, 15);
		panel.add(serv_num);
		
		JLabel per = new JLabel("인원수");
		per.setBounds(55, 510, 57, 15);
		panel.add(per);
		
		JLabel lblNewLabel_4 = new JLabel("교통수단");
		lblNewLabel_4.setBounds(55, 295, 57, 15);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("차량번호");
		lblNewLabel_5.setBounds(363, 205, 57, 15);
		panel.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("결제하기");
		btnNewButton.setBounds(631, 506, 97, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("총 금액");
		lblNewLabel_6.setBounds(326, 510, 57, 15);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_2 = new JLabel("차량등급");
		lblNewLabel_2.setBounds(363, 295, 57, 15);
		panel.add(lblNewLabel_2);
		
		JLabel dep = new JLabel("New label");
		dep.setBounds(193, 49, 161, 15);
		panel.add(dep);
		
		JLabel depT = new JLabel("New label");
		depT.setBounds(470, 49, 161, 15);
		panel.add(depT);
		
		JLabel arr = new JLabel("New label");
		arr.setBounds(193, 93, 161, 15);
		panel.add(arr);
		
		JLabel arrT = new JLabel("New label");
		arrT.setBounds(470, 93, 161, 15);
		panel.add(arrT);
		
		JLabel servnum = new JLabel("New label");
		servnum.setBounds(156, 205, 161, 15);
		panel.add(servnum);
		
		JLabel num = new JLabel("New label");
		num.setBounds(489, 205, 161, 15);
		panel.add(num);
		
		JLabel type = new JLabel("New label");
		type.setBounds(156, 295, 161, 15);
		panel.add(type);
		
		JLabel grade = new JLabel("New label");
		grade.setBounds(489, 295, 161, 15);
		panel.add(grade);
		
		JLabel person = new JLabel("New label");
		person.setBounds(111, 510, 161, 15);
		panel.add(person);
		
		JLabel fare = new JLabel("New label");
		fare.setBounds(406, 510, 161, 15);
		panel.add(fare);
	}
}

