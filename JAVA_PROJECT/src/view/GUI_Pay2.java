package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.MemberManagementService;
import model.Member;
import model.TransInfo;

public class GUI_Pay2 {

	MemberManagementService service = new MemberManagementService();
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */

	public GUI_Pay2(Member loginUser, TransInfo selTransInfo, String input_depart, String input_dest, int booknom) {
		initialize(loginUser, selTransInfo,input_depart,input_dest,booknom);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Member loginUser, TransInfo selTransInfo,String input_depart,String input_dest,int booknom) {
		frame = new JFrame();
		frame.setBounds(100, 100, 465, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("카드 선택");
		lblNewLabel.setBounds(55, 85, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		String[] bank = {"국민","비씨","신한","현대","삼성","롯데","외환","NH","하나","우리","광주","수협","씨티","전북","제주","카카오뱅크","케이뱅크"};
		JComboBox comboBox = new JComboBox(bank);
		comboBox.setBounds(141, 82, 130, 21);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("카드 번호");
		lblNewLabel_1.setBounds(55, 150, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(141, 147, 57, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("위 상품의 구매조건 확인 및 결제진행 동의");
		chckbxNewCheckBox.setBounds(55, 289, 292, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("결제하기");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				service.bookingPayment(loginUser, selTransInfo,input_depart,input_dest,booknom);
				JOptionPane.showMessageDialog(frame,
					    "결제가 완료되었습니다.",
					    "A plain message",
					    JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnNewButton.setBounds(176, 369, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label_1 = new JLabel("-");
		label_1.setBounds(202, 150, 16, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(55, 207, 57, 15);
		frame.getContentPane().add(label_4);
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setBounds(55, 218, 57, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(141, 215, 122, 21);
		frame.getContentPane().add(passwordField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(214, 147, 57, 21);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(290, 147, 57, 21);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(371, 147, 57, 21);
		frame.getContentPane().add(textField_3);
		
		JLabel label = new JLabel("-");
		label.setBounds(275, 150, 16, 15);
		frame.getContentPane().add(label);
		
		JLabel label_2 = new JLabel("-");
		label_2.setBounds(355, 150, 16, 15);
		frame.getContentPane().add(label_2);
	}
}
