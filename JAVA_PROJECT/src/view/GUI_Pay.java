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
	private JLabel num;
	private JLabel type;
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
		lblNewLabel.setBounds(55, 104, 57, 15);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("도착");
		lblNewLabel_1.setBounds(55, 206, 57, 15);
		panel.add(lblNewLabel_1);

		JLabel serv_num = new JLabel("운행정보");
		serv_num.setBounds(55, 36, 57, 15);
		panel.add(serv_num);

		JLabel per = new JLabel("인원수");
		per.setBounds(360, 247, 57, 15);
		panel.add(per);

		JLabel lblNewLabel_4 = new JLabel("교통수단");
		lblNewLabel_4.setBounds(360, 104, 57, 15);
		panel.add(lblNewLabel_4);

	
		JLabel lblNewLabel_6 = new JLabel("총 금액");
		lblNewLabel_6.setBounds(326, 510, 57, 15);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_2 = new JLabel("차량등급");
		lblNewLabel_2.setBounds(360, 166, 57, 15);
		panel.add(lblNewLabel_2);

		dep = new JLabel(input_depart);
		dep.setBounds(156, 104, 161, 15);
		panel.add(dep);

		depT = new JLabel(selTransInfo.getDep_time());
		depT.setBounds(156, 149, 161, 15);
		panel.add(depT);

		arr = new JLabel(input_dest);
		arr.setBounds(156, 206, 161, 15);
		panel.add(arr);

		arrT = new JLabel(selTransInfo.getArr_time());
		arrT.setBounds(156, 247, 161, 15);
		panel.add(arrT);

		num = new JLabel(selTransInfo.getGrade());
		num.setBounds(470, 166, 161, 15);
		panel.add(num);

		type = new JLabel(selTransInfo.getType());
		type.setBounds(470, 104, 161, 15);
		panel.add(type);

		
		
		JLabel money = new JLabel("0");
		money.setBounds(470, 510, 109, 15);
		panel.add(money);
		int fare=Integer.parseInt(selTransInfo.getFare());
		String[] count= {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
		JComboBox comboBox = new JComboBox(count);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox cb=(JComboBox)arg0.getSource();
				int index=cb.getSelectedIndex();
				money.setText((index)*fare+"원");
				book_nom=index;
				
				
				
				
			}
		});
		comboBox.setBounds(470, 244, 69, 21);
		panel.add(comboBox);
		
		
		JButton btnNewButton = new JButton("결제하기");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int booknom=book_nom;
				GUI_Pay2 p2= new GUI_Pay2(loginUser, selTransInfo,input_depart,input_dest,booknom);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(631, 506, 97, 23);
		panel.add(btnNewButton);
		
		JLabel label = new JLabel("할인");
		label.setBounds(360, 311, 57, 15);
		panel.add(label);

		
		


	}
}
