package view;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.MemberManagementService;
import model.Member;

public class GUI_MemberInfoModify {

	MemberManagementService service = new MemberManagementService();
	private JFrame frame;
	private JTextField id;
	private JTextField pw;
	private JTextField pwcheck;
	private JTextField birth;
	private JTextField phone;
	private JTextField name;
	private JTextField email;
	Member loginUser = new Member("id", "pw", "name", "birth", "phone", "email");

	/**
	 * Create the application.
	 */
	public GUI_MemberInfoModify(Member loginUser) {
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
		panel_1.setBounds(425, 494, 137, 47);
		panel.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));

		JButton ok = new JButton("\uD655\uC778");
		ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String infoId = id.getText();
				String infoPw = pw.getText();
				String infoPw1 = pwcheck.getText();
				String infoName = name.getText();
				String infoBirth = birth.getText();
				String infoPhone = phone.getText();
				String infoEmail = email.getText();

				if (infoPw.equals(infoPw1)) {
					Member m = new Member(infoId, infoPw, infoName, infoBirth, infoPhone, infoEmail);

					boolean result = service.memberInfoModify(loginUser);
					if (result) {
						JOptionPane.showMessageDialog(frame, "성공");
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(frame, "실패");
					}
				} else {
					JOptionPane.showMessageDialog(frame, "��й�ȣ �ٽ� Ȯ��");
				}
			}

		});

		panel_1.add(ok, "name_1266465774629600");

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(214, 494, 137, 47);
		panel.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));

		JButton cancel = new JButton("\uCDE8\uC18C");
		panel_2.add(cancel, "name_1266578742455400");

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(96, 89, 568, 395);
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(7, 2, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_1);

		id = new JTextField(loginUser.getId());
		panel_3.add(id);
		id.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_2);

		pw = new JTextField(loginUser.getPw());
		panel_3.add(pw);
		pw.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_3);

		pwcheck = new JTextField(loginUser.getPw());
		panel_3.add(pwcheck);
		pwcheck.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("\uC774\uB984");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_4);

		name = new JTextField(loginUser.getName());
		panel_3.add(name);
		name.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_5);

		birth = new JTextField(loginUser.getBirth());
		panel_3.add(birth);
		birth.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_6);

		phone = new JTextField(loginUser.getPhone());
		panel_3.add(phone);
		phone.setColumns(10);

		JLabel lblNewLabel = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel);

		email = new JTextField(loginUser.getEmail());
		panel_3.add(email);
		email.setColumns(10);
	}
}
