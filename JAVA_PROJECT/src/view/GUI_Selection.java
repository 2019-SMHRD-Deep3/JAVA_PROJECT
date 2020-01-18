
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
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.JSpinner;

public class GUI_Selection {

	private JFrame frame;
	private JTextField dest;
	private JTextField departure;
	String input_depart;
	private JPanel panel_1;
	private JButton btnNewButton_2;

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
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setLayout(null);

		String [] loc = {"서울","부산","대구","인천","광주","대전","울산"};

		
		JButton btnNewButton_2 = new JButton("\uB2E4\uC74C\uC73C\uB85C(\uC608\uB9E4\uD558\uAE30)");
		btnNewButton_2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			private JComboBox comboBox;

			@Override
			public void mouseClicked(MouseEvent e) {
				input_depart = loc[comboBox.getSelectedIndex()];
				//input_depart = depart.getText();
				String input_dest = dest.getText();
				GUI_Booking bo = new GUI_Booking(loginUser,input_depart,input_dest);
			}
		});
		
		btnNewButton_2.setBounds(797, 458, 145, 33);
		frame.getContentPane().add(btnNewButton_2);
		
	
		
		JButton btnLoc1 = new JButton("\uC11C\uC6B8");
		btnLoc1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnLoc1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String str = "서울";
				GUI_Image img = new GUI_Image(str);
				dest.setText(str);
				
			}
		});
		btnLoc1.setBounds(561, 129, 97, 23);
		frame.getContentPane().add(btnLoc1);
		
		JButton btnLoc2 = new JButton("\uB300\uC804");
		btnLoc2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnLoc2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "대전";
				GUI_Image img = new GUI_Image(str);
				dest.setText(str);
			}
		});
		btnLoc2.setBounds(718, 129, 97, 23);
		frame.getContentPane().add(btnLoc2);
		
		JButton btnLoc3 = new JButton("\uC6B8\uC0B0");
		btnLoc3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnLoc3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "울산";
				GUI_Image img = new GUI_Image(str);
				dest.setText(str);
			}
		});
		btnLoc3.setBounds(561, 277, 97, 23);
		frame.getContentPane().add(btnLoc3);
		
		JButton btnLoc4 = new JButton("\uB300\uAD6C");
		btnLoc4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnLoc4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "대구";
				GUI_Image img = new GUI_Image(str);
				dest.setText(str);
			}
		});
		btnLoc4.setBounds(718, 277, 97, 23);
		frame.getContentPane().add(btnLoc4);
		
		JButton btnLoc5 = new JButton("\uAD11\uC8FC");
		btnLoc5.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnLoc5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "광주";
				GUI_Image img = new GUI_Image(str);
				dest.setText(str);
			}
		});
		btnLoc5.setBounds(561, 425, 97, 23);
		frame.getContentPane().add(btnLoc5);
		
		JButton btnLoc6 = new JButton("\uBD80\uC0B0");
		btnLoc6.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnLoc6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "부산";
				GUI_Image img = new GUI_Image(str);
				dest.setText(str);
			}
		});
		btnLoc6.setBounds(718, 425, 97, 23);
		frame.getContentPane().add(btnLoc6);
		
		JButton btnNewButton_1 = new JButton("인천");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "인천";
				GUI_Image img = new GUI_Image(str);
				dest.setText(str);
			}
		});
		btnNewButton_1.setBounds(561, 67, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
//		JPanel panel_1 = new JPanel();
		 String imgPath = this.getClass().getResource(".").getPath()+"..//..//img//gaboja.png";
			ImageIcon icon = new ImageIcon(imgPath);
			panel_1 = new JPanel() {
				protected void paintComponent(Graphics g) {
					g.drawImage(icon.getImage(),0,0,panel_1.getWidth(),panel_1.getHeight(), null);
					setOpaque(false);
					super.paintComponent(g);
				}
				};
		
		panel_1.setBounds(0, 0, 954, 511);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.WHITE);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(500, 69, 86, 415);
		panel_1.add(separator_2);
		
		JLabel lblNewLabel = new JLabel("\uC5EC\uD589\uC9C0\uC5ED \uC120\uD0DD");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(79, 69, 372, 90);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
			
			
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
			panel.setBounds(79, 190, 372, 206);
			panel_1.add(panel);
			panel.setBackground(Color.white);
			panel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
			panel.setLayout(new GridLayout(2, 2, 2, 5));
			
			JLabel lblNewLabel_3 = new JLabel("\uCD9C\uBC1C\uC9C0\uC5ED");
			lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			panel.add(lblNewLabel_3);
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			
			JLabel lblNewLabel_2 = new JLabel("\uB3C4\uCC29\uC9C0\uC5ED");
			lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(lblNewLabel_2);
			
			JPanel panel1 = new JPanel();
			panel1.setBackground(UIManager.getColor("Button.disabledShadow"));
			panel.add(panel1);
			panel1.setLayout(null);
			JComboBox comboBox = new JComboBox(loc);
			comboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			comboBox.setBounds(43, 39, 97, 21);
			panel1.add(comboBox);
			comboBox.setSelectedIndex(6);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(0, 0, 184, 99);
			panel1.add(separator);
			
			JSeparator separator_3 = new JSeparator();
			separator_3.setOpaque(true);
			separator_3.setBounds(0, 0, 43, 99);
			panel1.add(separator_3);
			
			dest = new JTextField();
			dest.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			dest.setColumns(10);
			dest.setBounds(27, 37, 130, 24);
			
			JPanel panel2 = new JPanel();
			panel2.setBackground(UIManager.getColor("Button.disabledShadow"));
			panel.add(panel2);
			panel2.setLayout(null);
			panel2.add(dest);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(0, 0, 184, 99);
			panel2.add(separator_1);
			
			JSeparator separator_4 = new JSeparator();
			separator_4.setBounds(0, -86, 102, 236);
			panel2.add(separator_4);
			separator_4.setOrientation(SwingConstants.VERTICAL);
		
		
		frame.setAutoRequestFocus(false);
		frame.setBounds(100, 100, 960,540);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}