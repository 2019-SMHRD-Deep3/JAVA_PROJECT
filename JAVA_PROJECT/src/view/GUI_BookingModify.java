
package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import model.Member;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import javafx.scene.control.ComboBox;

import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JScrollBar;

public class GUI_BookingModify {

	private JFrame frame;
	private JTable table;
	private JComboBox comboBox;
	private JScrollPane show_info;
	private JScrollPane show_modifyInfo;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public GUI_BookingModify(Member loginuser) {
		initialize(loginuser);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Member loginuser) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 800,600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 59, 760, 18);
		frame.getContentPane().add(separator);
		
		show_modifyInfo = new JScrollPane();
		show_modifyInfo.setBounds(30, 325, 742, 92);
		frame.getContentPane().add(show_modifyInfo);
		
		table = new JTable((TableModel) null);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		show_modifyInfo.setViewportView(table);

		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(30, 10, 190, 39);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("예매 변경");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 0, 166, 39);
		panel.add(lblNewLabel);
		
		JButton button = new JButton("예매 변경하기");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frame,
					    "예매 변경 성공");			
			}
		});
	
		button.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		button.setBounds(581, 468, 119, 47);
		frame.getContentPane().add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(30, 87, 742, 201);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		//콤보박스에 넣기
		JComboBox comboBox = new JComboBox();
        comboBox.setEditable(true);
        comboBox.addItem("1시");
        
        comboBox.setSelectedItem("");
		
		comboBox.setBounds(12, 32, 279, 29);
		panel_1.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("원하는 시간대를 선택하세요.");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(12, 7, 279, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel label = new JLabel("원하는 정보를 선택하세요");
		label.setBounds(12, 91, 279, 15);
		panel_1.add(label);
		
		JButton btnNewButton_1 = new JButton("조회");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				show_info.setToolTipText(comboBox.getSelectedItem().toString());
			}
		});
		
		btnNewButton_1.setBounds(315, 35, 101, 23);
		panel_1.add(btnNewButton_1);
		
		show_info = new JScrollPane();
		show_info.setBounds(12, 116, 708, 75);
		panel_1.add(show_info);
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("변경된 예매 정보");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(42, 298, 143, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(443, 481, 97, 23);
		frame.getContentPane().add(btnNewButton);
	}
}