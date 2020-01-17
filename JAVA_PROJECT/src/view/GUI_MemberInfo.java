
package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Member;

import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class GUI_MemberInfo {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public GUI_MemberInfo(Member loginUser) {
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

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 960,501);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(582, 446, 147, 45);
		panel.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));

		JButton btnNewButton = new JButton("\uD68C\uC6D0 \uC815\uBCF4 \uC218\uC815");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GUI_MemberInfoModify modify = new GUI_MemberInfoModify(loginUser);
			}
		});
		panel_1.add(btnNewButton, "name_1270908918196400");

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(753, 446, 147, 45);
		panel.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));

		JButton btnNewButton_1 = new JButton("\uD68C\uC6D0 \uD0C8\uD1F4");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUI_MemberOut out = new GUI_MemberOut(loginUser);
			}
		});
		panel_2.add(btnNewButton_1, "name_1270942590180700");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.WHITE, 2, true));
		panel_3.setBounds(59, 60, 841, 373);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_2 = new JLabel("이름");
		label_2.setFont(new Font("돋움", Font.BOLD, 16));
		label_2.setBounds(185, 58, 79, 24);
		panel_3.add(label_2);
		
		JLabel lblNewLabel = new JLabel("생년월일");
		lblNewLabel.setFont(new Font("돋움", Font.BOLD, 16));
		lblNewLabel.setBounds(185, 137, 98, 24);
		panel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("전화번호");
		lblNewLabel_1.setFont(new Font("돋움", Font.BOLD, 16));
		lblNewLabel_1.setBounds(185, 216, 98, 24);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblEmail = new JLabel("E-MAIL");
		lblEmail.setFont(new Font("돋움", Font.BOLD, 16));
		lblEmail.setBounds(185, 295, 98, 29);
		panel_3.add(lblEmail);
		
		JLabel lblName = new JLabel(loginUser.getName());
		lblName.setFont(new Font("돋움", Font.BOLD, 16));
		lblName.setBounds(321, 58, 207, 24);
		panel_3.add(lblName);
		
		JLabel lblBirth = new JLabel(loginUser.getBirth());
		lblBirth.setFont(new Font("돋움", Font.BOLD, 16));
		lblBirth.setBounds(321, 137, 411, 24);
		panel_3.add(lblBirth);
		
		JLabel lblTel = new JLabel(loginUser.getPhone());
		lblTel.setFont(new Font("돋움", Font.BOLD, 16));
		lblTel.setBounds(321, 216, 363, 24);
		panel_3.add(lblTel);
		
		JLabel lblMail = new JLabel(loginUser.getEmail());
		lblMail.setFont(new Font("돋움", Font.BOLD, 16));
		lblMail.setBounds(321, 297, 377, 24);
		panel_3.add(lblMail);
		
		JLabel label = new JLabel(loginUser.getName());
		label.setForeground(Color.WHITE);
		label.setBounds(798, 10, 50, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("님의 회원정보");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(850, 10, 83, 15);
		panel.add(label_1);
	}
}


