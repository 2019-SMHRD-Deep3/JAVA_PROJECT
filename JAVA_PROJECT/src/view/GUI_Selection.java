
package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import model.Member;

import javax.swing.SpringLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.print.attribute.standard.Destination;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.JSpinner;

public class GUI_Selection {

	private JFrame frame;
	private JTextField dest;
	private JTextField departure;
	String input_depart;
	private JPanel panel_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public GUI_Selection(Member loginUser) {

		initialize(loginUser);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Member loginUser) {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setLayout(null);

		String[] loc = { "서울", "부산", "대구", "인천", "광주", "대전", "울산" };

//		JPanel panel_1 = new JPanel();
		String imgPath = this.getClass().getResource(".").getPath() + "..//..//img//selection map.png";
		ImageIcon icon = new ImageIcon(imgPath);
		panel_1 = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, panel_1.getWidth(), panel_1.getHeight(), null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		panel_1.setBounds(0, 0, 954, 511);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC5EC\uD589\uC9C0\uC5ED \uC120\uD0DD");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(105, 81, 270, 99);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

//		JButton btnLoc1 = new JButton("\uC11C\uC6B8");
//		btnLoc1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnLoc1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				GUI_Image img = new GUI_Image(loginUser);
//			}
//		});
//		btnLoc1.setBounds(461, 131, 97, 23);
//		frame.getContentPane().add(btnLoc1);

		JPanel panel = new JPanel();
		panel.setBounds(68, 190, 344, 177);
		panel_1.add(panel);
		panel.setBackground(Color.white);
		panel.setBorder(null);
		panel.setLayout(new GridLayout(2, 2, 2, 5));

		JLabel lblNewLabel_3 = new JLabel("\uCD9C\uBC1C\uC9C0\uC5ED");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_2 = new JLabel("\uB3C4\uCC29\uC9C0\uC5ED");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);

		JPanel panel1 = new JPanel();
		panel1.setBackground(UIManager.getColor("Button.disabledShadow"));
		panel.add(panel1);
		panel1.setLayout(null);
		JComboBox comboBox = new JComboBox(loc);
		comboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		comboBox.setBounds(37, 32, 97, 21);
		panel1.add(comboBox);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 0, 170, 85);
		panel1.add(separator);

		JSeparator separator_3 = new JSeparator();
		separator_3.setOpaque(true);
		separator_3.setBounds(0, 0, 43, 99);
		panel1.add(separator_3);

		dest = new JTextField();
		dest.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		dest.setColumns(10);
		dest.setBounds(20, 30, 130, 24);

		JPanel panel2 = new JPanel();
		panel2.setBackground(UIManager.getColor("Button.disabledShadow"));
		panel.add(panel2);
		panel2.setLayout(null);
		panel2.add(dest);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 0, 170, 85);
		panel2.add(separator_1);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(0, -86, 102, 236);
		panel2.add(separator_4);
		separator_4.setOrientation(SwingConstants.VERTICAL);

		JButton btnNewButton_2_1 = new JButton("예매하기");
		btnNewButton_2_1.setBackground(Color.WHITE);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_1.setBounds(172, 403, 135, 41);
		panel_1.add(btnNewButton_2_1);
		btnNewButton_2_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		btnNewButton_2_1.setFocusPainted(false);
		btnNewButton_2_1.setBorderPainted(false);

		JButton btnNewButton = new JButton("");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GUI_MainMenu main = new GUI_MainMenu(loginUser);
				frame.dispose();

			}
		});
		btnNewButton.setBounds(12, 10, 163, 41);
		panel_1.add(btnNewButton);

		JButton Seoul = new JButton("");
		Seoul.setFocusPainted(false);
		Seoul.setContentAreaFilled(false);
		Seoul.setBorderPainted(false);
		Seoul.setBounds(598, 159, 108, 41);
		panel_1.add(Seoul);
		Seoul.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

		JButton Incheon = new JButton("");
		Incheon.setBounds(520, 116, 108, 41);
		panel_1.add(Incheon);
		Incheon.setFocusPainted(false);
		Incheon.setContentAreaFilled(false);
		Incheon.setBorderPainted(false);
		Incheon.setBackground(Color.WHITE);
		Incheon.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

		JButton Daejeon = new JButton("");
		Daejeon.setFocusPainted(false);
		Daejeon.setContentAreaFilled(false);
		Daejeon.setBorderPainted(false);
		Daejeon.setBounds(621, 218, 108, 41);
		panel_1.add(Daejeon);
		Daejeon.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

		JButton Ulsan = new JButton("");
		Ulsan.setBounds(749, 294, 97, 31);
		Ulsan.setFocusPainted(false);
		Ulsan.setContentAreaFilled(false);
		Ulsan.setBorderPainted(false);
		panel_1.add(Ulsan);
		Ulsan.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

		JButton Gwangju = new JButton("");
		Gwangju.setBounds(587, 326, 108, 56);
		Gwangju.setFocusPainted(false);
		Gwangju.setContentAreaFilled(false);
		Gwangju.setBorderPainted(false);
		panel_1.add(Gwangju);
		Gwangju.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

		JButton Busan = new JButton("");
		Busan.setBounds(729, 326, 108, 41);
		Busan.setFocusPainted(false);
		Busan.setContentAreaFilled(false);
		Busan.setBorderPainted(false);
		panel_1.add(Busan);
		Busan.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

		JButton Daegu = new JButton("");
		Daegu.setBounds(700, 261, 108, 31);
		Daegu.setFocusPainted(false);
		Daegu.setContentAreaFilled(false);
		Daegu.setBorderPainted(false);
		panel_1.add(Daegu);
		Daegu.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		JLabel lblNewLabel_1 = new JLabel("여행지역 둘러보기 ▷");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(463, 56, 141, 15);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(449, 48, 168, 31);
		panel_1.add(panel_2);
		Daegu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "대구";
				GUI_Image img = new GUI_Image(str);
				dest.setText(str);
			}
		});
		Busan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "부산";
				GUI_Image img = new GUI_Image(str);
				dest.setText(str);
			}
		});
		Gwangju.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "광주";
				GUI_Image img = new GUI_Image(str);
				dest.setText(str);
			}
		});
		Ulsan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "울산";
				GUI_Image img = new GUI_Image(str);
				dest.setText(str);
			}
		});
		Daejeon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "대전";
				GUI_Image img = new GUI_Image(str);
				dest.setText(str);
			}
		});
		Incheon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "인천";
				GUI_Image img = new GUI_Image(str);
				dest.setText(str);
			}
		});
		Seoul.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String str = "서울";
				GUI_Image img = new GUI_Image(str);
				dest.setText(str);

			}
		});
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				input_depart = loc[comboBox.getSelectedIndex()];
				// input_depart = depart.getText();
				String input_dest = dest.getText();
				GUI_Booking bo = new GUI_Booking(loginUser, input_depart, input_dest);
				frame.dispose();
			}
		});

		frame.setAutoRequestFocus(false);
		frame.setBounds(100, 100, 960, 540);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}