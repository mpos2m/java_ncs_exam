package java_ncs_exam.table;

import javax.swing.SwingConstants;

import java_ncs_exam.dto.Title;
import java_ncs_exam.service.TitleService;

@SuppressWarnings("serial")
public class TitleTablePanel extends AbstractCustomTablePanel<Title> {

	public TitleTablePanel() {
		
	}

	private TitleService service;
	
	@Override
	public void initList() {
		list = service.showTitle();
		
	}

	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1);
		setTableCellWidth(100, 100);
	}

	@Override
	public Object[] toArray(Title t) {
		return new Object[] {t.gettNo(), t.gettName()};
	}

	@Override
	public String[] getColumnNames() {
		
		return new String[] {"번호", "직책"};
	}

	public void setService(TitleService service) {
		this.service = service;
		
	}

}
