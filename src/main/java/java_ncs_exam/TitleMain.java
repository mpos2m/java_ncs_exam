package java_ncs_exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import java_ncs_exam.content.AbstractContentPanel;
import java_ncs_exam.content.TitlePanel;
import java_ncs_exam.dto.Title;
import java_ncs_exam.service.TitleService;
import java_ncs_exam.table.AbstractCustomTablePanel;
import java_ncs_exam.table.TitleTablePanel;

@SuppressWarnings("serial")
public class TitleMain extends JFrame implements ActionListener{
	private TitleService service;
	private JPanel contentPane;
	private AbstractContentPanel<?> pContent;
	private AbstractCustomTablePanel<?> pList;
	private JPanel panel;
	private JButton button;
	private JButton button_1;
	private TitlePanel pPanel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TitleMain frame = new TitleMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TitleMain() {
		setService();
		initialize();
		tableLoadData();
	}
	private void initialize() {
		setTitle("직책 관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pPanel = new TitlePanel();
		contentPane.add(pPanel, BorderLayout.NORTH);
		pPanel.setLayout(new GridLayout(0, 2, 10, 0));
		pList = createTablePanel();
		contentPane.add(pList);
		
		panel = new JPanel();
		pList.add(panel, BorderLayout.NORTH);
		
		button = new JButton("추가");
		panel.add(button);
		
		button_1 = new JButton("취소");
		button_1.addActionListener(new Button_1ActionListener());
		panel.add(button_1);
		
		JPopupMenu popupMenu = createPopupMenu();
		pList.setPopupMenu(popupMenu);
	}
	
	private JPopupMenu createPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();

		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(this);
		popMenu.add(updateItem);

		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(this);
		popMenu.add(deleteItem);
		
		return popMenu;
	}
	
	public void setService() {
		service = new TitleService();
	}
	
	public void tableLoadData() {
		((TitleTablePanel) pList).setService(service);
		pList.loadData();
	}
	protected AbstractCustomTablePanel<Title> createTablePanel() {
		return new TitleTablePanel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	private class Button_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pContent.clearTf();
		}
	}
}
