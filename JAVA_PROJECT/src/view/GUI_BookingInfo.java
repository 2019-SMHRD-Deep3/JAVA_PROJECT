package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controller.MemberManagementService;
import model.Book;
import model.Member;

public class GUI_BookingInfo {

	private JFrame frame;
	private JTable table;
	private ListSelectionModel listSelectModel;
	private Icon icon;
	private DefaultTableModel defaultTableModel;
	MemberManagementService ms = new MemberManagementService();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public GUI_BookingInfo(Member loginuser) {

		initialize(loginuser);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Member loginuser) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(12, 60, 760, 18);
		frame.getContentPane().add(separator);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 78, 760, 77);
		frame.getContentPane().add(scrollPane);

		Book book = ms.memberInfoSelect(loginuser);

		String[][] data = { { book.getBooknum(), book.getDep(), book.getArr(), book.getServnum(), book.getDepT(),
				book.getArrT(), book.getPer(), book.getFare() } };

		String[] columnNames = { "예매번호", "출발지", "목적지", "교통편", "출발일", "도착일", "인원수", "가격" };

		defaultTableModel = new DefaultTableModel(data, columnNames);
		table = new JTable(defaultTableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(table);
		listSelectModel = table.getSelectionModel();
		listSelectModel.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (e.getValueIsAdjusting() == false) {
					System.out.println("hello");

				}
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(429, 397, 343, 154);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		// 예매 수정시
		// 1.셀 선택 2.수정버튼 클릭하고 콤보박스의 날짜와 시간 선택-DB 3.수정된 내용이 테이블에 저장-DB
		JButton reserve_edit = new JButton("\uC608\uB9E4 \uC218\uC815");
		reserve_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_BookingModify bm = new GUI_BookingModify(loginuser);

			}
		});
		reserve_edit.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		reserve_edit.addMouseListener(new MouseAdapter() {

		});

		reserve_edit.setBounds(39, 43, 119, 47);
		panel_1.add(reserve_edit);

		JButton reserve_cancel = new JButton("\uC608\uB9E4 \uCDE8\uC18C");
		reserve_cancel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

		reserve_cancel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
//					int numRows = table.getSelectedRows().length;
//					for(int i=0; i< numRows; i++ )
//					 table.remove(table.getSelectedRow());
				int i = listSelectModel.getAnchorSelectionIndex();
				System.out.println(i);
				boolean result = ms.bookingCancle(loginuser);
				if (result) {
					defaultTableModel.removeRow(i);
					JOptionPane.showMessageDialog(frame, "예매가 취소되었습니다.");
				} else {
					JOptionPane.showMessageDialog(frame, "예매가 존재하지 않습니다.");
				}

			}
		});

		reserve_cancel.setBounds(185, 43, 119, 47);
		panel_1.add(reserve_cancel);
		
		JLabel name = new JLabel();
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(24, 28, 98, 38);
		frame.getContentPane().add(name);
		name.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		name.setText(loginuser.getName());

		JLabel label = new JLabel("\uB2D8\uC758 \uC608\uB9E4\uC815\uBCF4");
		label.setBounds(136, 40, 150, 15);
		frame.getContentPane().add(label);
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
	}
}
