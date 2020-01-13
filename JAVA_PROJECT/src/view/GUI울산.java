package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class GUI울산 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI울산 window = new GUI울산();
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
	public GUI울산() {
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
		panel.setBounds(12, 10, 135, 61);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("\uC6B8\uC0B0");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, "name_1462338071176600");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 110, 360, 173);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("\uAD00\uAD11\uBA85\uC18C");
		lblNewLabel_1.setBounds(12, 85, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("\uAD00\uAD11\uBA85\uC18C");
		label.setBounds(412, 85, 57, 15);
		frame.getContentPane().add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(412, 110, 360, 173);
		frame.getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(12, 324, 760, 227);
		frame.getContentPane().add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("\uCD94\uCC9C\uCF54\uC2A4");
		lblNewLabel_2.setBounds(12, 299, 57, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\uC608\uB9E4\uD558\uAE30  ");
		btnNewButton.setBounds(675, 48, 97, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
