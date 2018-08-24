// author : Nguyễn Minh Tuấn--------------------------------------------------------------------------------
// KSTN-ĐTVT-K59 -------------------------------------------------------------------------------------------
// BKHN=====================================================================================================

package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Properties;
import java.util.Vector;

import javax.swing.BorderFactory;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;



public class DaoDienChinhUI extends JFrame  {
	JButton btnThemTrong, btnSuaTrong, btnXoaTrong,btnTimKiem,btnRefesh,btnTimKiem11,btnReFreshLichSu;
	JTextField txtTimKiem,txtGuiXe,txtLay,txtTimKiem11;
	JTabbedPane tab;
	//DefaultTableModel dtmVeXe;
	JTable tblVeXe;
	
	JButton btnThemTrong1, btnSuaTrong1, btnXoaTrong1,btnTimKiem1,btnRefesh1;
	JTextField txtTimKiem1;
	JTabbedPane tab1;
//	DefaultTableModel dtmVeXe1;
	JTable tblVeXe1;
	
	JButton btnGui, btnlay;
	
	JTabbedPane tab2;
	DefaultTableModel dtmVeXe2,dtmVeXe22,dtmVeXe1,dtmVeXe,dtmLichSuCuDan,dtmLichSuKhachNgay;
	JTable tblVeXe2,tblVeXe22,tblLichSuCuDan,tblLichSuKhachNgay;
	
	JLabel lblLuot1z,lblThang1z,lblThang1zz,lblLuot1zz,lblTienVeThang1,lblTienLuot1,lblTongtien1;
	public static Connection conn=null;
	public static Statement statement=null;
	
	public String time1="";
	public static int SoChoDeXeLuot = 200;
	public static int SoChoDeXeThang = 500;
	public static int  SoXeThangDangGui =0;
	public static int  SoXeLuotDangGui =0;
	
	public static int  TienVeThang =0;
	public static int  TienVeLuot =0;
	public static int  TongTien =0;
	
