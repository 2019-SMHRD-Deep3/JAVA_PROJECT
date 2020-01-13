package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class GUIMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMain window = new GUIMain();
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
	public GUIMain() {
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
		panel.setBounds(211, 91, 362, 123);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JLabel label = new JLabel("\uAC00 \uBCF4 \uC790");
		label.setFont(new Font("문체부 쓰기 흘림체", Font.PLAIN, 47));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label, "name_1456433607046100");
		
		JButton btnNewButton = new JButton("\uB85C\uADF8\uC778");
		btnNewButton.setBounds(211, 397, 144, 41);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("\uD68C\uC6D0\uAC00\uC785");
		button.setBounds(429, 397, 144, 41);
		frame.getContentPane().add(button);
	}
}
