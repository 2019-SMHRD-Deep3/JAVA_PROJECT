package view;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.MemberManagementService;
import model.Book;
import model.Member;
import model.MemberDAO;
import model.TransInfo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_Pay {
//////////////////service 객체 생성 -> book객체를 service의 메소드에 넘겨줌
	MemberManagementService service = new MemberManagementService();
	private JFrame frame;
	private JLabel dep;
	private JLabel depT;
	private JLabel arr;
	private JLabel arrT;
	private JLabel servnum;
	private JLabel num;
	private JLabel type;
	private JLabel grade;
	private int book_nom;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * @param input_dest 
	 * @param input_depart 
	 * @param selTransInfo 
	 */

	public GUI_Pay(Member loginUser, TransInfo selTransInfo, String input_depart, String input_dest) {


		initialize(loginUser, selTransInfo,input_depart,input_dest);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize(Member loginUser,TransInfo selTransInfo, String input_depart, String input_dest) {
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

	
		JLabel lblNewLabel_6 = new JLabel("총 금액");
		lblNewLabel_6.setBounds(326, 510, 57, 15);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_2 = new JLabel("차량등급");
		lblNewLabel_2.setBounds(363, 295, 57, 15);
		panel.add(lblNewLabel_2);

		dep = new JLabel(input_depart);
		dep.setBounds(193, 49, 161, 15);
		panel.add(dep);

		depT = new JLabel(selTransInfo.getDep_time());
		depT.setBounds(470, 49, 161, 15);
		panel.add(depT);

		arr = new JLabel(input_dest);
		arr.setBounds(193, 93, 161, 15);
		panel.add(arr);

		arrT = new JLabel(selTransInfo.getArr_time());
		arrT.setBounds(470, 93, 161, 15);
		panel.add(arrT);

		servnum = new JLabel(selTransInfo.getServ_num());
		servnum.setBounds(156, 205, 161, 15);
		panel.add(servnum);

		num = new JLabel(selTransInfo.getNum());
		num.setBounds(489, 205, 161, 15);
		panel.add(num);

		type = new JLabel(selTransInfo.getType());
		type.setBounds(156, 295, 161, 15);
		panel.add(type);

		grade = new JLabel(selTransInfo.getGrade());
		grade.setBounds(489, 295, 161, 15);
		panel.add(grade);

		
		
		JLabel money = new JLabel(selTransInfo.getFare());
		money.setBounds(470, 510, 109, 15);
		panel.add(money);
		int fare=Integer.parseInt(selTransInfo.getFare());
		String[] count= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
		JComboBox comboBox = new JComboBox(count);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox cb=(JComboBox)arg0.getSource();
				int index=cb.getSelectedIndex();
				money.setText((index+1)*fare+"원");
				book_nom=index+1;
				
				
				
				
			}
		});
		comboBox.setBounds(156, 507, 69, 21);
		panel.add(comboBox);
		
		
		JButton btnNewButton = new JButton("결제하기");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int booknom=book_nom;
				service.bookingPayment(loginUser, selTransInfo,input_depart,input_dest,booknom);
				GUI_Pay2 p2= new GUI_Pay2();
			}
		});
		btnNewButton.setBounds(631, 506, 97, 23);
		panel.add(btnNewButton);

		
		


	}
}
