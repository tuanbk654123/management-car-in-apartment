// author : Nguyễn Minh Tuấn--------------------------------------------------------------------------------
// KSTN-ĐTVT-K59 -------------------------------------------------------------------------------------------
// BKHN=====================================================================================================
package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DaoDienLichSuKhachThang extends JFrame {
	Connection conn=DaoDienChinhUI.conn;
	Statement statement=DaoDienChinhUI.statement;

	String Ten ="??????????????";
	String ID ="???????????????";
	String BienSo ="";
	DefaultTableModel dtmLichSu;
	JTable tblLichSuCuDan;
	public DaoDienLichSuKhachThang(String title)
	{
		this.setTitle(title);
		addControls();
		addEvents();
	}


	private void addControls() {
		// TODO Auto-generated method stub
		Container con = getContentPane();
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
		JPanel pnTong = new JPanel();
		pnTong.setLayout(new BoxLayout(pnTong, BoxLayout.Y_AXIS));
		JPanel pnLichSuRaVao = new JPanel();
		pnLichSuRaVao.setLayout(new FlowLayout());
		JLabel lblLichSuRaVao = new JLabel("LỊCH SỬ RA VÀO");
		pnLichSuRaVao.add(lblLichSuRaVao);
		con.add(pnLichSuRaVao);
		
		JPanel pnTen = new JPanel();
		pnTen.setLayout(new FlowLayout());
		JLabel lblTen = new JLabel("Tên Chủ Xe: ");
		JLabel lblTen2 = new JLabel(Ten);
		pnTen.add(lblTen);	
		pnTen.add(lblTen2);	
		con.add(pnTen);
		
		JPanel pnID = new JPanel();
		pnID.setLayout(new FlowLayout());
		JLabel lblID = new JLabel("ID: ");
		JLabel lblID2 = new JLabel(ID);
		pnID.add(lblID);	
		pnID.add(lblID2);	
		con.add(pnID);
		
		JPanel pnBienSo= new JPanel();
		pnTen.setLayout(new FlowLayout());
		JLabel lblBienSo  = new JLabel("Biển Số: ");
		JLabel lblBienSo2 = new JLabel(BienSo);
		pnBienSo.add(lblBienSo);	
		pnBienSo.add(lblBienSo2);	
		con.add(pnBienSo);
		
		lblID.setPreferredSize(lblBienSo.getPreferredSize());
		lblID.setPreferredSize(lblBienSo.getPreferredSize());
		
		lblID2.setPreferredSize(lblBienSo2.getPreferredSize());
		lblID2.setPreferredSize(lblBienSo2.getPreferredSize());
		
		//bang
		JPanel pnbanglichSu = new JPanel();
		pnbanglichSu.setLayout(new BorderLayout());
		dtmLichSu = new DefaultTableModel();
		dtmLichSu.addColumn("Thời Gian Vào");
		dtmLichSu.addColumn("Thời Gian Ra ");
	
		tblLichSuCuDan= new JTable(dtmLichSu);
		JScrollPane scLichSuCuDan = new JScrollPane(tblLichSuCuDan,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnbanglichSu.add(scLichSuCuDan);
		con.add(pnbanglichSu);
	}
	private void addEvents() {
		// TODO Auto-generated method stub
		
	}
	public void showWindow()
	{
		this.setSize(600,500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//this.setModal(true);
		this.setVisible(true);
	}
}