	public String XeLuot = "";
	public String XeThang = "";
	public String xeThangdanggui = "";
	public String xeluotdanggui = "";
	public String BienSo = "";
	public String TienThang ="";
	public String TienThang1 ="";	
	public String TienLuot="";
	public String TienLuot1 ="";
	public String TongTienS ="";
	public String TongTienS1 ="";
	
public DaoDienChinhUI( String title)
{
	super (title);
	ketNoiCSDL();
	DemSoXeThangDangGui();
	DemSoXeLuotDangGui();
	
	TinhTienVeThang();
	TinhTienVeLuot();
	TinhTongTien();
	
	
	addControls();
	addEvents();
	hienThiToanBoVeThang();
	HienThiTrangThaiXe();
	hienThiToanBoVeCuDan();
	HienThiTrangThaiXeNgay();
	HienThiLichSuCuDan();
	HienThiLichSuKhachNgay();

	
}

private void TinhTongTien() {
	// TODO Auto-generated method stub
	TongTien = TienVeThang + TienVeLuot;
	TongTienS = String.valueOf( TongTien);
	TongTienS1 = 	TongTienS +" VNĐ";
}

private void TinhTienVeLuot() {
	// TODO Auto-generated method stub
	try
	{
		String sql="select * from lichsukhachngay";
		statement=conn.createStatement();
		ResultSet result=statement.executeQuery(sql);
		while(result.next())
		{
			TienVeLuot = TienVeLuot + 20000;
		}
	}
	catch(Exception ex)
	{
		
	}
	TienLuot = String.valueOf( TienVeLuot);
	TienLuot1 = 	TienLuot +" VNĐ";
}

private void TinhTienVeThang() {
	// TODO Auto-generated method stub
	try
	{
		String sql="select * from vethang";
		statement=conn.createStatement();
		ResultSet result=statement.executeQuery(sql);
		while(result.next())
		{
			TienVeThang = TienVeThang + 250000;
		}
	}
	catch(Exception ex)
	{
		
	}
	TienThang = String.valueOf( TienVeThang);
	TienThang1 = TienThang +" VNĐ";
}

private void HienThiLichSuKhachNgay() {
	// TODO Auto-generated method stub
	try
	{
		String sql="select * from lichsukhachngay";
		statement=conn.createStatement();
		ResultSet result=statement.executeQuery(sql);
		dtmLichSuKhachNgay.setRowCount(0);
		while(result.next())
		{
			Vector<Object>vec=new Vector<Object>();
			vec.add(result.getString(1));
			vec.add(result.getString(2));
			vec.add(result.getString(3));
			
			dtmLichSuKhachNgay.addRow(vec);
			//System.out.println(result.getString(1));
		}
	}
	catch(Exception ex)
	{
		
	}
}

private void HienThiLichSuCuDan() {
	// TODO Auto-generated method stub
	try
	{
		String sql="select * from lichsucudan";
		statement=conn.createStatement();
		ResultSet result=statement.executeQuery(sql);
		dtmLichSuCuDan.setRowCount(0);
		while(result.next())
		{
			Vector<Object>vec=new Vector<Object>();
			vec.add(result.getString(1));
			vec.add(result.getString(2));
			vec.add(result.getString(3));
			vec.add(result.getString(4));
			
			dtmLichSuCuDan.addRow(vec);
			//System.out.println(result.getString(1));
		}
	}
	catch(Exception ex)
	{
		
	}
	
}

private void DemSoXeLuotDangGui() {
	// TODO Auto-generated method stub
	try {
		String sql = "select * from trangthai2 where trangthai = ?";
		java.sql.PreparedStatement prepe = conn.prepareStatement(sql);
		prepe.setString(1, "Đang gửi");
	//	dtmVeXe1.setRowCount(0);
		ResultSet result = prepe.executeQuery();
		
		while ( result.next())
		{
			SoXeLuotDangGui = SoXeLuotDangGui + 1;
			
		}
		SoChoDeXeLuot = 200 - SoXeLuotDangGui;
		
	} catch (Exception e2) {
		// TODO: handle exception
	}
	System.out.println(SoChoDeXeLuot);
	
}

private void DemSoXeThangDangGui() {
	// TODO Auto-generated method stub
	try {
		String sql = "select * from trangthai where trangthai = ?";
		java.sql.PreparedStatement prepe = conn.prepareStatement(sql);
		prepe.setString(1, "Đang gửi");
	//	dtmVeXe1.setRowCount(0);
		ResultSet result = prepe.executeQuery();
		
		while ( result.next())
		{
			SoXeThangDangGui = SoXeThangDangGui + 1;
			
		}
		SoChoDeXeThang = 500 - SoXeThangDangGui;
	} catch (Exception e2) {
		// TODO: handle exception
	}
}

private void hienThiToanBoVeCuDan() {
	// TODO Auto-generated method stub
	try
	{
		String sql="select * from vecudan";
		statement=conn.createStatement();
		ResultSet result=statement.executeQuery(sql);
		dtmVeXe1.setRowCount(0);
		while(result.next())
		{
			Vector<Object>vec=new Vector<Object>();
			vec.add(result.getString(1));
			vec.add(result.getString(2));
			vec.add(result.getString(3));
			vec.add(result.getString(4));
			vec.add(result.getString(5));
			vec.add(result.getString(6));
			vec.add(result.getString(7));
			dtmVeXe1.addRow(vec);
			//System.out.println(result.getString(1));
		}
	}
	catch(Exception ex)
	{
		
	}
	
}

private void HienThiTrangThaiXe() {
	// TODO Auto-generated method stub
	try {
		String sql="select * from trangthai";
		statement=conn.createStatement();
		ResultSet result=statement.executeQuery(sql);
		dtmVeXe2.setRowCount(0);
		while(result.next())
		{
			Vector<Object>vec=new Vector<Object>();
			vec.add(result.getString(1));
			vec.add(result.getString(2));
			vec.add(result.getString(3));
			vec.add(result.getString(4));
			vec.add(result.getString(5));

			dtmVeXe2.addRow(vec);
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
}

private void HienThiTrangThaiXeNgay() {
	// TODO Auto-generated method stub
	try {
		String sql="select * from trangthai2";
		statement=conn.createStatement();
		ResultSet result=statement.executeQuery(sql);
		dtmVeXe22.setRowCount(0);
		while(result.next())
		{
			Vector<Object>vec=new Vector<Object>();
			vec.add(result.getString(1));
			vec.add(result.getString(2));
			vec.add(result.getString(3));
			vec.add(result.getString(4));
		//	vec.add(result.getString(5));

			dtmVeXe22.addRow(vec);
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
}


private void hienThiToanBoVeThang() {
	// TODO Auto-generated method stub
	try
	{
		String sql="select * from vethang";
		statement=conn.createStatement();
		ResultSet result=statement.executeQuery(sql);
		dtmVeXe.setRowCount(0);
		while(result.next())
		{
			Vector<Object>vec=new Vector<Object>();
			vec.add(result.getString(1));
			vec.add(result.getString(2));
			vec.add(result.getString(3));
			vec.add(result.getString(4));
			vec.add(result.getString(5));
			vec.add(result.getDate(6));
			vec.add(result.getDate(7));
			dtmVeXe.addRow(vec);
		}
	}
	catch(Exception ex)
	{
		
	}
}

private void ketNoiCSDL() {
//	// TODO Auto-generated method stub
	try
	{
		String strlConn="jdbc:mysql://localhost/dbvethang?useUnicode=true&characterEncoding=utf-8";
		Properties pro=new Properties();
		pro.put("user", "root");
		pro.put("password", "");
		Driver driver=new Driver();     
		conn=driver.connect(strlConn, pro);
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	
}

private void addControls() {
	// TODO Auto-generated method stub
	Container con =  getContentPane();
	con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
	
	tab =new JTabbedPane();

	JPanel pnTabGuiXe = new JPanel();
	
	//tab đăng ký---------------------------------------------------------------------------------------------------

	Font font = new Font("arial", Font.BOLD,40);
	Font font1 = new Font("arial", Font.BOLD,20);
	JLabel lblDangKy = new JLabel("ĐĂNG KÝ VÉ THÁNG");
	lblDangKy.setFont(font);
	JLabel lblQuanLyVeCuDan = new JLabel("QUẢN LÝ VÉ CƯ DÂN");
	lblQuanLyVeCuDan.setFont(font);
	
	JTabbedPane tabDangKy = new JTabbedPane();

	JPanel pnNguoiKhongTrongTrungCu = new JPanel();
	
	//TAB người không ở trung cư--------------------------------------------------------------------------------------
	JPanel pnVeThang = new JPanel();
	pnVeThang.setLayout(new BoxLayout(pnVeThang, BoxLayout.Y_AXIS));
	JPanel pnNguoiTrongTrungCu = new JPanel();
	pnNguoiTrongTrungCu.setLayout(new BoxLayout(pnNguoiTrongTrungCu, BoxLayout.Y_AXIS));
	JPanel pnVeXeTrong = new JPanel();
	pnVeXeTrong.setLayout(new BoxLayout(pnVeXeTrong, BoxLayout.Y_AXIS));
	JPanel pnButtonTrong = new JPanel();
	pnButtonTrong.setLayout(new FlowLayout(FlowLayout.RIGHT));
	
	//Tạo viền ngoài bảng
	Border borderThongTin = BorderFactory.createLineBorder(Color.BLUE);
	TitledBorder borderTitleThongtin=new TitledBorder(borderThongTin, "Thông tin vé xe tháng:");
	pnVeXeTrong.setBorder(borderTitleThongtin);
	//pnButtonTrong
	btnThemTrong = new JButton("Đăng ký");
	btnThemTrong.setIcon(new ImageIcon("hinh/Add.png"));
	btnSuaTrong= new JButton("Sửa");
	btnSuaTrong.setIcon(new ImageIcon("hinh/fix.png"));
	btnXoaTrong = new JButton("Xóa");
	btnXoaTrong.setIcon(new ImageIcon("hinh/delete.png"));
	btnRefesh = new JButton("Refresh");
	btnRefesh.setIcon(new ImageIcon("hinh/refresh.png"));
	
	
	JPanel pnThemTrong= new JPanel(); pnThemTrong.add(btnThemTrong);
	JPanel pnSuaTrong = new JPanel(); pnSuaTrong.add(btnSuaTrong);
	JPanel pnXoaTrong = new JPanel(); pnXoaTrong.add(btnXoaTrong);
	JPanel pnRefresh = new JPanel(); pnRefresh.add(btnRefesh);
	
	pnButtonTrong.add(pnThemTrong);
	pnButtonTrong.add(pnSuaTrong);
	pnButtonTrong.add(pnXoaTrong);
	pnButtonTrong.add(pnRefresh);
	
	//pnTimKiem
	JPanel pnTimKiem = new JPanel();
	pnTimKiem.setLayout(new FlowLayout());
	JLabel lblTimKiem = new JLabel("Tìm Kiếm theo biển số xe");
	pnTimKiem.add(lblTimKiem);
	txtTimKiem = new JTextField(40);
	pnTimKiem.add(txtTimKiem);
	btnTimKiem = new JButton("Tìm");
	btnTimKiem.setIcon(new ImageIcon("hinh/search-icon.png"));
	pnTimKiem.add(btnTimKiem);
	
	//	pnBangHienThiThongTin
	JPanel pnBang = new JPanel();
	pnBang.setLayout(new BorderLayout());
	dtmVeXe =new DefaultTableModel();
	dtmVeXe.addColumn("ID"); 
	dtmVeXe.addColumn("Biển Số");
	dtmVeXe.addColumn("Tên chủ xe");
	dtmVeXe.addColumn("màu xe");
	dtmVeXe.addColumn("Loại xe");
	dtmVeXe.addColumn("Ngày đăng kí");
	dtmVeXe.addColumn("Ngày hết hạn");
	tblVeXe = new JTable(dtmVeXe);
	JScrollPane scTable=new JScrollPane(tblVeXe,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	//TAB người ở trung cư
	JPanel pnQuanLyVeCuDan = new JPanel();
	pnQuanLyVeCuDan.setLayout(new BoxLayout(pnQuanLyVeCuDan, BoxLayout.Y_AXIS));
	pnNguoiKhongTrongTrungCu.setLayout(new BoxLayout(pnNguoiKhongTrongTrungCu, BoxLayout.Y_AXIS));
	JPanel pnVeXeTrong1 = new JPanel();
	pnVeXeTrong1.setLayout(new BoxLayout(pnVeXeTrong1, BoxLayout.Y_AXIS));
	JPanel pnButtonTrong1 = new JPanel();
	pnButtonTrong1.setLayout(new FlowLayout(FlowLayout.RIGHT));
	
	//Tạo viền ngoài bảng
	Border borderThongTin1 = BorderFactory.createLineBorder(Color.BLUE);
	TitledBorder borderTitleThongtin1=new TitledBorder(borderThongTin1, "Thông tin vé xe tháng:");
	pnVeXeTrong1.setBorder(borderTitleThongtin1);
	//  pnButtonTrong
	btnThemTrong1 = new JButton("Thêm");
	btnThemTrong1.setIcon(new ImageIcon("hinh/Add.png"));
	btnSuaTrong1= new JButton("Sửa");
	btnSuaTrong1.setIcon(new ImageIcon("hinh/fix.png"));
	btnXoaTrong1 = new JButton("Xóa");
	btnXoaTrong1.setIcon(new ImageIcon("hinh/delete.png"));
	btnRefesh1 = new JButton("Refresh");
	btnRefesh1.setIcon(new ImageIcon("hinh/refresh.png"));
	
	JPanel pnThemTrong1= new JPanel(); pnThemTrong1.add(btnThemTrong1);
	JPanel pnSuaTrong1 = new JPanel(); pnSuaTrong1.add(btnSuaTrong1);
	JPanel pnXoaTrong1 = new JPanel(); pnXoaTrong1.add(btnXoaTrong1);
	JPanel pnRefresh1 = new JPanel(); pnRefresh1.add(btnRefesh1);
	
	pnButtonTrong1.add(pnThemTrong1);
	pnButtonTrong1.add(pnSuaTrong1);
	pnButtonTrong1.add(pnXoaTrong1);
	pnButtonTrong1.add(pnRefresh1);
	
	//pnTimKiem
	JPanel pnTimKiem1 = new JPanel();
	pnTimKiem1.setLayout(new FlowLayout());
	JLabel lblTimKiem1 = new JLabel("Tìm Kiếm theo biển số xe");
	pnTimKiem1.add(lblTimKiem1);
	txtTimKiem1 = new JTextField(40);
	pnTimKiem1.add(txtTimKiem1);
	btnTimKiem1 = new JButton("Tìm");
	btnTimKiem1.setIcon(new ImageIcon("hinh/search-icon.png"));
	pnTimKiem1.add(btnTimKiem1);
	
	//	pnBangHienThiThongTin
	JPanel pnBang1 = new JPanel();
	pnBang1.setLayout(new BorderLayout());
	dtmVeXe1 =new DefaultTableModel();
	dtmVeXe1.addColumn("ID"); 
	dtmVeXe1.addColumn("Biển Số");
	dtmVeXe1.addColumn("Tên chủ xe");
	dtmVeXe1.addColumn("màu xe");
	dtmVeXe1.addColumn("Loại xe");
	dtmVeXe1.addColumn("địa chỉ căn hộ");
	dtmVeXe1.addColumn("Ngày đăng kí");
	tblVeXe1 = new JTable(dtmVeXe1);
	JScrollPane scTable1=new JScrollPane(tblVeXe1,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	//TAB quản lý ra vào---------------------------------------------------------------------------------------------------
	pnTabGuiXe.setLayout(new BoxLayout(pnTabGuiXe,BoxLayout.Y_AXIS));
	JPanel pnGui = new JPanel();
	pnGui.setLayout(new FlowLayout(FlowLayout.LEFT));
	JLabel lblGui = new JLabel("GỬI,LẤY XE");
	lblGui.setFont(font);
	JLabel lblGuiXe = new JLabel("Gửi xe (Nhập Biển Số): ");
	txtGuiXe = new JTextField(20);
	btnGui = new JButton("Gửi");
	
	JPanel pnLay = new JPanel();
	pnLay.setLayout(new FlowLayout(FlowLayout.LEFT));
	JLabel  lblLay = new JLabel("Lấy Xe (Nhập Biển Số): ");
	txtLay = new JTextField(20);
	btnlay = new JButton("Lấy");
	//Tạo Bảng.1
	JPanel pnBang2Bo = new JPanel();
	pnBang2Bo.setLayout(new BoxLayout(pnBang2Bo, BoxLayout.Y_AXIS));
	JLabel lblVeThang = new JLabel("Bảng Vé Tháng và vé Cư Dân");
	JPanel pnVeThang1 = new JPanel();
	pnVeThang1.setLayout(new FlowLayout(FlowLayout.CENTER));
	pnVeThang1.add(lblVeThang);
	JPanel pnbang2 = new JPanel();
	pnbang2.setLayout(new BorderLayout());
	
	dtmVeXe2 = new DefaultTableModel();
	dtmVeXe2.addColumn("ID");
	dtmVeXe2.addColumn("Biển Số");
	dtmVeXe2.addColumn("Thời Gian Gửi Xe");
	dtmVeXe2.addColumn("Thời Gian Lấy Xe");
	dtmVeXe2.addColumn("Trạng Thái");
	tblVeXe2= new JTable(dtmVeXe2);
	JScrollPane scTable2 = new JScrollPane(tblVeXe2,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	pnbang2.add(scTable2);
	//Tạo Bảng.2
	JPanel pnBang22Bo = new JPanel();
	pnBang22Bo.setLayout(new BoxLayout(pnBang22Bo, BoxLayout.Y_AXIS));
	JLabel lblVeLuot = new JLabel("Bảng thông tin Gửi xe theo Lượt");
	JPanel pnVeLuot = new JPanel();
	pnVeLuot.setLayout(new FlowLayout(FlowLayout.CENTER));
	pnVeLuot.add(lblVeLuot);
	JPanel pnbang22 = new JPanel();
	pnbang22.setLayout(new BorderLayout());
	dtmVeXe22 = new DefaultTableModel();
//	dtmVeXe2.addColumn("ID");
	dtmVeXe22.addColumn("Biển Số");
	dtmVeXe22.addColumn("Thời Gian Gửi Xe");
	dtmVeXe22.addColumn("Thời Gian Lấy Xe");
	dtmVeXe22.addColumn("Trạng Thái");
	tblVeXe22= new JTable(dtmVeXe22);
	JScrollPane scTable22 = new JScrollPane(tblVeXe22,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	pnbang22.add(scTable22);
	
	JPanel pn1 = new JPanel();
	pn1.setLayout(new BoxLayout(pn1, BoxLayout.X_AXIS));
	
	pnTabGuiXe.add(lblGui);
	pnTabGuiXe.add(pnGui);
	pnTabGuiXe.add(pnLay);
	pnTabGuiXe.add(pn1);
	pn1.add(pnBang2Bo);
	pn1.add(pnBang22Bo);
	
	pnBang2Bo.add(pnVeThang1);
	pnBang2Bo.add(pnbang2);
	pnBang22Bo.add(pnVeLuot);
	pnBang22Bo.add(pnbang22);
	pnGui.add(lblGuiXe);
	pnGui.add(txtGuiXe);
	pnGui.add(btnGui);
	pnLay.add(lblLay);
	pnLay.add(txtLay);
	pnLay.add(btnlay);	
	lblDangKy.setFont(font);
	
	//TAB Thông Tin Nhà Xe------------------------------------------------------------------------------------------
	JPanel pnThongTinNhaXe = new JPanel();
	pnThongTinNhaXe.setLayout(new BoxLayout(pnThongTinNhaXe, BoxLayout.X_AXIS));
	
	JPanel pnTong= new JPanel();
	pnTong.setLayout(new BoxLayout(pnTong, BoxLayout.Y_AXIS));
	JPanel pnThongTinNhaXe1 = new JPanel();
	pnThongTinNhaXe1.setLayout(new BoxLayout(pnThongTinNhaXe1, BoxLayout.Y_AXIS));
	JPanel pnThongTinNhaXe2 = new JPanel();
	pnThongTinNhaXe2.setLayout(new BoxLayout(pnThongTinNhaXe2, BoxLayout.Y_AXIS));
	JPanel pnThongTinNhaXe3 = new JPanel();
	pnThongTinNhaXe3.setLayout(new BoxLayout(pnThongTinNhaXe3, BoxLayout.Y_AXIS));
	
	
	
	JPanel pnLuot = new JPanel();
	pnLuot.setLayout(new FlowLayout());
	JLabel lblLuot = new JLabel("Số chỗ cho xe gửi theo lượt: ");
	JLabel lblLuot1 = new JLabel("200");
	lblLuot.setFont(font1);
	lblLuot1.setFont(font1);
	pnLuot.add(lblLuot);
	pnLuot.add(lblLuot1);
	
	JPanel pnThang = new JPanel();
	pnThang.setLayout(new FlowLayout());
	JLabel lblThang = new JLabel("Số chỗ cho xe gửi theo tháng và cư dân: ");
	JLabel lblThang1 = new JLabel("500");
	lblThang.setFont(font1);
	lblThang1.setFont(font1);
	pnThang.add(lblThang);
	pnThang.add(lblThang1);
	
	JPanel pnBangLSTong = new JPanel();
	pnBangLSTong.setLayout(new BoxLayout(pnBangLSTong, BoxLayout.X_AXIS));
	
	JPanel pnBangLS1 = new JPanel();
	pnBangLS1.setLayout(new BoxLayout(pnBangLS1, BoxLayout.Y_AXIS));
	
	JPanel pnaa = new JPanel();
	pnaa.setLayout(new FlowLayout());
	JLabel lblLichSuCuDan = new JLabel("Lịch sử ra vào của cư dân và khách tháng") ;
	pnaa.add(lblLichSuCuDan);
	JPanel pnbanglichSuCuDan = new JPanel();
	pnbanglichSuCuDan.setLayout(new BorderLayout());
	dtmLichSuCuDan = new DefaultTableModel();
	dtmLichSuCuDan.addColumn("ID");
	dtmLichSuCuDan.addColumn("Biển Số");
	//dtmLichSuCuDan.addColumn("Chủ Xe");
	dtmLichSuCuDan.addColumn("Thời gian gửi");
	dtmLichSuCuDan.addColumn("Thời gian lấy");
	tblLichSuCuDan= new JTable(dtmLichSuCuDan);
	JScrollPane scLichSuCuDan = new JScrollPane(tblLichSuCuDan,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	pnbanglichSuCuDan.add(scLichSuCuDan);
	
	pnBangLS1.add(pnaa);
	pnBangLS1.add(pnbanglichSuCuDan);
	
	JPanel pnBangLS2 = new JPanel();
	pnBangLS2.setLayout(new BoxLayout(pnBangLS2, BoxLayout.Y_AXIS));
	JPanel pna = new JPanel();
	pna.setLayout(new FlowLayout());
	JLabel lblLichSuKhachngay = new JLabel("Lịch sử ra vào của khách ngày") ;
	pna.add(lblLichSuKhachngay);
	JPanel pnbanglichSuKhachNgay = new JPanel();
	pnbanglichSuKhachNgay.setLayout(new BorderLayout());
	dtmLichSuKhachNgay = new DefaultTableModel();
	dtmLichSuKhachNgay.addColumn("Biển Số");;
	dtmLichSuKhachNgay.addColumn("Thời gian gửi");
	dtmLichSuKhachNgay.addColumn("Thời gian lấy");
	tblLichSuKhachNgay= new JTable(dtmLichSuKhachNgay);
	JScrollPane scLichSuKhachNgay = new JScrollPane(tblLichSuKhachNgay,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	pnbanglichSuKhachNgay.add(scLichSuKhachNgay);
	
	pnBangLS2.add(pna);
	pnBangLS2.add(pnbanglichSuKhachNgay);
	
	pnBangLSTong.add(pnBangLS1);
	pnBangLSTong.add(pnBangLS2);
	
//	JPanel pnCuDan = new JPanel();
//	pnCuDan.setLayout(new FlowLayout());
//	JLabel lblCuDan = new JLabel("Số chỗ cho xe của cư dân: ");
//	JLabel lblCudan1 = new JLabel("500");
//	lblCuDan.setFont(font1);
//	lblCudan1.setFont(font1);
//	pnCuDan.add(lblCuDan);
//	pnCuDan.add(lblCudan1);
	
	JPanel pnLuotz = new JPanel();
	pnLuotz.setLayout(new FlowLayout(FlowLayout.RIGHT));
	JLabel lblLuotz = new JLabel("Còn trống: ");
	lblLuot1z = new JLabel(String.valueOf( SoChoDeXeLuot));
	lblLuotz.setFont(font1);
	lblLuot1z.setFont(font1);
	pnLuotz.add(lblLuotz);
	pnLuotz.add(lblLuot1z);
	
	JPanel pnThangz = new JPanel();
	pnThangz.setLayout(new FlowLayout(FlowLayout.RIGHT));
	JLabel lblThangz = new JLabel("Còn trống: ");
	lblThang1z = new JLabel(String.valueOf(SoChoDeXeThang));
	lblThangz.setFont(font1);
	lblThang1z.setFont(font1);
	
	pnThangz.add(lblThangz);
	pnThangz.add(lblThang1z);

	JPanel pnLuotzz = new JPanel();
	pnLuotzz.setLayout(new FlowLayout(FlowLayout.RIGHT));
	JLabel lblLuotzz = new JLabel("Đang gửi: ");
	lblLuot1zz = new JLabel(String.valueOf( SoXeLuotDangGui));
	lblLuotzz.setFont(font1);
	lblLuot1zz.setFont(font1);
	lblLuot1zz.setForeground(Color.RED);
	pnLuotzz.add(lblLuotzz);
	pnLuotzz.add(lblLuot1zz);
	
	JPanel pnThangzz = new JPanel();
	pnThangzz.setLayout(new FlowLayout(FlowLayout.RIGHT));
	JLabel lblThangzz = new JLabel("Đang gửi: ");
	lblThang1zz = new JLabel(String.valueOf(SoXeThangDangGui));
	lblThangzz.setFont(font1);
	lblThang1zz.setFont(font1);
	lblThang1zz.setForeground(Color.RED);
	pnThangzz.add(lblThangzz);
	pnThangzz.add(lblThang1zz);
//	JPanel pnCuDanz = new JPanel();
//	pnCuDanz.setLayout(new FlowLayout(FlowLayout.RIGHT));
//	JLabel lblCuDan1z = new JLabel("Còn trống: ");
//	JLabel lblCudan1z = new JLabel("500");
//	lblCuDan1z.setFont(font1);
//	lblCudan1z.setFont(font1);
//	pnCuDanz.add(lblCuDan1z);
//	pnCuDanz.add(lblCudan1z);
	
	//pnTimKiem
		JPanel pnTimKiem11 = new JPanel();
		pnTimKiem11.setLayout(new FlowLayout());
		JLabel lblTimKiem11 = new JLabel("Tìm Kiếm lịch sử (Theo biển Số)");
		pnTimKiem11.add(lblTimKiem11);
		txtTimKiem11 = new JTextField(40);
		pnTimKiem11.add(txtTimKiem11);
		btnTimKiem11 = new JButton("Tìm");
		btnTimKiem11.setIcon(new ImageIcon("hinh/search-icon.png"));
		pnTimKiem11.add(btnTimKiem11);
		
		// pnReFresh
		JPanel pnReFresh = new JPanel();
		pnReFresh.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		btnReFreshLichSu = new JButton("Refresh");
		pnReFresh.add(btnReFreshLichSu);
		
	//pnDoanhThu
		JPanel pnDoanhThu = new JPanel();
		pnDoanhThu.setLayout(new BoxLayout(pnDoanhThu, BoxLayout.Y_AXIS));
		JPanel pnTienThang = new JPanel();
		pnTienThang.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnDoanhThu.add(pnTienThang);
		JLabel lblTienVeThang = new JLabel("Tổng Tiền Vé Tháng: ");
		lblTienVeThang1 = new JLabel(TienThang1);
		pnTienThang.add(lblTienVeThang);
		pnTienThang.add(lblTienVeThang1);
		lblTienVeThang1.setForeground(Color.RED);
		
		JPanel pnTienLuot = new JPanel();
		pnTienLuot.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnDoanhThu.add(pnTienLuot);
		JLabel lblTienLuot = new JLabel("Tổng Tiền Vé Lượt Theo Tháng: ");
		 lblTienLuot1 = new JLabel(TienLuot1);
		pnTienLuot.add(lblTienLuot);
		pnTienLuot.add(lblTienLuot1);
		lblTienLuot1.setForeground(Color.RED);
		
		JPanel pnTongtien = new JPanel();
		pnTongtien.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnDoanhThu.add(pnTongtien);
		JLabel lblTongtien = new JLabel("Tổng Doanh Thu Tháng: ");
		 lblTongtien1 = new JLabel(TongTienS1);
		pnTongtien.add(lblTongtien);
		pnTongtien.add(lblTongtien1);
		lblTongtien1.setForeground(Color.RED);
		
		lblTienVeThang.setFont(font1);
		lblTienVeThang1.setFont(font1);
		lblTienLuot.setFont(font1);
		lblTienLuot1.setFont(font1);
		lblTongtien.setFont(font1);
		lblTongtien1.setFont(font1);
		
		lblTienVeThang.setPreferredSize(lblTienLuot.getPreferredSize());
		lblTongtien.setPreferredSize(lblTienLuot.getPreferredSize());
		
	pnTong.add(pnThongTinNhaXe);
	pnTong.add(pnTimKiem11);
	pnThongTinNhaXe.add(pnThongTinNhaXe1);
	pnThongTinNhaXe.add(pnThongTinNhaXe2);
	pnThongTinNhaXe.add(pnThongTinNhaXe3);
	pnTong.add(pnBangLSTong);
	pnTong.add(pnReFresh);
	pnTong.add(pnDoanhThu);
	pnThongTinNhaXe1.add(pnLuot);
	pnThongTinNhaXe1.add(pnThang);
//	pnThongTinNhaXe1.add(pnCuDan);
	pnThongTinNhaXe2.add(pnLuotz);
	pnThongTinNhaXe2.add(pnThangz);
//	pnThongTinNhaXe2.add(pnCuDanz);
	pnThongTinNhaXe3.add(pnLuotzz);
	pnThongTinNhaXe3.add(pnThangzz);
	
	lblLuot.setPreferredSize(lblThang.getPreferredSize());
	lblLuotz.setPreferredSize(lblThangz.getPreferredSize());

	
	//Xét màu nền-------------------------------------------------=------------------------------
	// Màu Xanh lá cây ==========================================================================
	pnVeLuot.setBackground(Color.GREEN);
	pnLuot.setBackground(Color.GREEN);
	pnThang.setBackground(Color.GREEN);
	pnLuotz.setBackground(Color.GREEN);
	pnThangz.setBackground(Color.GREEN);
	pnThongTinNhaXe.setBackground(Color.GREEN);
	pnTabGuiXe.setBackground(Color.GREEN);
	pnGui.setBackground(Color.GREEN);
	pnNguoiKhongTrongTrungCu.setBackground(Color.GREEN);
	pnNguoiTrongTrungCu.setBackground(Color.GREEN);
	pnVeXeTrong.setBackground(Color.GREEN);
	pnVeXeTrong1.setBackground(Color.GREEN);
	pnThemTrong.setBackground(Color.GREEN);
	pnThemTrong1.setBackground(Color.GREEN);
	pnSuaTrong.setBackground(Color.GREEN);
	pnXoaTrong.setBackground(Color.GREEN);
	pnRefresh.setBackground(Color.GREEN);
	pnSuaTrong1.setBackground(Color.GREEN);
	pnXoaTrong1.setBackground(Color.GREEN);
	pnRefresh1.setBackground(Color.GREEN);
	pnTimKiem.setBackground(Color.GREEN);
	pnTimKiem1.setBackground(Color.GREEN);
	pnTimKiem11.setBackground(Color.GREEN);
	pnBang.setBackground(Color.GREEN);
	pnButtonTrong.setBackground(Color.GREEN);
	pnButtonTrong1.setBackground(Color.GREEN);
	pnVeThang.setBackground(Color.GREEN);
	pnQuanLyVeCuDan.setBackground(Color.GREEN);
	pnLay.setBackground(Color.GREEN);
	pnVeThang1.setBackground(Color.GREEN);
	pnTong.setBackground(Color.GREEN);
	pnaa.setBackground(Color.GREEN);
	pna.setBackground(Color.GREEN);
	pnLuotzz.setBackground(Color.GREEN);
	pnThangzz.setBackground(Color.GREEN);
	pnReFresh.setBackground(Color.GREEN);
	pnDoanhThu.setBackground(Color.GREEN);
	pnTienLuot.setBackground(Color.GREEN);
	pnTienThang.setBackground(Color.GREEN);
	pnTongtien.setBackground(Color.GREEN);
	
	// Màu oXanh Da Trời ==========================================================================
//		pnVeLuot.setBackground(Color.BLUE);
//		pnLuot.setBackground(Color.BLUE);
//		pnThang.setBackground(Color.BLUE);
//		pnLuotz.setBackground(Color.BLUE);
//		pnThangz.setBackground(Color.BLUE);
//		pnThongTinNhaXe.setBackground(Color.BLUE);
//		pnTabGuiXe.setBackground(Color.BLUE);
//		pnGui.setBackground(Color.BLUE);
//		pnNguoiKhongTrongTrungCu.setBackground(Color.BLUE);
//		pnNguoiTrongTrungCu.setBackground(Color.BLUE);
//		pnVeXeTrong.setBackground(Color.BLUE);
//		pnVeXeTrong1.setBackground(Color.BLUE);
//		pnThemTrong.setBackground(Color.BLUE);
//		pnThemTrong1.setBackground(Color.BLUE);
//		pnSuaTrong.setBackground(Color.BLUE);
//		pnXoaTrong.setBackground(Color.BLUE);
//		pnRefresh.setBackground(Color.BLUE);
//		pnSuaTrong1.setBackground(Color.BLUE);
//		pnXoaTrong1.setBackground(Color.BLUE);
//		pnRefresh1.setBackground(Color.BLUE);
//		pnTimKiem.setBackground(Color.BLUE);
//		pnTimKiem1.setBackground(Color.BLUE);
//		pnBang.setBackground(Color.BLUE);
//		pnButtonTrong.setBackground(Color.BLUE);
//		pnButtonTrong1.setBackground(Color.BLUE);
//		pnVeThang.setBackground(Color.BLUE);
//		pnQuanLyVeCuDan.setBackground(Color.BLUE);
//		pnLay.setBackground(Color.BLUE);
//		pnVeThang1.setBackground(Color.BLUE);
//		pnTong.setBackground(Color.BLUE);
//		pnaa.setBackground(Color.BLUE);
//		pna.setBackground(Color.BLUE);
	
	
	
	//Add controls---------------------------------------------
	con.add(tab);

	tab.add(pnTabGuiXe,"Quản lý ra vào");
	tab.add(pnVeThang,"Đăng Ký vé tháng");
	tab.add(pnQuanLyVeCuDan,"Quản lý vé cư dân");
	tab.add(pnTong,"Thông Tin Nhà Xe");
	
	
	pnVeThang.add(lblDangKy);
	pnVeThang.add(pnNguoiTrongTrungCu);
	pnQuanLyVeCuDan.add(lblQuanLyVeCuDan);
	pnQuanLyVeCuDan.add(pnNguoiKhongTrongTrungCu);

	pnNguoiTrongTrungCu.add(pnTimKiem);
	pnNguoiTrongTrungCu.add(pnBang);
	pnNguoiTrongTrungCu.add(pnButtonTrong);	
	pnBang.add(scTable,BorderLayout.CENTER);
	
	pnNguoiKhongTrongTrungCu.add(pnTimKiem1);
	pnNguoiKhongTrongTrungCu.add(pnBang1);
	pnNguoiKhongTrongTrungCu.add(pnButtonTrong1);	
	pnBang1.add(scTable1,BorderLayout.CENTER);
}

private void addEvents() {
	btnThemTrong.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			DaoDienBtnThem ui = new DaoDienBtnThem("Vé tháng");
			ui.showWindows();
			
			if ( DaoDienBtnThem.ketqua >0)
			{
				hienThiToanBoVeThang();
				TienVeThang = TienVeThang + 250000;
				TienThang = String.valueOf( TienVeThang);
				TienThang1 = TienThang +" VNĐ";
				lblTienVeThang1.setText(TienThang1);
				
				TongTien = TongTien + 250000;
				TongTienS = String.valueOf( TongTien);
				TongTienS1 = TongTienS +" VNĐ";
				lblTongtien1.setText(TongTienS1);
				
			}
			if ( DaoDienBtnThem.ketqua1 >0)
			{
				HienThiTrangThaiXe();
			}
		}
	
	});
	btnSuaTrong.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int row = tblVeXe.getSelectedRow();
			if (row == -1) return;
			String id = tblVeXe.getValueAt(row, 0)+"";
			DaoDienBtnThem ui = new DaoDienBtnThem("Sửa thông tin vé tháng");
			ui.idVeThangChon= id;
			ui.hienThiThongTinChiTiet();
			ui.showWindows();
			if ( DaoDienBtnThem.ketqua >0)
				hienThiToanBoVeThang();
			if ( DaoDienBtnThem.ketqua1 >0)
				HienThiTrangThaiXe();
	
		}
	});
	btnXoaTrong.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String bienSo = tblVeXe.getValueAt(tblVeXe.getSelectedRow(), 1)+"";
			try {
				String sql = "delete from vethang where bienso='"+bienSo+"'";
				statement = conn.createStatement();
				int x=statement.executeUpdate(sql);
				String sql1 = "delete from trangthai where bienso='"+bienSo+"'";
				int x1=statement.executeUpdate(sql1);
			}
			catch (Exception e1) {
				// TODO: handle exception
			}
			
				hienThiToanBoVeThang();
			
				HienThiTrangThaiXe();
			
		}
	});
	
	btnTimKiem.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String idTimkiem = txtTimKiem.getText();
			try {
				String sql = "select * from vethang where bienso = ?";
				java.sql.PreparedStatement prepe = conn.prepareStatement(sql);
				prepe.setString(1, idTimkiem);
				dtmVeXe.setRowCount(0);
				ResultSet result = prepe.executeQuery();
				while ( result.next())
				{
					Object [] arr = {result.getString(1), result.getString(2),
					result.getString(3),
					result.getString(4),
					result.getString(5),
					result.getDate(6),
					result.getDate(7) };
					dtmVeXe.addRow(arr);
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			txtTimKiem.setText("");
		}
	});
	
	btnRefesh.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			hienThiToanBoVeThang();
		}
	});
	btnThemTrong1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			DaoDienBtnThem1 ui = new DaoDienBtnThem1("Vé cư dân");
			ui.showWindows();
			if ( DaoDienBtnThem1.ketqua >0)
			{
				hienThiToanBoVeCuDan();
			}
				
			if ( DaoDienBtnThem1.ketqua1 >0)
			{
				HienThiTrangThaiXe();
			}
			
		}
	
	});
	btnSuaTrong1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int row = tblVeXe1.getSelectedRow();
			if (row == -1) return;
			String id = tblVeXe1.getValueAt(row, 0)+"";
			DaoDienBtnThem1 ui = new DaoDienBtnThem1("Sửa thông tin vé cư dân");
			ui.idVeThangChon= id;
			ui.hienThiThongTinChiTiet();
			ui.showWindows();
			if ( DaoDienBtnThem1.ketqua >0)
				hienThiToanBoVeCuDan();
			if ( DaoDienBtnThem1.ketqua1 >0)
				HienThiTrangThaiXe();
		}
	});
	btnXoaTrong1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String BienSo = tblVeXe1.getValueAt(tblVeXe1.getSelectedRow(), 1)+"";
			try {
				String sql = "delete from vecudan where bienso='"+BienSo+"'";
				statement = conn.createStatement();
				int x=statement.executeUpdate(sql);
				String sql1 = "delete from trangthai where bienso='"+BienSo+"'";
				int x1=statement.executeUpdate(sql1);
				if(x>0)
					hienThiToanBoVeCuDan();
				if(x1>0)
					HienThiTrangThaiXe();
				
			}
			catch (Exception e1) {
				// TODO: handle exception
			}
			
		}
	});
	
	btnTimKiem1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String idTimkiem = txtTimKiem1.getText();
			try {
				String sql = "select * from vecudan where bienso = ?";
				java.sql.PreparedStatement prepe = conn.prepareStatement(sql);
				prepe.setString(1, idTimkiem);
				dtmVeXe1.setRowCount(0);
				ResultSet result = prepe.executeQuery();
			//	if(result.next())
					//System.out.println(result.next());
				while ( result.next())
				{
					
					Object [] arr = {result.getString(1), 
					result.getString(2),
					result.getString(3),
					result.getString(4),
					result.getString(5),
					result.getString(6),
					result.getString(7) };
					dtmVeXe1.addRow(arr);
					//System.out.println(result.getString(2));
				}
	
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			txtTimKiem1.setText("");
			
		}
	});
	
	btnRefesh1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			hienThiToanBoVeCuDan();
		}
	});
	
	btnGui.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Calendar now = Calendar.getInstance();
	         int h = now.get(Calendar.HOUR_OF_DAY);
	         int m = now.get(Calendar.MINUTE);
	         int s = now.get(Calendar.SECOND);
	         // Lay ngay hien tai
	         long millis=System.currentTimeMillis();  
	         java.sql.Date date=new java.sql.Date(millis); 
	         String date1= date+"";
	         time1 = date1+"  " + h + ":" + m + ":" + s+"";
	         String BienSo = txtGuiXe.getText();
	         try {
	            
	        	String sql2="update trangthai set thoigianguixe=?,thoigianlayxe=?,trangthai=? where bienso=?";
				PreparedStatement preStatement2=(PreparedStatement) conn.prepareStatement(sql2);
				preStatement2.setString(1, time1);
				preStatement2.setString(2, "");
				preStatement2.setString(3, "Đang gửi");
				preStatement2.setString(4, BienSo);
				int x = preStatement2.executeUpdate();
				//System.out.println(ID);
		         if (x>0)
		         {
		        	 SoChoDeXeThang = SoChoDeXeThang -1 ;
		        	 XeThang =String.valueOf( SoChoDeXeThang);
		        	 lblThang1z.setText(XeThang); 
		        	 SoXeThangDangGui = SoXeThangDangGui +1;
		        	 xeThangdanggui =String.valueOf( SoXeThangDangGui);
		           	 lblThang1zz.setText(xeThangdanggui);

		           	String sql = "select * from trangthai where bienso = ?";
					java.sql.PreparedStatement prepe = conn.prepareStatement(sql);
					prepe.setString(1, BienSo);
					ResultSet result = prepe.executeQuery();
					String ID = "";
					while ( result.next())
					{	
						ID = result.getString(1);
					}	
		           	 
		        	String sql11="insert into lichsucudan values(?,?,?,?)";
			        preStatement2=(PreparedStatement) conn.prepareStatement(sql11);
			 		preStatement2.setString(1, ID);
			 		preStatement2.setString(2, BienSo);
			 		preStatement2.setString(3, time1);
			 		preStatement2.setString(4, "");
			 		int x1=preStatement2.executeUpdate();
			 		
		         }
		         else
		         {
		        	String sql1="insert into trangthai2 values(?,?,?,?)";
		        	preStatement2=(PreparedStatement) conn.prepareStatement(sql1);
		 			preStatement2.setString(1, BienSo);
		 			preStatement2.setString(2, time1);
		 			preStatement2.setString(3, "");
		 			preStatement2.setString(4, "Đang gửi");
		 			int x1=preStatement2.executeUpdate();
		 			SoChoDeXeLuot = SoChoDeXeLuot -1;
		 			XeLuot =String.valueOf( SoChoDeXeLuot);
		 		    lblLuot1z.setText(XeLuot);
		 		    
		 		    SoXeLuotDangGui = SoXeLuotDangGui +1;
		        	xeluotdanggui =String.valueOf( SoXeLuotDangGui);
		        	lblLuot1zz.setText(xeluotdanggui);
		        	
//		        	String sql0="insert into lichsukhachngay values(?,?,?)";
//		        	preStatement2=(PreparedStatement) conn.prepareStatement(sql0);
//		 			preStatement2.setString(1, BienSo);
//		 			preStatement2.setString(2, time1);
//		 			preStatement2.setString(3, "");
//		 			int x11=preStatement2.executeUpdate();
		         }
		     
			} catch (Exception e2) {
				// TODO: handle exception
			}
	     	HienThiTrangThaiXe();
	     	HienThiTrangThaiXeNgay();
	     	HienThiLichSuCuDan(); 
	     	HienThiLichSuKhachNgay();
	     	txtGuiXe.setText("");
		}
	});
	
	btnlay.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Calendar now = Calendar.getInstance();
	         int h = now.get(Calendar.HOUR_OF_DAY);
	         int m = now.get(Calendar.MINUTE);
	         int s = now.get(Calendar.SECOND);
	         
	         long millis=System.currentTimeMillis();  
	         java.sql.Date date2=new java.sql.Date(millis); 
	         String date22= date2+"";
	         
	         String time="";
	         time = date22+"  " + h + ":" + m + ":" + s+"";
	         String BienSo = txtLay.getText();
	         String timelay = "";
			 String timegui = "";
			 String ID ="";
	         try {
					String sql="update trangthai set thoigianlayxe=?,trangthai=? where bienso=?";
					PreparedStatement preStatement2=(PreparedStatement) conn.prepareStatement(sql);
					preStatement2.setString(1, time);
					preStatement2.setString(2, "Không Gửi");
					preStatement2.setString(3, BienSo);
					int x=preStatement2.executeUpdate();
					System.out.println(time);
					
				
			         if (x>0)
			         {
			        	 String sql1 = "select * from trangthai where bienso = ?";
							java.sql.PreparedStatement prepe = conn.prepareStatement(sql1);
							prepe.setString(1, BienSo);
							ResultSet result = prepe.executeQuery();
							while ( result.next())
							{	
								ID= result.getString(1);
								timegui = result.getString(3);
								timelay = result.getString(4);
							}
							
			        	 String sql12="update lichsucudan set thoigianlayxe=? where thoigianguixe=?";
			        	  PreparedStatement preStatement22=(PreparedStatement) conn.prepareStatement(sql12);
							preStatement22.setString(1, timelay);
							preStatement22.setString(2, timegui);
							preStatement22.executeUpdate();

			        	 SoChoDeXeThang = SoChoDeXeThang +1 ;
			        	 XeThang =String.valueOf( SoChoDeXeThang);
			        	 lblThang1z.setText(XeThang);
			        	 
			        	 SoXeThangDangGui = SoXeThangDangGui - 1;
			        	 xeThangdanggui =String.valueOf( SoXeThangDangGui);
			           	 lblThang1zz.setText(xeThangdanggui);
			        	 
			        	
			         }
			         else
			         {
			        	 String sq = "select * from trangthai2 where bienso = ?";
							java.sql.PreparedStatement prep = conn.prepareStatement(sq);
							prep.setString(1, BienSo);
							ResultSet resul = prep.executeQuery();
							while ( resul.next())
							{	
					
								timegui = resul.getString(2);
								
							}
							
			        	String sql11 = "delete from trangthai2 where bienso='"+BienSo+"'";
						statement = conn.createStatement();
						int x11=statement.executeUpdate(sql11);
						HienThiTrangThaiXeNgay();
						
						SoChoDeXeLuot = SoChoDeXeLuot +1;
			 			XeLuot =String.valueOf( SoChoDeXeLuot);
			 			lblLuot1z.setText(XeLuot);
			 			
			 			SoXeLuotDangGui = SoXeLuotDangGui -1;
				        xeluotdanggui =String.valueOf( SoXeLuotDangGui);
				        lblLuot1zz.setText(xeluotdanggui);
			 		   
				      
//						
//				    	String sql0="update lichsukhachngay set thoigianlayxe=? where thoigianguixe=?";
//			        	preStatement2=(PreparedStatement) conn.prepareStatement(sql0);
//			 			preStatement2.setString(1, time);
//			 			preStatement2.setString(2, timegui);
//			 			preStatement2.executeUpdate();
				        
			        	String sql0="insert into lichsukhachngay values(?,?,?)";
			        	preStatement2=(PreparedStatement) conn.prepareStatement(sql0);
			 			preStatement2.setString(1, BienSo);
			 			preStatement2.setString(2, timegui);
			 			preStatement2.setString(3, time );
			 			int x111=preStatement2.executeUpdate();
			 			
			 			TienVeLuot = TienVeLuot + 20000;
			 			TienLuot = String.valueOf( TienVeLuot);
			 			TienLuot1 = TienLuot +" VNĐ";
						lblTienLuot1.setText(TienLuot1);
						
						TongTien = TongTien + 20000;
						TongTienS = String.valueOf( TongTien);
						TongTienS1 = TongTienS +" VNĐ";
						lblTongtien1.setText(TongTienS1);
			         }
			     
				} catch (Exception e2) {
					// TODO: handle exception
				}
		     	HienThiTrangThaiXe();
		     	HienThiTrangThaiXeNgay();
		     	HienThiLichSuCuDan();
		     	HienThiLichSuKhachNgay();
		     	txtLay.setText("");
		}
	});
		
	btnTimKiem11.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			BienSo = txtTimKiem11.getText();
			
			try {
				String sql = "select * from lichsucudan where bienso = ?";
				java.sql.PreparedStatement prepe = conn.prepareStatement(sql);
				prepe.setString(1, BienSo);
				dtmLichSuCuDan.setRowCount(0);
				ResultSet result = prepe.executeQuery();
			//	if(result.next())
					//System.out.println(result.next());
				while ( result.next())
				{
					
					Object [] arr = {result.getString(1), 
					result.getString(2),
					result.getString(3),
					result.getString(4)
					};
					dtmLichSuCuDan.addRow(arr);
					//System.out.println(result.getString(2));
				}

				String sql1 = "select * from lichsukhachngay where bienso = ?";
				prepe = conn.prepareStatement(sql1);
				prepe.setString(1, BienSo);
				dtmLichSuKhachNgay.setRowCount(0);
				result = prepe.executeQuery();
			//	if(result.next())
					//System.out.println(result.next());
				while ( result.next())
				{
					
					Object [] arr = {result.getString(1), 
					result.getString(2),
					result.getString(3)
					};
					dtmLichSuKhachNgay.addRow(arr);
					//System.out.println(result.getString(2));
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			txtTimKiem11.setText("");
		}
	});
	btnReFreshLichSu.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			HienThiLichSuCuDan();
			HienThiLichSuKhachNgay();
		}
	});
}
public void showWindow()
{
	this.setSize(800,600);
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	this.setLocationRelativeTo(null);
	this.setVisible(true);
	
}
}
