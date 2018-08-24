// author : Nguyễn Minh Tuấn--------------------------------------------------------------------------------
// KSTN-ĐTVT-K59 -------------------------------------------------------------------------------------------
// BKHN=====================================================================================================

package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.xml.stream.events.StartElement;



public class DaoDienBtnThem extends JDialog {
	JButton btnLuu;
	JTextField txtTenChuXe,txtBienSo,txtHangXe ,
	txtMauXe ,
	txtId,
	txtNgayDangKy ,
	txtNgayHetHan ;
	public static int ketqua = -1;
	public static int ketqua1 = -1;
	public String idVeThangChon="";

	Connection conn=DaoDienChinhUI.conn;
	Statement statement=DaoDienChinhUI.statement;

	public DaoDienBtnThem(String title)
	{
		this.setTitle(title);
		addControls();
		addEvents();
	}

	private void addControls() {
		// TODO Auto-generated method stub
		Container con = getContentPane();
		JLabel lblVeThang = new JLabel("Thêm Vé tháng");
		 
		JLabel lblId = new JLabel(" ID: ");
		JLabel lblBienSo = new JLabel("Biển số: ");
		JLabel lblTenChuXe = new JLabel("Tên chủ xe: ");
		JLabel lblMauXe = new JLabel("Màu Xe: ");
		JLabel lblHangXe = new JLabel("Hãng Xe: ");
		JLabel lblNgayDangKy = new JLabel("Ngày đăng ký: ");
		JLabel lblNgayHetHan = new JLabel("Ngày Hết hạn: ");

		
		
		lblBienSo.setPreferredSize(lblNgayDangKy.getPreferredSize());
		lblHangXe.setPreferredSize(lblNgayDangKy.getPreferredSize());
		lblMauXe.setPreferredSize(lblNgayDangKy.getPreferredSize());
		lblId.setPreferredSize(lblNgayDangKy.getPreferredSize());
		lblTenChuXe.setPreferredSize(lblNgayDangKy.getPreferredSize());
		lblNgayHetHan.setPreferredSize(lblNgayDangKy.getPreferredSize());

		txtTenChuXe = new JTextField(40);
		txtBienSo = new JTextField(40);
		txtHangXe = new JTextField(40);
		txtMauXe = new JTextField(40) ;
		txtId = new JTextField(40) ;
		txtNgayDangKy = new JTextField(40) ;
		txtNgayHetHan = new JTextField(40) ;
		
		
		JPanel pnTenChuXe= new JPanel();
		JPanel pnBienSo = new JPanel();
		JPanel pnHangXe = new JPanel();
		JPanel pnMauXe = new JPanel();
		JPanel pnID = new JPanel();
		JPanel pnNgayDangKy = new JPanel();
		JPanel pnNgayHetHan = new JPanel();
		pnTenChuXe.add(lblTenChuXe);
		pnTenChuXe.add(txtTenChuXe);
		pnBienSo.add(lblBienSo);
		pnBienSo.add(txtBienSo);
		pnHangXe.add(lblHangXe);
		pnHangXe.add(txtHangXe);
		pnMauXe.add(lblMauXe);
		pnMauXe.add(txtMauXe);
		pnID.add(lblId);
		pnID.add(txtId);
		pnNgayDangKy.add(lblNgayDangKy);
		pnNgayDangKy.add(txtNgayDangKy);
		pnNgayHetHan.add(lblNgayHetHan);
		pnNgayHetHan.add(txtNgayHetHan);
		
		JPanel pnLuu = new JPanel();
		pnLuu.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnLuu = new JButton("Lưu");
		pnLuu.add(btnLuu);
		
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
		con.add(pnID);
		con.add(pnBienSo);
		con.add(pnTenChuXe);
		con.add(pnMauXe);
		con.add(pnHangXe);
		con.add(pnNgayDangKy);
		con.add(pnNgayHetHan);
		con.add(pnLuu);
	
		
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		btnLuu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				xuLyLuu();
			}

		});
	}
	protected void xuLyLuu() {
		// TODO Auto-generated method stub
		if (idVeThangChon.length() == 0)
		{

			try 
			{
				String sql = "insert into vethang values ( '"+txtId.getText()+"', '"+txtBienSo.getText()+"','"+txtTenChuXe.getText()+"','"+txtMauXe.getText()+"','"+txtHangXe.getText()+"','"+txtNgayDangKy.getText()+"','"+txtNgayHetHan.getText()+"' )";
				//String sql="insert into taisan values('"+txtMa.getText()+"','"+txtTen.getText()+"','"+txtNgayNhap.getText()+"',"+txtSoNamKhauHao.getText()+","+txtGiaTri.getText()+")";
				statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				ketqua = x ;
				String a = "";
				String b = "Không Gửi";
				String sql1 = "insert into trangthai values ( '"+txtId.getText()+"','"+txtBienSo.getText()+"','"+a+"','"+a+"','"+b+"' )";
				//statement = conn.createStatement();
				int x1 = statement.executeUpdate(sql1);
				ketqua1 = x1 ;
				
				
	
//				dispose();//ẩn màn hình này đi
			}
			catch (Exception e) {
				// TODO: handle exception
			}

			dispose();//ẩn màn hình này đi
		}
		
		else
		{
			try
			{
				String sql = "update vethang set bienso = '"+txtBienSo.getText()+"'"
						+ ", tenchuxe= '"+txtTenChuXe.getText()+"'"
						+ ", mauxe = '"+txtMauXe.getText()+"'"
						+ ", loaixe='"+txtHangXe.getText()+"'"
						+ ", ngaydangky ='"+txtNgayDangKy.getText()+"'"
						+ ", ngayhethan = '"+txtNgayHetHan.getText()+"' where id='"+idVeThangChon+"'";
				statement = conn.createStatement();
				int x=statement.executeUpdate(sql);
				ketqua=x;
				
				String sql2 = "select * from trangthai where bienso = ?";
				java.sql.PreparedStatement prepe = conn.prepareStatement(sql2);
				prepe.setString(1, txtBienSo.getText());
				ResultSet result = prepe.executeQuery();
				String timeIn = "";
				String timeOut = "";
				String trangThai = "";
				while ( result.next())
				{
					timeIn=result.getString(3);
					timeOut=result.getString(4);
					trangThai=result.getString(5);
					
				}
				String sql1="update trangthai set bienso=? where id=?";
				PreparedStatement preStatement2=(PreparedStatement) conn.prepareStatement(sql1);
				
				preStatement2.setString(1, txtBienSo.getText());
				preStatement2.setString(2, idVeThangChon);
				
				int x1 = preStatement2.executeUpdate();
				ketqua1 = x1 ;	
				
				dispose();//ẩn màn hình này đi
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public void hienThiThongTinChiTiet()
	{
			try 
			{
			String sql = "select * from vethang where Id = '"+idVeThangChon+"'";
			statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			if(result.next())
			{
				txtId.setText(result.getString(1));
				txtBienSo.setText(result.getString(2));
				txtTenChuXe.setText(result.getString(3)+"");
				txtMauXe.setText(result.getString(4)+"");
				txtHangXe.setText(result.getString(5)+"");
				txtNgayDangKy.setText(result.getString(6)+"");
				txtNgayHetHan.setText(result.getString(7)+"");
			}
			txtId.setEditable(false);
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	
	}

	public void showWindows()
	{
		this.setSize(600,500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setVisible(true);
	}
}
