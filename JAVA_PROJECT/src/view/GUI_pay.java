package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;

public class GUI_pay {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_pay window = new GUI_pay();
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
	public GUI_pay() {
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
		panel.setBounds(12, 10, 166, 53);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JLabel label = new JLabel("\uC608\uB9E4\uB0B4\uC6A9 \uD655\uC778");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label, "name_1524714041282500");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(207, 73, 370, 478);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("\uCD9C\uBC1C\uC9C0");
		panel_1.add(lblNewLabel_1);
		
		JLabel 출발지 = new JLabel("New label");
		panel_1.add(출발지);
		
		JLabel lblNewLabel_3 = new JLabel("\uB3C4\uCC29\uC9C0");
		panel_1.add(lblNewLabel_3);
		
		JLabel 도착지 = new JLabel("New label");
		panel_1.add(도착지);
		
		JLabel lblNewLabel_2 = new JLabel("\uCD1D \uACB0\uC81C\uAE08\uC561");
		panel_1.add(lblNewLabel_2);
		
		JLabel 결제금액 = new JLabel("New label");
		panel_1.add(결제금액);
		
		JButton btnNewButton = new JButton("\uC608\uC57D\uD558\uAE30");
		btnNewButton.setBounds(641, 506, 131, 45);
		frame.getContentPane().add(btnNewButton);
	}
}
