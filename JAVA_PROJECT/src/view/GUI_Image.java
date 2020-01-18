
package view;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import model.Member;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI_Image {
	
	private JFrame frame;
	private JPanel panel;
	ImageIcon icon;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * @param str 
	 */
	public GUI_Image(String str, Member loginUser) {
		
		initialize(str, loginUser);
		
		frame.setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String str, Member loginUser) {
		if(str.equals("서울")) {
			
			icon = new ImageIcon(this.getClass().getResource(".").getPath() + "..//..//img//캡처.png");
		}else if(str.equals("서울")) {
			icon = new ImageIcon(this.getClass().getResource(".").getPath() + "..//..//img//캡처1.png");
		}else if(str.equals("부산")) {
			icon = new ImageIcon(this.getClass().getResource(".").getPath() + "..//..//img//캡처2.png");
		}else if(str.equals("대구")) {
			icon = new ImageIcon(this.getClass().getResource(".").getPath() + "..//..//img//캡처3.png");
		}else if(str.equals("대전")) {
			icon = new ImageIcon(this.getClass().getResource(".").getPath() + "..//..//img//캡처4.png");
		}else if(str.equals("인천")) {
			icon = new ImageIcon(this.getClass().getResource(".").getPath() + "..//..//img//캡처5.png");
		}else if(str.equals("광주")) {
			icon = new ImageIcon(this.getClass().getResource(".").getPath() + "..//..//img//gwangju.jpg");
		}else if(str.equals("울산")) {
			icon = new ImageIcon(this.getClass().getResource(".").getPath() + "..//..//img//캡처7.png");
		}else if(str.equals(" ")) {
			icon = new ImageIcon(this.getClass().getResource(".").getPath()+"..//..//img//울산빛축제.png");
		}
		frame = new JFrame();
		frame.setBounds(100, 100, 1028, 631);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);


		panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, panel.getWidth(), panel.getHeight(), null);
				setOpaque(false);
				super.paintComponent(g);
				
			}
		};
		
				springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, frame.getContentPane());
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				
				
				
			}
		});
		frame.getContentPane().add(panel);
	}
}