
package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Member;

import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;

public class GUI_MemberMenu {

	private JFrame frame;
	private JPanel panel;

	/**
	 * Create the application.
	 */
	public GUI_MemberMenu(Member loginUser) {
		initialize(loginUser);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Member loginUser) {
		frame = new JFrame();
		frame.setBounds(100, 100, 960,540);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		String imgPath = this.getClass().getResource(".").getPath()+"..//..//img//gaboja.png";
	      
		ImageIcon icon = new ImageIcon(imgPath);
		panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),0,0,panel.getWidth(),panel.getHeight(), null);
				setOpaque(false);
				super.paintComponent(g);
			}
			};
		
		
		
		
		panel.setBounds(0, 0, 944,501);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(582, 446, 147, 45);
		panel.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));

		JButton btnNewButton = new JButton("\uD68C\uC6D0 \uC815\uBCF4 \uC218\uC815");
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnNewButton.setBackground(Color.white);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GUI_MemberInfoModify modify = new GUI_MemberInfoModify(loginUser);
			}
		});
		panel_1.add(btnNewButton, "name_1270908918196400");

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(753, 446, 147, 45);
		panel.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));

		JButton btnNewButton_1 = new JButton("\uD68C\uC6D0 \uD0C8\uD1F4");
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnNewButton_1.setBackground(Color.white);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUI_MemberOut out = new GUI_MemberOut(loginUser);
			}
		});
		panel_2.add(btnNewButton_1, "name_1270942590180700");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255,0,0,0));
		panel_3.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		panel_3.setBounds(142, 60, 659, 373);
		panel.add(panel_3);
		panel_3.setLayout(null);
	
		
		
		JLabel label_2 = new JLabel("이름");
		label_2.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		label_2.setBounds(162, 59, 79, 24);
		panel_3.add(label_2);
		
		JLabel lblNewLabel = new JLabel("생년월일");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel.setBounds(162, 138, 98, 24);
		panel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("전화번호");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_1.setBounds(162, 217, 98, 24);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblEmail = new JLabel("E-MAIL");
		lblEmail.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblEmail.setBounds(162, 296, 98, 29);
		panel_3.add(lblEmail);
		
		JLabel lblName = new JLabel(loginUser.getName());
		lblName.setOpaque(true);
		lblName.setBackground(Color.WHITE);
		lblName.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblName.setBounds(298, 59, 207, 24);
		panel_3.add(lblName);
		
		JLabel lblBirth = new JLabel(loginUser.getBirth());
		lblBirth.setOpaque(true);
		lblBirth.setBackground(Color.WHITE);
		lblBirth.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblBirth.setBounds(298, 138, 207, 24);
		panel_3.add(lblBirth);
		
		JLabel lblTel = new JLabel(loginUser.getPhone());
		lblTel.setOpaque(true);
		lblTel.setBackground(Color.WHITE);
		lblTel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblTel.setBounds(298, 217, 207, 24);
		panel_3.add(lblTel);
		
		JLabel lblMail = new JLabel(loginUser.getEmail());
		lblMail.setOpaque(true);
		lblMail.setBackground(Color.WHITE);
		lblMail.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblMail.setBounds(298, 298, 207, 24);
		panel_3.add(lblMail);
		
		JLabel label = new JLabel(loginUser.getName());
		label.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label.setForeground(Color.WHITE);
		label.setBounds(798, 10, 50, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("님의 회원정보");
		label_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(850, 10, 83, 15);
		panel.add(label_1);
		
		JButton btnNewButton_2 = new JButton("");
	      btnNewButton_2.setFocusPainted(false);
	      btnNewButton_2.setContentAreaFilled(false);
	      btnNewButton_2.setBorderPainted(false);
		
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUI_MainMenu main = new GUI_MainMenu(loginUser);
				frame.dispose();
				
			}
		});
		btnNewButton_2.setBounds(59, 7, 116, 43);
		panel.add(btnNewButton_2);
	}
}


