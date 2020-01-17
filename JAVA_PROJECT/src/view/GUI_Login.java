
package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JPasswordField;


public class GUI_Login {

	private MemberManagementService service = new MemberManagementService();
	private JFrame frame;
	private JTextField id;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Login window = new GUI_Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setFont(new Font("占쏙옙占쏙옙 占쏙옙占�", Font.PLAIN, 12));
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// 占싱뱄옙占쏙옙 占쏙옙占쏙옙

		String imgPath = this.getClass().getResource(".").getPath() + "..//..//img//main.png";

		ImageIcon icon = new ImageIcon(imgPath);
		JPanel panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, 900, 600, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel.setBounds(0, 0, 884, 561);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		id = new JTextField();
		id.setBounds(325, 404, 240, 35);
		id.setBorder(null);
		panel.add(id);
		id.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(325, 449, 240, 35);
		passwordField.setBorder(null);
		panel.add(passwordField);

		JLabel lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(238, 453, 85, 27);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("占쏙옙占쏙옙 占쏙옙占�", Font.PLAIN, 15));

		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(238, 404, 75, 35);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("占쏙옙占쏙옙 占쏙옙占�", Font.PLAIN, 15));

		JButton login = new JButton("\uB85C\uADF8\uC778");
		login.setBackground(new Color(255, 255, 255));
		login.setBounds(325, 508, 97, 28);
		login.setBorderPainted(false);
		panel.add(login);

		JButton btnNewButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(468, 508, 97, 28);
		btnNewButton.setBorderPainted(false);
		panel.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GUI_Join join = new GUI_Join();
			}
		});
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String infoId = id.getText();
				String infoPw = passwordField.getText();

				Member m = new Member(infoId, infoPw);

				Member loginUser = service.memberLogin(m);
				if (loginUser == null) {
					JOptionPane.showMessageDialog(frame, "login fail");
					
				} else {
					JOptionPane.showMessageDialog(frame, "login success");
					GUI_MainMenu main = new GUI_MainMenu(loginUser);
					frame.dispose();
				}
			}
		});
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}
}

