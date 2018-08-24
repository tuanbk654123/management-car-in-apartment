// author : Nguyễn Minh Tuấn--------------------------------------------------------------------------------
// KSTN-ĐTVT-K59 -------------------------------------------------------------------------------------------
// BKHN=====================================================================================================

package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ManHinhDangNhap extends JFrame {

	JTextField  txtUser;
	JPasswordField txtPassWord;
	JButton btnDangNhap,btnThoat;
	String Tk ="quanly";
	String pass = "1";
public ManHinhDangNhap(String title)
{
	this.setTitle(title);
	addConTrols();
	addEvents();
}

private void addEvents() {
	// TODO Auto-generated method stub
	btnThoat.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			 System.exit(0);
		}
	});
	btnDangNhap.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String Tk1 = txtUser.getText();
			String pass1 = txtPassWord.getText();
			if( (Tk1.contains(Tk)) && (pass1.contains(pass)))
			{
				DaoDienChinhUI ui1 = new DaoDienChinhUI("Chương Trình quản lý ô tô-Nhóm 5 (KSTN-ĐTVT-K59)");
				ui1.showWindow();
				dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu vui lòng nhập lại","Login error",JOptionPane.ERROR_MESSAGE);
			}
		}
	});
	
}

private void addConTrols() {
	// TODO Auto-generated method stub
	Container con = getContentPane();
	con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
	JPanel pnUser = new JPanel();
	pnUser.setLayout(new FlowLayout());
	JLabel lblUser = new JLabel("Username:");
	txtUser = new JTextField(20);
	pnUser.add(lblUser);
	pnUser.add(txtUser);
	JPanel pnPassWord = new JPanel();
	pnPassWord.setLayout(new FlowLayout());
	JLabel lblPassWord = new JLabel("Password:");
	txtPassWord = new JPasswordField(20);
	pnPassWord.add(lblPassWord);
	pnPassWord.add(txtPassWord);
	JPanel pnTieuDe = new JPanel();
	JLabel lblDangNhap = new JLabel("Đăng Nhập");
	Font font = new Font("arial", Font.BOLD,40);
	lblDangNhap.setFont(font);
	
	JPanel pnButton = new JPanel();
	btnDangNhap = new JButton("Đăng Nhập");
	btnThoat = new JButton("Thoát");
	pnButton.setLayout(new FlowLayout());
	pnButton.add(btnDangNhap);
	pnButton.add(btnThoat);
			
	
	con.add(pnTieuDe);
	con.add(pnUser);
	con.add(pnPassWord);
	con.add(pnButton);
	pnTieuDe.add(lblDangNhap);

	
}

public void showWindow()
{
	this.setSize(400,300);
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	this.setLocationRelativeTo(null);
	this.setVisible(true);
	
}


}
