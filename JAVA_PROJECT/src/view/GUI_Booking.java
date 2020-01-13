package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GUI_Booking {

	private JFrame frame;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Booking window = new GUI_Booking();
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
	public GUI_Booking() {
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
		panel.setBounds(12, 10, 128, 47);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("\uAC00\uBCF4\uC790");
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		panel.add(lblNewLabel, "name_1458993286850100");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 67, 760, 484);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("\uAC00\uB294\uB0A0");
		label.setBounds(12, 40, 57, 15);
		panel_1.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 64, 219, 27);
		panel_1.add(comboBox);
		
		JLabel label_1 = new JLabel("\uBC84\uC2A4");
		label_1.setBounds(12, 162, 57, 15);
		panel_1.add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 187, 350, 270);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("\uAE30\uCC28");
		lblNewLabel_1.setBounds(398, 162, 57, 15);
		panel_1.add(lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(398, 187, 350, 270);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
	}
}
