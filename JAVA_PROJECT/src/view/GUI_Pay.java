package view;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
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
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

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
	 * 
	 * @param input_dest
	 * @param input_depart
	 * @param selTransInfo
	 */

	public GUI_Pay(Member loginUser, TransInfo selTransInfo, String input_depart, String input_dest) {

		initialize(loginUser, selTransInfo, input_depart, input_dest);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize(Member loginUser, TransInfo selTransInfo, String input_depart, String input_dest) {
		frame = new JFrame();
		frame.setBounds(100, 100, 960, 540);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		String imgPath = this.getClass().getResource(".").getPath() + "..//..//img//gaboja.png";

		ImageIcon icon = new ImageIcon(imgPath);

		JPanel panel = new JPanel() {
			protected void paintComponent(Graphics g) {

				g.drawImage(icon.getImage(), 0, 0, 960, 540, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		frame.getContentPane().add(panel, "name_1614660541439400");
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("출발");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel.setBounds(248, 154, 69, 23);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("도착");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(633, 154, 73, 23);
		panel.add(lblNewLabel_1);

		JLabel serv_num = new JLabel("운행정보");
		serv_num.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		serv_num.setForeground(Color.WHITE);
		serv_num.setBounds(47, 93, 69, 23);
		panel.add(serv_num);

		JLabel per = new JLabel("인원수");
		per.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		per.setForeground(Color.WHITE);
		per.setBounds(141, 365, 69, 23);
		panel.add(per);

		JLabel lblNewLabel_4 = new JLabel("교통수단");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(141, 274, 80, 23);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_6 = new JLabel("총 금액");
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(572, 365, 69, 23);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_2 = new JLabel("차량등급");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(141, 317, 69, 23);
		panel.add(lblNewLabel_2);

		dep = new JLabel(input_depart);
		dep.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		dep.setForeground(Color.WHITE);
		dep.setBounds(248, 187, 161, 15);
		panel.add(dep);

		depT = new JLabel(selTransInfo.getDep_time());
		depT.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		depT.setForeground(Color.WHITE);
		depT.setBounds(248, 212, 161, 15);
		panel.add(depT);

		arr = new JLabel(input_dest);
		arr.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		arr.setForeground(Color.WHITE);
		arr.setBounds(643, 187, 161, 15);
		panel.add(arr);

		arrT = new JLabel(selTransInfo.getArr_time());
		arrT.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		arrT.setForeground(Color.WHITE);
		arrT.setBounds(643, 212, 161, 15);
		panel.add(arrT);

		num = new JLabel(selTransInfo.getGrade());
		num.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		num.setBounds(233, 323, 161, 15);
		panel.add(num);

		type = new JLabel(selTransInfo.getType());
		type.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		type.setBounds(233, 280, 161, 15);
		panel.add(type);

		JLabel money = new JLabel("0");
		money.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		money.setForeground(Color.WHITE);
		money.setBounds(653, 371, 109, 15);
		panel.add(money);

		int fare = Integer.parseInt(selTransInfo.getFare());
		String[] count = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20" };
		JComboBox comboBox = new JComboBox(count);
		comboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox cb = (JComboBox) arg0.getSource();
				int index = cb.getSelectedIndex();
				money.setText((index) * fare + "원");
				book_nom = index;

			}
		});
		comboBox.setBounds(233, 368, 69, 21);
		panel.add(comboBox);

		JButton btnNewButton = new JButton("결제하기");
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int booknom = book_nom;
				GUI_Pay2 p2 = new GUI_Pay2(loginUser, selTransInfo, input_depart, input_dest, booknom);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(729, 430, 109, 37);
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(560, 430, 109, 37);
		panel.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));

		JButton btnNewButton_1 = new JButton("이전");
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUI_Booking booking = new GUI_Booking(loginUser, input_dest, input_dest);
				frame.dispose();
			}
		});
		panel_1.add(btnNewButton_1, "name_1541455851611300");

		JButton btnNewButton_2 = new JButton("");
		{
			btnNewButton_2.setFocusPainted(false);
			btnNewButton_2.setContentAreaFilled(false);
			btnNewButton_2.setBorderPainted(false);

			btnNewButton_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					GUI_MainMenu mainmanu = new GUI_MainMenu(null);

				}
			});

			btnNewButton_2.setBounds(12, 10, 153, 62);
			panel.add(btnNewButton_2);
		}
	}
}
