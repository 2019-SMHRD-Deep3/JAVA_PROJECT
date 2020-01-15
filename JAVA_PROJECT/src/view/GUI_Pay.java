package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GUI_Pay {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField money;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Pay window = new GUI_Pay();
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
	public GUI_Pay() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_1614660541439400");
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(55, 49, 57, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(55, 93, 57, 15);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(185, 46, 116, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(185, 90, 116, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(55, 175, 57, 15);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(185, 172, 116, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(414, 46, 116, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(414, 90, 116, 21);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(414, 175, 57, 15);
		panel.add(lblNewLabel_3);
		
		textField_5 = new JTextField();
		textField_5.setBounds(538, 172, 116, 21);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(414, 247, 57, 15);
		panel.add(lblNewLabel_4);
		
		textField_6 = new JTextField();
		textField_6.setBounds(548, 244, 116, 21);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(414, 321, 57, 15);
		panel.add(lblNewLabel_5);
		
		textField_7 = new JTextField();
		textField_7.setBounds(548, 318, 116, 21);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(631, 506, 97, 23);
		panel.add(btnNewButton);
		
		money = new JTextField();
		money.setBounds(414, 507, 116, 21);
		panel.add(money);
		money.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("총 금액");
		lblNewLabel_6.setBounds(297, 510, 57, 15);
		panel.add(lblNewLabel_6);
	}
}
