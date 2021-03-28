package java_ncs_exam.panel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import java_ncs_exam.dto.Title;
import java_ncs_exam.exception.InvalidCheckException;
import java_ncs_exam.exception.LengthCheckException;

@SuppressWarnings("serial")
public class TitlePanel extends AbstractContentPanel<Title>{
	private JTextField tfNo;
	private JTextField tfName;

	public TitlePanel() {
		initialize();
	}
	
	private void initialize() {
		setBorder(new TitledBorder(null, "직책정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblNo = new JLabel("번호");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNo);
		
		tfNo = new JTextField();
		tfNo.setColumns(10);
		add(tfNo);
		
		JLabel lblName = new JLabel("직책");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		add(tfName);
	}

	@Override
	public void clearTf() {
		tfNo.setText("");
		tfName.setText("");
		
		if (!tfNo.isEditable()) {
			tfNo.setEditable(true);
		}
		
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
		if(tfNo.getText().length()>3) {
			throw new LengthCheckException();
		}
		
		
	}
	
	
}
