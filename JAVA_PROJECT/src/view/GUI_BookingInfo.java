package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Choice;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_BookingInfo {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_BookingInfo window = new GUI_BookingInfo();
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
	public GUI_BookingInfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 223, 40);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel name = new JLabel("ooo");
		name.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		name.setBounds(12, 10, 48, 15);
		panel.add(name);
		
		JLabel label = new JLabel("\uB2D8\uC758 \uC608\uB9E4\uC815\uBCF4");
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		label.setBounds(47, 10, 150, 15);
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(12, 10, 223, 51);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 60, 760, 18);
		frame.getContentPane().add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 78, 760, 95);
		frame.getContentPane().add(scrollPane);
		
		
		String[][]data = {{"01","lims3929","광주","서울","ktx","2020-02-01"},{"02","kk","여수","순천","무궁화","2020-01-19"}};
		String[] columnNames = { "예매번호", "아이디", "출발지","목적지","교통편","예매날짜" };
		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(414, 397, 343, 154);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton edit = new JButton("\uC608\uB9E4 \uC218\uC815");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		edit.setBounds(39, 43, 119, 47);
		panel_1.add(edit);
		
		JButton btnNewButton_1 = new JButton("\uC608\uB9E4\uCDE8\uC18C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(185, 43, 119, 47);
		panel_1.add(btnNewButton_1);
	}
}
