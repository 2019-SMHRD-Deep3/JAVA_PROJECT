package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
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
	private JPanel panel;
	private JScrollPane scrollPane;

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
		frame.setBounds(100, 100, 960, 540);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Book book = ms.memberInfoSelect(loginuser);

		if (book ==null) {

		} else {
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

		}

		String imgPath = this.getClass().getResource(".").getPath() + "..//..//img//gaboja.png";
		ImageIcon icon = new ImageIcon(imgPath);
		panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, panel.getWidth(), panel.getHeight(), null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel.setBounds(0, 0, 944, 501);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 69, 920, 422);
		panel.add(panel_1);
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);

		JButton reserve_cancel = new JButton("\uC608\uB9E4 \uCDE8\uC18C");
		reserve_cancel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

		reserve_cancel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// int numRows = table.getSelectedRows().length;
				// for(int i=0; i< numRows; i++ )
				// table.remove(table.getSelectedRow());
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

		reserve_cancel.setBounds(789, 365, 119, 47);
		panel_1.add(reserve_cancel);

		JLabel label = new JLabel("\uB2D8\uC758 \uC608\uB9E4\uC815\uBCF4");
		label.setBounds(120, 20, 150, 21);
		panel_1.add(label);
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		JLabel name = new JLabel();
		name.setBounds(31, 20, 87, 21);
		panel_1.add(name);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		name.setText(loginuser.getName());

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 63, 877, 264);
		panel_1.add(scrollPane);

		JButton back = new JButton("");
		back.setBounds(12, 10, 129, 49);
		back.setFocusPainted(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		panel.add(back);
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GUI_MainMenu main = new GUI_MainMenu(loginuser);
				frame.dispose();
			}

		});
	}
}
