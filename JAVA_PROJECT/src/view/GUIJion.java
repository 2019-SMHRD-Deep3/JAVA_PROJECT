package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GUIJion {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIJion window = new GUIJion();
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
	public GUIJion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 760, 93);
		panel.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("\uAC00\uBCF4\uC790");
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 31));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel, "name_1457830998951300");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(108, 113, 568, 395);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(7, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
		panel_2.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		panel_2.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\uBE44\uBC00\uBC88\uD638\uD655\uC778");
		panel_2.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\uC774\uB984");
		panel_2.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\uC0DD\uB144\uC6D4\uC77C(YYMMDD)");
		panel_2.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\uC5F0\uB77D\uCC98");
		panel_2.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\uC774\uBA54\uC77C");
		panel_2.add(lblNewLabel_7);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton.setBounds(334, 518, 115, 33);
		panel.add(btnNewButton);
	}
}
