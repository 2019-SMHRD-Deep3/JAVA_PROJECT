
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

import model.Member;
import model.TransInfo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.MemberManagementService;
import java.awt.SystemColor;
import java.awt.Window;

public class GUI_Booking {

	private JFrame frame;
	private JTextField depart_date;
	MemberManagementService service = new MemberManagementService();
	ArrayList<TransInfo> transInfoList = null;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * @param input_dest 
	 * @param input_depart 
	 */
	public GUI_Booking(Member loginuser, String input_depart, String input_dest) {
		
		initialize(loginuser,input_depart,input_dest);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Member loginuser, String input_depart, String input_dest) {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 128, 47);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("\uAC00\uBCF4\uC790");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));
		panel.add(lblNewLabel, "name_1458993286850100");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 67, 737, 464);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEx = new JLabel("출발날짜를 입력해주세요 ex)2010/04/17");
		lblEx.setBounds(22, 41, 260, 15);
		panel_1.add(lblEx);
		
		JButton btnNewButton = new JButton("결제하기");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TransInfo transinfo=new TransInfo("Ts1","Trans2","t1","2020/01/01","2020/01/01","ITX",10,"1000");
				GUI_Pay pay = new GUI_Pay(loginuser,transinfo,input_depart, input_dest);
			}
		});
	
		btnNewButton.setBounds(508, 64, 97, 23);
		panel_1.add(btnNewButton);
		
	
		depart_date = new JTextField();
		depart_date.setBounds(22, 65, 116, 21);
		panel_1.add(depart_date);
		depart_date.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("조회");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				transInfoList = service.transSelect(depart_date.getText(),input_depart,input_dest);
			}
		});
		btnNewButton_1.setBounds(150, 64, 97, 23);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel(input_depart);
		lblNewLabel_2.setBounds(281, 41, 57, 15);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(input_dest);
		lblNewLabel_3.setBounds(383, 41, 57, 15);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("->");
		lblNewLabel_4.setBounds(350, 41, 57, 15);
		panel_1.add(lblNewLabel_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(22, 171, 712, 259);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("운행 정보");
		lblNewLabel_1.setBounds(12, 10, 57, 15);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(22, 35, 678, 214);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		String[] columnNames = {"운행번호","운행종류","차량번호","출발시각","도착시각","등급","좌석","요금"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		for (int i = 0; i < transInfoList.size(); i++) {
			String serv_num = transInfoList.get(i).getServ_num();
			String type = transInfoList.get(i).getType();
			String num = transInfoList.get(i).getNum();
			String dep_time = transInfoList.get(i).getDep_time();
			String arr_time = transInfoList.get(i).getArr_time();
			String grade = transInfoList.get(i).getArr_time();
			int seat = transInfoList.get(i).getSeat();
			String fare = transInfoList.get(i).getFare();
			Object [] data = {serv_num,type,num,dep_time,arr_time,grade,seat,fare};
			tableModel.addRow(data);
		}
		JTable table = new JTable(tableModel);
		JScrollPane scrollpane = new JScrollPane(table);
		panel_3.add(table);
	}
}