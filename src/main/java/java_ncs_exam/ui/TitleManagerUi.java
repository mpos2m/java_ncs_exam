package java_ncs_exam.ui;

import java.awt.event.ActionEvent;

import java_ncs_exam.content.AbstractContentPanel;
import java_ncs_exam.content.TitlePanel;
import java_ncs_exam.dto.Title;
import java_ncs_exam.service.TitleService;
import java_ncs_exam.table.AbstractCustomTablePanel;
import java_ncs_exam.table.TitleTablePanel;

@SuppressWarnings("serial")
public class TitleManagerUi extends AbstractManagerUI<Title> {

	
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
			
	}

	@Override
	protected void actionPerformedMenuDelete() {
			
	}

	@Override
	protected void actionPerformedBtnUpdate(ActionEvent e) {
		
	}

	@Override
	protected void actionPerformedBtnAdd(ActionEvent e) {
		
	}

	
}
