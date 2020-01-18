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
import java.awt.GridBagLayout;
import javax.swing.JRadioButton;

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
	private int book_nom1;
	private int book_nom2;
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
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel.setBounds(317, 130, 50, 23);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("도착");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(317, 164, 50, 23);
		panel.add(lblNewLabel_1);

		JLabel per = new JLabel("성인");
		per.setHorizontalAlignment(SwingConstants.CENTER);
		per.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		per.setForeground(Color.BLACK);
		per.setBounds(483, 229, 80, 25);
		panel.add(per);

		JLabel lblNewLabel_4 = new JLabel("교통수단");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setBounds(151, 229, 80, 25);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_6 = new JLabel("총 금액");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setBounds(536, 324, 80, 25);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_2 = new JLabel("차량등급");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(151, 272, 80, 25);
		panel.add(lblNewLabel_2);

		num = new JLabel(selTransInfo.getGrade());
		num.setHorizontalAlignment(SwingConstants.CENTER);
		num.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		num.setBounds(233, 274, 161, 19);
		panel.add(num);

		String transtype = null;
		if (selTransInfo.getType().equals("Trans1")) {
			transtype = "버스";
		} else {
			transtype = "기차";
		}
		type = new JLabel(transtype);
		type.setHorizontalAlignment(SwingConstants.CENTER);
		type.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		type.setBounds(233, 234, 161, 15);
		panel.add(type);

		JLabel studentmoney = new JLabel("0");
		studentmoney.setHorizontalAlignment(SwingConstants.CENTER);
		studentmoney.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		studentmoney.setForeground(Color.BLACK);
		studentmoney.setBounds(716, 274, 122, 21);
		panel.add(studentmoney);
////////////////////// combobox adult
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
				
				book_nom1 = index;

			}
		});
		
		JLabel adultmoney = new JLabel("0원");
		adultmoney.setHorizontalAlignment(SwingConstants.CENTER);
		adultmoney.setForeground(Color.BLACK);
		adultmoney.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		adultmoney.setBounds(716, 236, 122, 21);
		panel.add(adultmoney);
		comboBox.setBounds(575, 231, 80, 21);
		panel.add(comboBox);
		
		
///////////////////////// combobox student		
		String[] studentcount = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20" };
		JComboBox comboBox_1 = new JComboBox(studentcount);
		comboBox_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(575, 274, 80, 21);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox cb = (JComboBox) arg0.getSource();
				int index = cb.getSelectedIndex();
				studentmoney.setText((index) * fare/2 + "원");
				book_nom2 = index;

			}
		});
		panel.add(comboBox_1);

		
		

		JButton btnNewButton = new JButton("결제하기");
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int booknom = book_nom1+book_nom2;
				GUI_Pay2 p2 = new GUI_Pay2(loginUser, selTransInfo, input_depart, input_dest, book_nom1, book_nom2);
				

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
		panel_1.setBounds(416, 130, 292, 62);
		panel.add(panel_1);
		panel_1.setLayout(null);

		dep = new JLabel(input_depart);
		dep.setBounds(0, 0, 85, 31);
		panel_1.add(dep);
		dep.setHorizontalAlignment(SwingConstants.CENTER);
		dep.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		dep.setForeground(Color.BLACK);
		
		String dep_time = selTransInfo.getDep_time().substring(0, 16);
		
		depT = new JLabel(dep_time);
		depT.setBounds(97, 2, 192, 31);
		panel_1.add(depT);
		depT.setHorizontalAlignment(SwingConstants.CENTER);
		depT.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		depT.setForeground(Color.BLACK);

		arr = new JLabel(input_dest);
		arr.setBounds(0, 31, 85, 31);
		panel_1.add(arr);
		arr.setHorizontalAlignment(SwingConstants.CENTER);
		arr.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		arr.setForeground(Color.BLACK);

		String arr_time = selTransInfo.getArr_time().substring(0, 16);
		arrT = new JLabel(arr_time);
		arrT.setBounds(97, 33, 192, 31);
		panel_1.add(arrT);
		arrT.setHorizontalAlignment(SwingConstants.CENTER);
		arrT.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		arrT.setForeground(Color.BLACK);
		
		JLabel label = new JLabel("학생");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label.setBounds(483, 272, 80, 25);
		panel.add(label);
		
		JLabel moneysum = new JLabel("0원");
		moneysum.setHorizontalAlignment(SwingConstants.CENTER);
		moneysum.setForeground(Color.BLACK);
		moneysum.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		moneysum.setBounds(716, 324, 122, 21);
		panel.add(moneysum);
		
		

		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUI_Booking booking = new GUI_Booking(loginUser, input_depart, input_dest);
				frame.dispose();
			}
		});
	}
}
