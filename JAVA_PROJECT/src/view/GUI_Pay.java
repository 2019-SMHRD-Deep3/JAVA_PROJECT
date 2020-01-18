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
import java.awt.GridLayout;

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

		String imgPath = this.getClass().getResource(".").getPath() + "..//..//img//pay_2.png";

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
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel.setBounds(317, 130, 50, 23);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("도착");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(317, 164, 50, 23);
		panel.add(lblNewLabel_1);

		JLabel per = new JLabel("인원수");
		per.setHorizontalAlignment(SwingConstants.CENTER);
		per.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		per.setForeground(Color.WHITE);
		per.setBounds(151, 322, 80, 25);
		panel.add(per);

		JLabel lblNewLabel_4 = new JLabel("교통수단");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(151, 229, 80, 25);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_6 = new JLabel("총 금액");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(558, 322, 80, 25);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_2 = new JLabel("차량등급");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(151, 272, 80, 25);
		panel.add(lblNewLabel_2);

		num = new JLabel(selTransInfo.getGrade());
		num.setHorizontalAlignment(SwingConstants.CENTER);
		num.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		num.setBounds(233, 274, 161, 19);
		panel.add(num);

		type = new JLabel(selTransInfo.getType());
		type.setHorizontalAlignment(SwingConstants.CENTER);
		type.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		type.setBounds(233, 234, 161, 15);
		panel.add(type);

		JLabel money = new JLabel("0");
		money.setHorizontalAlignment(SwingConstants.CENTER);
		money.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		money.setForeground(Color.WHITE);
		money.setBounds(641, 326, 122, 21);
		panel.add(money);

		int fare = Integer.parseInt(selTransInfo.getFare());
		String[] count = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20" };
		JComboBox comboBox = new JComboBox(count);
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox cb = (JComboBox) arg0.getSource();
				int index = cb.getSelectedIndex();
				money.setText((index) * fare + "원");
				book_nom = index;

			}
		});
		comboBox.setBounds(282, 324, 80, 21);
		panel.add(comboBox);

		JButton btnNewButton = new JButton("결제하기");
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int booknom = book_nom;
				GUI_Pay2 p2 = new GUI_Pay2(loginUser, selTransInfo, input_depart, input_dest, booknom);
				
			}
		});
		btnNewButton.setBounds(483, 424, 109, 37);
		panel.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("");
		{
			btnNewButton_2.setFocusPainted(false);
			btnNewButton_2.setContentAreaFilled(false);
			btnNewButton_2.setBorderPainted(false);

			btnNewButton_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					GUI_MainMenu mainmanu = new GUI_MainMenu(loginUser);
					frame.dispose();

				}
			});

			btnNewButton_2.setBounds(12, 10, 153, 62);
			panel.add(btnNewButton_2);
		}

		JButton btnNewButton_1 = new JButton("이전");
		btnNewButton_1.setBounds(308, 424, 109, 37);
		panel.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnNewButton_1.setBackground(Color.WHITE);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(416, 130, 364, 62);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 2, 0, 0));
		
				dep = new JLabel(input_depart);
				panel_1.add(dep);
				dep.setHorizontalAlignment(SwingConstants.CENTER);
				dep.setFont(new Font("맑은 고딕", Font.BOLD, 20));
				dep.setForeground(Color.BLACK);

		depT = new JLabel(selTransInfo.getDep_time());
		panel_1.add(depT);
		depT.setHorizontalAlignment(SwingConstants.CENTER);
		depT.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		depT.setForeground(Color.BLACK);
		
				arr = new JLabel(input_dest);
				panel_1.add(arr);
				arr.setHorizontalAlignment(SwingConstants.CENTER);
				arr.setFont(new Font("맑은 고딕", Font.BOLD, 20));
				arr.setForeground(Color.BLACK);

		arrT = new JLabel(selTransInfo.getArr_time());
		panel_1.add(arrT);
		arrT.setHorizontalAlignment(SwingConstants.CENTER);
		arrT.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		arrT.setForeground(Color.BLACK);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUI_Booking booking = new GUI_Booking(loginUser, input_depart, input_dest);
				frame.dispose();
			}
		});
	}
}
