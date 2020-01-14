
package view;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Canvas;

public class GUI_ChoiceSeat {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ChoiceSeat window = new GUI_ChoiceSeat();
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
	public GUI_ChoiceSeat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(145, 205, 627, 346);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(4, 10, 0, 0));
		
		JButton b1 = new JButton("1");
		b1.setBackground(SystemColor.control);
		b1.setForeground(new Color(0, 0, 0));
		panel.add(b1);
		
		JButton b2 = new JButton("2");
		b2.setBackground(SystemColor.control);
		panel.add(b2);
		
		JButton b3 = new JButton("3");
		b3.setBackground(SystemColor.control);
		panel.add(b3);
		
		JButton b4 = new JButton("4");
		b4.setBackground(SystemColor.control);
		panel.add(b4);
		
		JButton b5 = new JButton("5");
		b5.setBackground(SystemColor.control);
		panel.add(b5);
		
		JButton b6 = new JButton("6");
		b6.setBackground(SystemColor.control);
		panel.add(b6);
		
		JButton b7 = new JButton("7");
		b7.setBackground(SystemColor.control);
		panel.add(b7);
		
		JButton b8 = new JButton("8");
		b8.setBackground(SystemColor.control);
		panel.add(b8);
		
		JButton b9 = new JButton("9");
		b9.setBackground(SystemColor.control);
		panel.add(b9);
		
		JLabel lblNewLabel = new JLabel("");
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		panel.add(lblNewLabel_7);
		
		JButton b10 = new JButton("10");
		b10.setBackground(SystemColor.control);
		panel.add(b10);
		
		JButton b11 = new JButton("11");
		b11.setBackground(SystemColor.control);
		panel.add(b11);
		
		JButton b12 = new JButton("12");
		b12.setBackground(SystemColor.control);
		panel.add(b12);
		
		JButton b13 = new JButton("13");
		b13.setBackground(SystemColor.control);
		panel.add(b13);
		
		JButton b14 = new JButton("14");
		b14.setBackground(SystemColor.control);
		panel.add(b14);
		
		JButton b15 = new JButton("15");
		b15.setBackground(SystemColor.control);
		panel.add(b15);
		
		JButton b16 = new JButton("16");
		b16.setBackground(SystemColor.control);
		panel.add(b16);
		
		JButton b17 = new JButton("17");
		b17.setBackground(SystemColor.control);
		panel.add(b17);
		
		JButton b18 = new JButton("18");
		b18.setBackground(SystemColor.control);
		panel.add(b18);
		
		JButton b19 = new JButton("19");
		b19.setBackground(SystemColor.control);
		panel.add(b19);
		
		JButton b20 = new JButton("20");
		b20.setBackground(SystemColor.control);
		panel.add(b20);
		
		JButton b21 = new JButton("21");
		b21.setBackground(SystemColor.control);
		panel.add(b21);
		
		JButton b22 = new JButton("22");
		b22.setBackground(SystemColor.control);
		panel.add(b22);
		
		JButton b23 = new JButton("23");
		b23.setBackground(SystemColor.control);
		panel.add(b23);
		
		JButton b24 = new JButton("24");
		b24.setBackground(SystemColor.control);
		panel.add(b24);
		
		JButton b25 = new JButton("25");
		b25.setBackground(SystemColor.control);
		panel.add(b25);
		
		JButton b26 = new JButton("26");
		b26.setBackground(SystemColor.control);
		panel.add(b26);
		
		JButton b27 = new JButton("27");
		b27.setBackground(SystemColor.control);
		panel.add(b27);
		
		JButton btnNewButton_1 = new JButton("28");
		btnNewButton_1.setBackground(SystemColor.control);
		panel.add(btnNewButton_1);
////////// image 
		String imgPath = this.getClass().getResource(".").getPath() + "..//..//img//출입구.png";
		System.out.println(imgPath);
		ImageIcon icon = new ImageIcon(imgPath);
		
		JPanel panel_1 = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 30, 0, 105, 105, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_1.setBounds(12, 205, 133, 176);
		frame.getContentPane().add(panel_1);
		
		String imgPath2 = this.getClass().getResource(".").getPath() + "..//..//img//운전석.png";
		System.out.println(imgPath2);
		ImageIcon icon2 = new ImageIcon(imgPath2);
		
		JPanel panel_2 = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(icon2.getImage(), 30, 70, 120, 120, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_2.setBounds(12, 380, 133, 171);
		frame.getContentPane().add(panel_2);
	}
}