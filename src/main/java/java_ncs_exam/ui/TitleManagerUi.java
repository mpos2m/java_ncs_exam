package java_ncs_exam.ui;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import java_ncs_exam.dto.Title;
import java_ncs_exam.panel.AbstractContentPanel;
import java_ncs_exam.panel.TitlePanel;
import java_ncs_exam.service.TitleService;
import java_ncs_exam.table.AbstractCustomTablePanel;
import java_ncs_exam.table.TitleTablePanel;

@SuppressWarnings("serial")
public class TitleManagerUi extends AbstractManagerUI<Title> {
	
	public TitleManagerUi() {
	}
	private TitleService service;
	
	@Override
	protected void setService() {
		service = new TitleService();		
	}

	@Override
	protected void tableLoadData() {
		((TitleTablePanel)pList).setService(service);
		pList.loadData();		
	}

	@Override
	protected AbstractContentPanel<Title> createContentPanel() {
		return new TitlePanel();
	}

	@Override
	protected AbstractCustomTablePanel<Title> createTablePanel() {
		return new TitleTablePanel();
	}

	
	@Override
	protected void actionPerformedMenuUpdate() {
		Title updateTitle = pList.getItem();
		pContent.setItem(updateTitle);
		btnAdd.setText("수정");
	}

	@Override
	protected void actionPerformedMenuDelete() {
		
		Title delTitle = pList.getItem();
		service.removeTitle(delTitle);
		pList.loadData();
		JOptionPane.showMessageDialog(null, delTitle + "삭제 되었습니다.");		
	}

	@Override
	protected void actionPerformedBtnUpdate(ActionEvent e) {
		Title updateTitle = pContent.getItem();
		service.modifyTitle(updateTitle);
		pList.loadData();
		pContent.clearTf();
		btnAdd.setText("추가");
		JOptionPane.showMessageDialog(null, updateTitle.gettName() + " 로 변경 되었습니다.");		
	}

	@Override
	protected void actionPerformedBtnAdd(ActionEvent e) {
		Title title = pContent.getItem();
		service.addTitle(title);
		pList.loadData();
		pContent.clearTf();
		JOptionPane.showMessageDialog(null, title + " 추가했습니다.");		
	}

}
