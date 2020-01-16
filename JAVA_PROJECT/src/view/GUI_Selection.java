package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import model.Member;

import javax.swing.SpringLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.print.attribute.standard.Destination;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI_Selection {

	private JFrame frame;
	private JTextField dest;
	private JTextField departure;
	String input_depart;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public GUI_Selection(Member loginUser) {
		
		initialize(loginUser);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Member loginUser) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC5EC\uD589\uC9C0\uC5ED \uC120\uD0DD");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setBounds(14, 12, 372, 90);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		
		JButton Backbtn = new JButton("\uC774\uC804 \uD654\uBA74\uC73C\uB85C");
		Backbtn.setBounds(211, 481, 170, 60);
		frame.getContentPane().add(Backbtn);
		Backbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		Backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
//		JButton btnLoc1 = new JButton("\uC11C\uC6B8");
//		btnLoc1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnLoc1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				GUI_Image img = new GUI_Image(loginUser);
//			}
//		});
//		btnLoc1.setBounds(461, 131, 97, 23);
//		frame.getContentPane().add(btnLoc1);
		
		
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		panel.setBounds(14, 134, 372, 244);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(2, 2, 2, 5));
		
		JLabel lblNewLabel_3 = new JLabel("\uCD9C\uBC1C\uC9C0\uC5ED");
		lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 20));
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("\uB3C4\uCC29\uC9C0\uC5ED");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);
		
		JPanel panel1 = new JPanel();
		panel.add(panel1);
		panel1.setLayout(null);

		String [] loc = {"서울","부산","대구","인천","광주","대전","울산"};
		JComboBox comboBox = new JComboBox(loc);
		comboBox.setBounds(46, 10, 97, 21);
		panel1.add(comboBox);
		comboBox.setSelectedIndex(6);
		
		dest = new JTextField();
		dest.setColumns(10);
		dest.setBounds(31, 66, 130, 24);
		
		JPanel panel2 = new JPanel();
		panel.add(panel2);
		panel2.setLayout(null);

		
		JButton btnNewButton = new JButton("\uB2E4\uC74C\uC73C\uB85C(\uC608\uB9E4\uD558\uAE30)");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				input_depart = loc[comboBox.getSelectedIndex()];
				//input_depart = depart.getText();
				String input_dest = dest.getText();
				GUI_Booking bo = new GUI_Booking(loginUser,input_depart,input_dest);
			}
		});
		
		btnNewButton.setBounds(19, 479, 170, 60);
		frame.getContentPane().add(btnNewButton);
		panel2.add(dest);
		
	
		
		JButton btnLoc1 = new JButton("\uC11C\uC6B8");
		btnLoc1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String str = "서울";
				GUI_Image img = new GUI_Image(str);
				dest.setText(str);
				
			}
		});
		btnLoc1.setBounds(461, 131, 97, 23);
		frame.getContentPane().add(btnLoc1);
		
		JButton btnLoc2 = new JButton("\uB300\uC804");
		btnLoc2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "대전";
				GUI_Image img = new GUI_Image(str);
				dest.setText(str);
			}
		});
		btnLoc2.setBounds(618, 131, 97, 23);
		frame.getContentPane().add(btnLoc2);
		
		JButton btnLoc3 = new JButton("\uC6B8\uC0B0");
		btnLoc3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "울산";
				GUI_Image img = new GUI_Image(str);
				dest.setText(str);
			}
		});
		btnLoc3.setBounds(461, 279, 97, 23);
		frame.getContentPane().add(btnLoc3);
		
		JButton btnLoc4 = new JButton("\uB300\uAD6C");
		btnLoc4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "대구";
				GUI_Image img = new GUI_Image(str);
				dest.setText(str);
			}
		});
		btnLoc4.setBounds(618, 279, 97, 23);
		frame.getContentPane().add(btnLoc4);
		
		JButton btnLoc5 = new JButton("\uAD11\uC8FC");
		btnLoc5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "광주";
				GUI_Image img = new GUI_Image(str);
				dest.setText(str);
			}
		});
		btnLoc5.setBounds(461, 427, 97, 23);
		frame.getContentPane().add(btnLoc5);
		
		JButton btnLoc6 = new JButton("\uBD80\uC0B0");
		btnLoc6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "부산";
				GUI_Image img = new GUI_Image(str);
				dest.setText(str);
			}
		});
		btnLoc6.setBounds(618, 427, 97, 23);
		frame.getContentPane().add(btnLoc6);
		
		JButton btnNewButton_1 = new JButton("인천");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "인천";
				GUI_Image img = new GUI_Image(str);
				dest.setText(str);
			}
		});
		btnNewButton_1.setBounds(461, 69, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		
		frame.setAutoRequestFocus(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
