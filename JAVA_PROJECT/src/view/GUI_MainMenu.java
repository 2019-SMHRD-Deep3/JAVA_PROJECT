package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Member;

public class GUI_MainMenu {

	private JFrame frame;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_4;
	private JTextField dest;

	/**
	 * Create the application.
	 */
	public GUI_MainMenu(Member loginUser) {
		initialize(loginUser);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Member loginUser) {
		frame = new JFrame();
		frame.setBounds(100, 100, 960, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
///////////////////////////////////background image		
		String imgPath = this.getClass().getResource(".").getPath() + "..//..//img//gaboja.png";
		ImageIcon icon = new ImageIcon(imgPath);
		panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, panel.getWidth(), panel.getHeight(), null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		panel.setBounds(0, 0, 944, 501);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton tb_reservation = new JButton("\uC2B9\uCC28\uAD8C \uC608\uB9E4");
		tb_reservation.setBounds(221, 439, 148, 31);
		tb_reservation.setBorder(null);
		panel.add(tb_reservation);
		tb_reservation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUI_Selection selection = new GUI_Selection(loginUser);
				frame.dispose();
			}
		});
		tb_reservation.setBackground(Color.WHITE);
		tb_reservation.setFont(new Font("맑은 고딕", Font.PLAIN, 20));

		// 회원정보수정, 회원 탈퇴 기능, 회원정보확인
		JButton btnNewButton = new JButton("내정보");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 14));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(836, 7, 85, 31);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusPainted(false);
		panel.add(btnNewButton);

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUI_MemberMenu info = new GUI_MemberMenu(loginUser);
				frame.dispose();
			}
		});

		JButton my_reservation = new JButton("나의 예매정보");
		my_reservation.setBounds(569, 439, 148, 31);
		my_reservation.setBorder(null);
		panel.add(my_reservation);
		my_reservation.addMouseListener(new MouseAdapter() {
			// 나의 예매 정보 확인
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUI_BookingInfo bi = new GUI_BookingInfo(loginUser);
				frame.dispose();

			}
		});

		my_reservation.setBackground(Color.WHITE);
		my_reservation.setFont(new Font("맑은 고딕", Font.PLAIN, 20));

		JLabel lblNewLabel = new JLabel(loginUser.getName());
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(741, 12, 59, 20);
		panel.add(lblNewLabel);

		JLabel label = new JLabel("님");
		label.setFont(new Font("굴림", Font.PLAIN, 14));
		label.setForeground(Color.WHITE);
		label.setBounds(802, 12, 33, 20);
		panel.add(label);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(12, 57, 920, 434);
		panel.add(panel_1);
		panel_1.setLayout(null);

//////////banner 1		
		String imgPath2 = this.getClass().getResource(".").getPath() + "..//..//img//ulsan.png";
		ImageIcon icon2 = new ImageIcon(imgPath2);
		String imgPath3 = this.getClass().getResource(".").getPath() + "..//..//img//d.png";
		ImageIcon icon3 = new ImageIcon(imgPath3);
		String imgPath4 = this.getClass().getResource(".").getPath() + "..//..//img//sale.png";
		ImageIcon icon4 = new ImageIcon(imgPath4);

		panel_2 = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(icon2.getImage(), 0, 0, panel_2.getWidth(), panel_2.getHeight(), null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_2.setBounds(12, 10, 605, 336);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JButton btnNewButton_1 = new JButton(" ");
		{
			btnNewButton_1.setFocusPainted(false);
			btnNewButton_1.setContentAreaFilled(false);
			btnNewButton_1.setBorderPainted(false);

			btnNewButton_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					String str = " ";
					GUI_Image img = new GUI_Image(str, loginUser);
					dest.setText(str);
					
				}
			});
		}
		btnNewButton_1.setBounds(77, 255, 146, 48);
		panel_2.add(btnNewButton_1);

		panel_4 = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(icon4.getImage(), 0, 0, panel_4.getWidth(), panel_4.getHeight(), null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_4.setBounds(625, 10, 283, 336);
		panel_1.add(panel_4);

	}

	private void setBackground(Color color) {
		// TODO Auto-generated method stub

	}
}
