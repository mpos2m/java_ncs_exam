package java_ncs_exam.content;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java_ncs_exam.dto.Title;
import java_ncs_exam.exception.InvalidCheckException;

@SuppressWarnings("serial")
public class TitlePanel extends AbstractContentPanel<Title> {
	private JTextField tfNo;
	private JTextField tfName;
	public TitlePanel() {
		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label = new JLabel("번호");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		add(label);
		
		tfNo = new JTextField();
		tfNo.setColumns(10);
		add(tfNo);
		
		JLabel label_1 = new JLabel("직책");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		add(label_1);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		add(tfName);
	}

	

	@Override
	public void setItem(Title item) {
		tfNo.setText(String.valueOf(item.gettNo()));
		tfName.setText(item.gettName());
		tfNo.setEditable(false);	
	}

	@Override
	public Title getItem() {
		validCheck();
		int tNo = Integer.parseInt(tfNo.getText().trim());
		String tName = tfName.getText().trim();
		return new Title(tNo, tName);
	}

	@Override
	public void validCheck() {
		if (tfNo.getText().contentEquals("") || tfName.getText().equals("")) {
			throw new InvalidCheckException();
		}	
	}

	@Override
	public void clearTf() {
		tfNo.setText("");
		tfName.setText("");
		
		if (!tfNo.isEditable()) {
			tfNo.setEditable(true);
		}
	}

}
