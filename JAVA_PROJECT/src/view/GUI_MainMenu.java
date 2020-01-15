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
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		


		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		panel.setBounds(389, 10, 383, 541);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(255,0,0,0));
		
		JButton my_reservation = new JButton("\uB098\uC758 \uC608\uB9E4\uC815\uBCF4");
		my_reservation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUI_BookingInfo bi = new GUI_BookingInfo(loginUser);
				
			}
		});
		my_reservation.setBorder(new LineBorder(new Color(0, 0, 0)));
		my_reservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		my_reservation.setBackground(Color.WHITE);
		my_reservation.setFont(new Font("���� ���", Font.BOLD, 20));
		my_reservation.setBounds(73, 134, 236, 59);
		panel.add(my_reservation);
		
		JButton tb_reservation = new JButton("\uC2B9\uCC28\uAD8C \uC608\uB9E4");
		tb_reservation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUI_Selection selection = new GUI_Selection(loginUser);
			}
		});
		tb_reservation.setBorder(new LineBorder(new Color(0, 0, 0)));
		tb_reservation.setBackground(Color.WHITE);
		tb_reservation.setFont(new Font("���� ���", Font.BOLD, 20));
		
		
		tb_reservation.setBounds(73, 237, 236, 59);
		panel.add(tb_reservation);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(73, 346, 236, 59);
		panel.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));
		
		JButton btnNewButton = new JButton("\uB098\uC758 \uD68C\uC6D0 \uC815\uBCF4");
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUI_MemberInfo info = new GUI_MemberInfo(loginUser);
			}
		});
		panel_2.add(btnNewButton, "name_1270455870133100");
		
	    String imgPath = this.getClass().getResource(".").getPath()+"..//..//img//����.png";
	    System.out.println(imgPath);
	      
		ImageIcon icon = new ImageIcon(imgPath);
		JPanel panel_1 = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),0,0,panel.getWidth(),panel.getHeight(),null);
				setOpaque(false);
				super.paintComponent(g);
			}
			};
		

		
		
		panel_1.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(panel_1);
	}

	private void setBackground(Color color) {
		// TODO Auto-generated method stub
		
	}
}
