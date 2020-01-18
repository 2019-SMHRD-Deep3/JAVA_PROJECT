

package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Member;
import model.TransInfo;

import javax.swing.ImageIcon;
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
import java.awt.Color;

public class GUI_Booking {

	private JFrame frame;
	MemberManagementService service = new MemberManagementService();
	ArrayList<TransInfo> transInfoList = null;
	private JTable table;
	private JScrollPane scrollPane;
	String f_sel_depart_time;
	String sel_depart_date;
	String sel_depart_time;
	private JComboBox depart_date_cb;
	private JComboBox depart_time_cb;
	private JPanel panel;
	int row;
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
		frame.setBounds(100, 100, 960, 540);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JPanel panel_1 = new JPanel() {};
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(22, 67, 899, 420);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEx = new JLabel("출발날짜 선택");
		lblEx.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblEx.setBounds(502, 49, 150, 15);
		panel_1.add(lblEx);
		
		
		
		JButton btnNewButton = new JButton("다음으로");
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(row==0) {
					JOptionPane.showMessageDialog(frame, "운행정보를 선택해주세요.");
				}
				row = table.getSelectedRow();
				TransInfo selTransInfo = transInfoList.get(row);
				System.out.println(selTransInfo.getServ_num());
				GUI_Pay pay = new GUI_Pay(loginuser,selTransInfo,input_depart,input_dest);
				frame.dispose();
			}
		});
	
		btnNewButton.setBounds(774, 374, 97, 29);
		panel_1.add(btnNewButton);
		
		String [] depart_date_array = new String[31];
		for (int i = 0; i < depart_date_array.length; i++) {
			if(i<9) {
				depart_date_array[i] = "2020/01/0"+ (i+1);
			}else {
				depart_date_array[i] = "2020/01/"+(i+1);
			}
		}
		String[] depart_time_array = new String[49];
		int min = 0;
		String m2 = "00";
		int h;
		int m;
		for (int i = 0; i < depart_time_array.length; i++) {

			h = min / 60;
			m = min % 60;

			if (30 <= m) {
				m2 = "30";
			} else {
				m2 = "00";
			}

			if (h < 10) {
				depart_time_array[i] = "0" + h + ":" + m2;
			} else {
				depart_time_array[i] = h + ":" + m2;
			}
			min += 30;
		}
		
		depart_date_cb = new JComboBox(depart_date_array);
		depart_date_cb.setSelectedIndex(19);
		depart_date_cb.setBounds(502, 86, 116, 21);
		panel_1.add(depart_date_cb);
		
		
		depart_time_cb = new JComboBox(depart_time_array);
		depart_time_cb.setBounds(641, 86, 97, 21);
		panel_1.add(depart_time_cb);
		
		
		
		JButton btnNewButton_1 = new JButton("조회");
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sel_depart_date = depart_date_array[depart_date_cb.getSelectedIndex()];
				sel_depart_time = depart_time_array[depart_time_cb.getSelectedIndex()]+":00";
				f_sel_depart_time = sel_depart_date+" "+sel_depart_time;
				//transInfoList = service.transSelect(depart_date_textf.getText(),input_depart,input_dest);
				System.out.println("선택한 콤보박스 인덱스 "+depart_time_cb.getSelectedIndex());
				System.out.println("선택한 인덱스 값의 배열 값"+depart_time_array[24]);
				System.out.println("선택한 시간"+sel_depart_time);
				System.out.println("출발일"+f_sel_depart_time);
				
				transInfoList = service.transSelect(f_sel_depart_time,input_depart,input_dest);
				if(transInfoList.size()==0) {
					JOptionPane.showMessageDialog(frame, "조건에 맞는 운행이 없습니다.");
				}
				System.out.println("조건에 맞는 운행수:"+transInfoList.size());
				show(transInfoList);
			}
		});
		btnNewButton_1.setBounds(774, 84, 97, 23);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel(input_depart);
		lblNewLabel_2.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 14));
		lblNewLabel_2.setBounds(47, 88, 57, 15);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(input_dest);
		lblNewLabel_3.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 14));
		lblNewLabel_3.setBounds(202, 88, 57, 15);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("→");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_4.setBounds(138, 88, 52, 15);
		panel_1.add(lblNewLabel_4);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 143, 848, 218);
		panel_1.add(scrollPane);
	
		
		JLabel label = new JLabel("출발지");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		label.setBounds(47, 49, 75, 15);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("도착지");
		label_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		label_1.setBounds(202, 49, 57, 15);
		panel_1.add(label_1);
		
		JButton back = new JButton("이전으로");
		back.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		back.setBackground(Color.WHITE);
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUI_Selection selection = new GUI_Selection(loginuser);
				frame.dispose();
			}
		});
		back.setBounds(25, 377, 97, 29);
		panel_1.add(back);
		
////////////background image
		 String imgPath = this.getClass().getResource(".").getPath()+"..//..//img//gaboja.png";
			ImageIcon icon = new ImageIcon(imgPath);
			panel = new JPanel() {
				protected void paintComponent(Graphics g) {
					g.drawImage(icon.getImage(),0,0,panel.getWidth(),panel.getHeight(), null);
					setOpaque(false);
					super.paintComponent(g);
				}
				};
		panel.setBounds(0, 0, 944, 501);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("");
	
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GUI_MainMenu main = new GUI_MainMenu(loginuser);
				frame.dispose();
				

				
			}
		});
		btnNewButton_2.setBounds(12, 10, 158, 41);
		panel.add(btnNewButton_2);
//		
//		String [] loc = {"서울","부산","대구","인천","광주","대전","울산"};
//		JComboBox comboBox = new JComboBox(loc);
	
		

		
		
		
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
		table.getColumn("운행번호").setPreferredWidth(50);
		table.getColumn("운행종류").setPreferredWidth(50);
		table.getColumn("차량번호").setPreferredWidth(50);
		table.getColumn("출발시각").setPreferredWidth(150);
		table.getColumn("도착시각").setPreferredWidth(150);
		table.getColumn("등급").setPreferredWidth(50);
		table.getColumn("좌석").setPreferredWidth(50);
		table.getColumn("요금").setPreferredWidth(50);
		// TODO Auto-generated method stub
		
	}
}