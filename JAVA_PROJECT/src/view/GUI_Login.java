package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class GUI_Login {

	private MemberManagementService service = new MemberManagementService();
	private JFrame frame;
	private JTextField id;
	private JTextField pw;

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
		frame.getContentPane().setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(175, 0, 434, 99);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));

		JLabel label = new JLabel("\uAC00\uBCF4\uC790");
		label.setFont(new Font("¹®Ã¼ºÎ ¾²±â Èê¸²Ã¼", Font.BOLD, 40));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label, "name_1448421216090600");

		id = new JTextField();
		id.setBounds(297, 214, 312, 61);
		frame.getContentPane().add(id);
		id.setColumns(10);

		pw = new JTextField();
		pw.setBounds(297, 339, 312, 61);
		pw.setColumns(10);
		frame.getContentPane().add(pw);

		JButton login = new JButton("\uB85C\uADF8\uC778");
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String infoId = id.getText();
				String infoPw = pw.getText();

				Member m = new Member(infoId, infoPw);

				Member loginUser = service.memberLogin(m);
				if (loginUser == null) {
					JOptionPane.showMessageDialog(frame, "·Î±×ÀÎ ½ÇÆÐ");
					frame.dispose(); 
				} else {
					JOptionPane.showMessageDialog(frame, "·Î±×ÀÎ ¼º°ø");
					GUI_MainMenu main = new GUI_MainMenu();
					frame.dispose();
				}
			}
		});
		login.setBounds(335, 466, 97, 28);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frame.getContentPane().add(login);

		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setBounds(175, 217, 95, 46);
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1.setBounds(175, 352, 165, 27);
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GUI_Join join = new GUI_Join();
			}
		});
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				GUI_Join join = new GUI_Join();
//			}
//		});
		btnNewButton.setBounds(472, 466, 97, 28);
		frame.getContentPane().add(btnNewButton);
	}
}
