package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

import model.Member;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI_MainMenu {

	private JFrame frame;
	private JPanel panel;


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
		
	    String imgPath = this.getClass().getResource(".").getPath()+"..//..//img//gaboja.png";
	      
		ImageIcon icon = new ImageIcon(imgPath);
		panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),0,0,panel.getWidth(),panel.getHeight(), null);
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
		tb_reservation.setFont(new Font("���� ���", Font.BOLD, 20));
		
		JButton btnNewButton = new JButton("내정보");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(836, 14, 83, 23);
		btnNewButton.setBorderPainted(false);
		panel.add(btnNewButton);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUI_MemberInfo info = new GUI_MemberInfo(loginUser);
				frame.dispose();
			}
		});
		
		JButton my_reservation = new JButton("나의 예매정보");
		my_reservation.setBounds(569, 439, 148, 31);
		my_reservation.setBorder(null);
		panel.add(my_reservation);
		my_reservation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUI_BookingInfo bi = new GUI_BookingInfo(loginUser);
				frame.dispose();
				
			}
		});
		
		my_reservation.setBackground(Color.WHITE);
		my_reservation.setFont(new Font("���� ���", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel(loginUser.getName());
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(726, 18, 55, 15);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("님");
		label.setForeground(Color.WHITE);
		label.setBounds(782, 18, 33, 15);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(24, 62, 895, 351);
		panel.add(panel_1);
	}

	private void setBackground(Color color) {
		// TODO Auto-generated method stub
		
	}
}

