package view;

import java.awt.CardLayout;
import java.awt.Font;
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

public class GUI_Join {

	MemberManagementService service = new MemberManagementService();
	private JFrame frame;
	private JTextField email;
	private JTextField id;
	private JTextField pw;
	private JTextField pw1;
	private JTextField name;
	private JTextField birth;
	private JTextField phone;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public GUI_Join() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 760, 93);
		panel.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));

		JLabel lblNewLabel = new JLabel("\uAC00\uBCF4\uC790");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 31));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel, "name_1457830998951300");

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(108, 113, 568, 395);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(7, 2, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
		panel_2.add(lblNewLabel_1);

		id = new JTextField();
		panel_2.add(id);
		id.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		panel_2.add(lblNewLabel_2);

		pw = new JTextField();
		panel_2.add(pw);
		pw.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\uBE44\uBC00\uBC88\uD638\uD655\uC778");
		panel_2.add(lblNewLabel_3);

		pw1 = new JTextField();
		panel_2.add(pw1);
		pw1.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("\uC774\uB984");
		panel_2.add(lblNewLabel_4);

		name = new JTextField();
		panel_2.add(name);
		name.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("\uC0DD\uB144\uC6D4\uC77C(YYMMDD)");
		panel_2.add(lblNewLabel_5);

		birth = new JTextField();
		panel_2.add(birth);
		birth.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("\uC5F0\uB77D\uCC98");
		panel_2.add(lblNewLabel_6);

		phone = new JTextField();
		panel_2.add(phone);
		phone.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("\uC774\uBA54\uC77C");
		panel_2.add(lblNewLabel_7);

		email = new JTextField();
		panel_2.add(email);
		email.setColumns(10);

		JButton btnNewButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String infoId = id.getText();
				String infoPw = pw.getText();
				String infoPw1 = pw1.getText();
				String infoName = name.getText();
				String infoBirth = birth.getText();
				String infoPhone = phone.getText();
				String infoEmail = email.getText();

				if (infoPw.equals(infoPw1)) {
					Member m = new Member(infoId, infoPw, infoName, infoBirth, infoPhone, infoEmail);

					boolean result = service.memberJoin(m);
					if (result) {
						JOptionPane.showMessageDialog(frame, "회원가입 성공");
						frame.dispose(); // 화면 종료
					} else {
						JOptionPane.showMessageDialog(frame, "회원가입 실패");
					}
				} else {
					JOptionPane.showMessageDialog(frame, "비밀번호를 다시 확인하세요.");
				}
			}
		});
		btnNewButton.setBounds(334, 518, 115, 33);
		panel.add(btnNewButton);
	}
}
