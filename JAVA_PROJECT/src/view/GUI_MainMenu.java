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

public class GUI_MainMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_MainMenu window = new GUI_MainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		my_reservation.setBorder(new LineBorder(new Color(0, 0, 0)));
		my_reservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		my_reservation.setBackground(Color.WHITE);
		my_reservation.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		my_reservation.setBounds(73, 134, 236, 59);
		panel.add(my_reservation);
		
		JButton tb_reservation = new JButton("\uC2B9\uCC28\uAD8C \uC608\uB9E4");
		tb_reservation.setBorder(new LineBorder(new Color(0, 0, 0)));
		tb_reservation.setBackground(Color.WHITE);
		tb_reservation.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		tb_reservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		tb_reservation.setBounds(73, 335, 236, 59);
		panel.add(tb_reservation);
		
	    String imgPath = this.getClass().getResource(".").getPath()+"..//..//img//aa.jpg";
	    System.out.println(imgPath);
	      
		ImageIcon icon = new ImageIcon(imgPath);
		JPanel panel_1 = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),0,0,panel.getWidth(),panel.getHeight(),null);
				setOpaque(false);
				super.paintComponent(g);
			}
			};
		

		
		
		panel_1.setBounds(0, 0, 389, 561);
		frame.getContentPane().add(panel_1);
	}

	private void setBackground(Color color) {
		// TODO Auto-generated method stub
		
	}
}
