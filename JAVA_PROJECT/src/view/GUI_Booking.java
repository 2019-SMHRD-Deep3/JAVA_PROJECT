

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
import javax.swing.JOptionPane;
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
	private JTextField depart_date_textf;
	MemberManagementService service = new MemberManagementService();
	ArrayList<TransInfo> transInfoList = null;
	private JTable table;
	private JScrollPane scrollPane;
	String f_sel_depart_time;
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
		lblEx.setBounds(422, 24, 260, 15);
		panel_1.add(lblEx);
		
		JButton btnNewButton = new JButton("결제하기");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				TransInfo selTransInfo = transInfoList.get(row);
				System.out.println(selTransInfo.getServ_num());
				GUI_Pay pay = new GUI_Pay(loginuser,selTransInfo,input_depart,input_dest);
			}
		});
	
		btnNewButton.setBounds(604, 427, 97, 23);
		panel_1.add(btnNewButton);
		
	
		depart_date_textf = new JTextField();
		depart_date_textf.setBounds(422, 49, 116, 21);
		panel_1.add(depart_date_textf);
		depart_date_textf.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("조회");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//transInfoList = service.transSelect(depart_date_textf.getText(),input_depart,input_dest);
				transInfoList = service.transSelect(f_sel_depart_time,input_depart,input_dest);
				if(transInfoList.size()==0) {
					JOptionPane.showMessageDialog(frame, "조건에 맞는 운행이 없습니다.");
				}
				System.out.println("조건에 맞는 운행수:"+transInfoList.size());
				show(transInfoList);
			}
		});
		btnNewButton_1.setBounds(562, 48, 97, 23);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel(input_depart);
		lblNewLabel_2.setBounds(34, 49, 57, 15);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(input_dest);
		lblNewLabel_3.setBounds(195, 52, 57, 15);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("->");
		lblNewLabel_4.setBounds(142, 49, 57, 15);
		panel_1.add(lblNewLabel_4);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 154, 660, 263);
		panel_1.add(scrollPane);
//		
//		String [] loc = {"서울","부산","대구","인천","광주","대전","울산"};
//		JComboBox comboBox = new JComboBox(loc);
		String [] depart_date = new String[31];
		for (int i = 0; i < depart_date.length; i++) {
			if(i<10) {
				depart_date[i] = "2020/01/0"+ (i+1);
			}else {
				depart_date[i] = "2020/01/"+(i+1);
			}
		}
		String[] depart_time = new String[49];
		int min = 0;
		String m2 = "00";
		int h;
		int m;
		for (int i = 0; i < depart_time.length; i++) {

			h = min / 60;
			m = min % 60;

			if (30 <= m) {
				m2 = "30";
			} else {
				m2 = "00";
			}

			if (h < 10) {
				depart_time[i] = "0" + h + ":" + m2 + ":00";
			} else {
				depart_time[i] = h + ":" + m2 + ":00";
			}
			min += 30;
		}
		JComboBox depart_date_cb = new JComboBox(depart_date);
		depart_date_cb.setBounds(422, 99, 116, 21);
		panel_1.add(depart_date_cb);
		String sel_depart_date = depart_date[depart_date_cb.getSelectedIndex()];
		
		JComboBox depart_time_cb = new JComboBox(depart_time);
		depart_time_cb.setBounds(562, 99, 97, 21);
		panel_1.add(depart_time_cb);
		String sel_depart_time = depart_date[depart_date_cb.getSelectedIndex()];
		f_sel_depart_time = sel_depart_date+sel_depart_date;

		
		
		
	}

	protected void show(ArrayList<TransInfo> transInfoList2) {
		String[] columnNames = {"운행번호","운행종류","차량번호","출발시각","도착시각","등급","좌석","요금"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		for (int i = 0; i < transInfoList.size(); i++) {
			int serv_num = transInfoList.get(i).getServ_num();
			String type = transInfoList.get(i).getType();
			String num = transInfoList.get(i).getNum();
			String dep_time = transInfoList.get(i).getDep_time();
			String arr_time = transInfoList.get(i).getArr_time();
			String grade = transInfoList.get(i).getGrade();
			int seat = transInfoList.get(i).getSeat();
			String fare = transInfoList.get(i).getFare();
			Object [] data = {serv_num,type,num,dep_time,arr_time,grade,seat,fare};
			tableModel.addRow(data);
		}
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		// TODO Auto-generated method stub
		
	}
}