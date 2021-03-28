package java_ncs_exam.table;

import javax.swing.SwingConstants;

import java_ncs_exam.dto.Title;
import java_ncs_exam.exception.NotSelectedException;
import java_ncs_exam.service.TitleService;

@SuppressWarnings("serial")
public class TitleTablePanel extends AbstractCustomTablePanel<Title> {
	public TitleTablePanel() {
	}
	private TitleService service;
	
	@Override
	protected void setAlignAndWidth() {

		setTableCellAlign(SwingConstants.CENTER, 0, 1);
		setTableCellWidth(100, 100);
		
	}

	@Override
	public Object[] toArray(Title t) {
		return new Object[] { t.gettNo(), t.gettName() };
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "번호", "직책" };
	}

	@Override
	public void initList() {
		list = service.showTitle();
	}

	public void setService(TitleService service) {
		this.service = service;
	}

	@Override
	public Title getItem() {
		int row = table.getSelectedRow();
		
		if (row == -1) {
			throw new NotSelectedException();
		}
		int titleNo = (int) table.getValueAt(row, 0);
		
		
		return list.get(list.indexOf(new Title(titleNo)));
	}
	
}


