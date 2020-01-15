package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Member;

import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(433, 125, 248, 70);
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
		panel_2.setBounds(433, 285, 248, 70);
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
	}

}
