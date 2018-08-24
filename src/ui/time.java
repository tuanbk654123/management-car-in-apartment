package ui;

import java.awt.Container;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class time extends JFrame {
	public JTextField clockField;
	public time(String title)
	{
		this.setTitle(title);
		addConTrols();
		addEvents();
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		
	}

	private void addConTrols() {
		// TODO Auto-generated method stub
		Container con = getContentPane();
		 Calendar now = Calendar.getInstance();
         int h = now.get(Calendar.HOUR_OF_DAY);
         int m = now.get(Calendar.MINUTE);
         int s = now.get(Calendar.SECOND);
         clockField = new JTextField(20);
         clockField.setText("" + h + ":" + m + ":" + s);
         con.add(clockField);
		
		
	}
	public void showWindow()
	{
		this.setSize(400,300);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

}
