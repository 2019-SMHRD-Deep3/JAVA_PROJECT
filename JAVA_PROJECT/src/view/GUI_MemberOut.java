package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import controller.MemberManagementService;
import model.Member;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class GUI_MemberOut {
	MemberManagementService service = new MemberManagementService();
	private JFrame frame;

	/**
	 * Create the application.
	 */
	public GUI_MemberOut(Member loginUser) {
		initialize(loginUser);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Member loginUser) {
		frame = new JFrame();
		frame.setBounds(100, 100, 342, 193);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 326, 154);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(77, 101, 64, 26);
		panel.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JButton btnNewButton = new JButton("ok");
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean result = service.memberOut(loginUser);
				if (result) {
					JOptionPane.showMessageDialog(frame, "회원탈퇴 성공");
					frame.dispose(); // ȭ�� ����
				} else {
					JOptionPane.showMessageDialog(frame, "회원탈퇴 실패");
				}
					
			}
		});
		panel_1.add(btnNewButton, "name_1290227644548800");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(191, 101, 64, 26);
		panel.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));
		
		JButton btnNewButton_1 = new JButton("no");
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GUI_MemberInfo info = new GUI_MemberInfo(null);
			}
		});
		panel_2.add(btnNewButton_1, "name_1290239572578400");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(47, 40, 233, 26);
		panel.add(panel_3);
		panel_3.setLayout(new CardLayout(0, 0));
		
		JLabel label = new JLabel("회원탈퇴시 예매정보가 전부 삭제됩니다");
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(label, "name_1290283716512000");
		
		JLabel lblNewLabel = new JLabel("정말 탈퇴하시겠습니까?");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(94, 76, 149, 15);
		panel.add(lblNewLabel);
	}
}
