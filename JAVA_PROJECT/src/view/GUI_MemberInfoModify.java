
package view;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.MemberManagementService;
import model.Member;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;

public class GUI_MemberInfoModify {

	MemberManagementService service = new MemberManagementService();
	private JFrame frame;
	private JTextField pw;
	private JTextField pwcheck;
	private JTextField birth;
	private JTextField phone;
	private JTextField name;
	private JTextField email;
	Member loginUser = new Member("id", "pw", "name", "birth", "phone", "email");
	private JPanel panel_4;

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
		frame.setBounds(100, 100, 960,540);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		   String imgPath = this.getClass().getResource(".").getPath()+"..//..//img//gaboja.png";
		      
			ImageIcon icon = new ImageIcon(imgPath);
			panel_4 = new JPanel() {
				protected void paintComponent(Graphics g) {
					g.drawImage(icon.getImage(),0,0,panel_4.getWidth(),panel_4.getHeight(), null);
					setOpaque(false);
					super.paintComponent(g);
				}
				};
			panel_4.setOpaque(false);
			
		
		
		panel_4.setBounds(0, 0, 944,501);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(304, 440, 137, 47);
		panel_4.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));

		JButton ok = new JButton("\uD655\uC778");
		ok.setBackground(Color.WHITE);
		ok.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		ok.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String infoId = loginUser.getId();
				String infoPw = pw.getText();
				String infoPw1 = pwcheck.getText();
				String infoName = name.getText();
				String infoBirth = birth.getText();
				String infoPhone = phone.getText();
				String infoEmail = email.getText();

				if (infoPw.equals(infoPw1)) {
					Member m = new Member(infoId, infoPw, infoName, infoBirth, infoPhone, infoEmail);
					
					boolean result = service.memberInfoModify(m);
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
		panel_2.setBounds(507, 440, 137, 47);
		panel_4.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));

		JButton cancel = new JButton("\uCDE8\uC18C");
		cancel.setBackground(Color.WHITE);
		cancel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		cancel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GUI_MemberMenu info = new GUI_MemberMenu(loginUser);
			}
		});
		panel_2.add(cancel, "name_1266578742455400");

		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		panel_3.setBounds(188, 86, 568, 344);
		panel_4.add(panel_3);
		panel_3.setLayout(new GridLayout(7, 2, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_7 = new JLabel(loginUser.getId());
		panel_3.add(lblNewLabel_7);

		JLabel lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_2);

		pw = new JTextField(loginUser.getPw());
		pw.setBorder(new LineBorder(new Color(171, 173, 179)));
		pw.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		panel_3.add(pw);
		pw.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_3);

		pwcheck = new JTextField(loginUser.getPw());
		pwcheck.setBorder(new LineBorder(new Color(171, 173, 179)));
		pwcheck.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		panel_3.add(pwcheck);
		pwcheck.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("\uC774\uB984");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_4);

		name = new JTextField(loginUser.getName());
		name.setBorder(new LineBorder(new Color(171, 173, 179)));
		name.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		panel_3.add(name);
		name.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_5);

		birth = new JTextField(loginUser.getBirth());
		birth.setBorder(new LineBorder(new Color(171, 173, 179)));
		birth.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		panel_3.add(birth);
		birth.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_6);

		phone = new JTextField(loginUser.getPhone());
		phone.setBorder(new LineBorder(new Color(171, 173, 179)));
		phone.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		panel_3.add(phone);
		phone.setColumns(10);

		JLabel lblNewLabel = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel);

		email = new JTextField(loginUser.getEmail());
		email.setBorder(new LineBorder(new Color(171, 173, 179)));
		email.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		panel_3.add(email);
		email.setColumns(10);
		
		JButton btnNewButton = new JButton("");
	
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUI_MainMenu main = new GUI_MainMenu(loginUser);
				frame.dispose();
			}
		});
	      btnNewButton.setFocusPainted(false);
	      btnNewButton.setContentAreaFilled(false);
	      btnNewButton.setBorderPainted(false);
	
		btnNewButton.setOpaque(false);
		btnNewButton.setBounds(48, 10, 104, 39);
		panel_4.add(btnNewButton);
	}
}