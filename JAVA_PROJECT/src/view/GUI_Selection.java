package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SpringLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class GUI_Selection {

	private JFrame frame;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Selection window = new GUI_Selection();
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
	public GUI_Selection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC5EC\uD589\uC9C0\uC5ED \uC120\uD0DD");
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setBounds(14, 12, 372, 90);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(396, 12, 384, 539);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\uB2E4\uC74C\uC73C\uB85C(\uC608\uB9E4\uD558\uAE30)");
		btnNewButton.setBounds(19, 479, 170, 60);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnJbtn = new JButton("\uC774\uC804 \uD654\uBA74\uC73C\uB85C");
		btnJbtn.setBounds(211, 481, 170, 60);
		frame.getContentPane().add(btnJbtn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		panel_1.setBounds(14, 134, 372, 244);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(2, 2, 2, 5));
		
		JLabel lblNewLabel_3 = new JLabel("\uCD9C\uBC1C\uC9C0\uC5ED");
		lblNewLabel_3.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("\uB3C4\uCC29\uC9C0\uC5ED");
		lblNewLabel_2.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("\uC904\uBC1C\uC9C0\uC5ED");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(39, 23, 105, 27);
		panel.add(btnNewButton_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 68, 156, 21);
		panel.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(16, 66, 156, 24);
		panel_2.add(textField_1);
		
		JButton button = new JButton("\uB3C4\uCC29\uC9C0\uC5ED");
		button.setBounds(39, 23, 105, 27);
		panel_2.add(button);
		
		JButton btnNewButton_2 = new JButton("\uC11C\uC6B8");
		btnNewButton_2.setBounds(461, 131, 97, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton button_1 = new JButton("\uB300\uC804");
		button_1.setBounds(618, 131, 97, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\uC6B8\uC0B0");
		button_2.setBounds(461, 279, 97, 23);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("\uB300\uAD6C");
		button_3.setBounds(618, 279, 97, 23);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("\uAD11\uC8FC");
		button_4.setBounds(461, 427, 97, 23);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("\uBD80\uC0B0");
		button_5.setBounds(618, 427, 97, 23);
		frame.getContentPane().add(button_5);
		frame.setAutoRequestFocus(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
