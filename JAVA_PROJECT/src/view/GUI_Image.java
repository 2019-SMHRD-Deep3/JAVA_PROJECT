package view;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import model.Member;

public class GUI_Image {

	private JFrame frame;
	private JPanel panel;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public GUI_Image(Member loginuser) {
		initialize(loginuser);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Member loginuser) {
		frame = new JFrame();
		frame.setBounds(100, 100, 1028, 631);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		ImageIcon icon = new ImageIcon("D:\\img.jpg");
		
		panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),0,0,panel.getWidth(),panel.getHeight(),null);
				setOpaque(false);
				super.paintComponent(g);
			}
			};
		

		springLayout.putConstraint(SpringLayout.NORTH, panel, 44, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 86, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -42, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -82, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel);
	}
}

