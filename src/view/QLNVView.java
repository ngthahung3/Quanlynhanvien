package view;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.QLNVcontroller;
import model.NhanVien;
import model.QLNV;

public class QLNVView extends JFrame {

	private JPanel contentPane;
	public QLNV model;
	public JTable table;
	public Label label_thongTin;
	public Label label_timTenNV;
	public TextField textField_tenNV;
	public TextField textField_tuoi;
	public TextField textField_email;
	public TextField textField_password;
	public JComboBox comboBox_gioiTinh;
	public TextField textField_salary;
	public TextField textField_maNV;
	private JComboBox comboBox_timgioiTinh;
	public TextField textField_timTuoi;
	public TextField textField_timTen;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					QLNVView frame = new QLNVView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public QLNVView() {
		this.model = new QLNV();
		String gioitinh[] = {"Nam","Nữ","Other"};
		
		ActionListener action = new QLNVcontroller(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label_DSNV = new Label("Danh sách nhân viên");
		label_DSNV.setBounds(31, 83, 130, 23);
		contentPane.add(label_DSNV);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã NV", "Tên", "Tuổi", "Giới Tính", "Email", "Mật khẩu", "Lương"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(31, 112, 580, 132);
		contentPane.add(scrollPane);
		
		label_thongTin = new Label("Thông tin nhân viên");
		label_thongTin.setBounds(78, 250, 130, 23);
		contentPane.add(label_thongTin);
		
		label_timTenNV = new Label("Tên");
		label_timTenNV.setBounds(107, 28, 38, 23);
		contentPane.add(label_timTenNV);
		
		textField_timTen = new TextField();
		textField_timTen.setBounds(143, 28, 123, 23);
		contentPane.add(textField_timTen);
		
		Label label_timTuoi = new Label("Tuổi");
		label_timTuoi.setBounds(107, 54, 29, 23);
		contentPane.add(label_timTuoi);
		
		textField_timTuoi = new TextField();
		textField_timTuoi.setBounds(143, 57, 101, 23);
		contentPane.add(textField_timTuoi);
		
		Label label_timGioiTinh = new Label("Giới Tính");
		label_timGioiTinh.setBounds(298, 28, 56, 23);
		contentPane.add(label_timGioiTinh);
		
		comboBox_timgioiTinh = new JComboBox(gioitinh);
		comboBox_timgioiTinh.setBounds(360, 28, 101, 23);
		contentPane.add(comboBox_timgioiTinh);
		
		Label label_tenNV = new Label("Tên");
		label_tenNV.setBounds(78, 309, 38, 23);
		contentPane.add(label_tenNV);
		
		textField_tenNV = new TextField();
		textField_tenNV.setBounds(122, 309, 123, 23);
		contentPane.add(textField_tenNV);
		
		Label label_timTuoi_1 = new Label("Tuổi");
		label_timTuoi_1.setBounds(78, 338, 38, 23);
		contentPane.add(label_timTuoi_1);
		
		textField_tuoi = new TextField();
		textField_tuoi.setBounds(122, 338, 123, 23);
		contentPane.add(textField_tuoi);
		
		Label label_gioiTinh = new Label("Giới Tính");
		label_gioiTinh.setBounds(78, 367, 56, 23);
		contentPane.add(label_gioiTinh);
		
		comboBox_gioiTinh = new JComboBox(gioitinh);
		comboBox_gioiTinh.setBounds(140, 367, 105, 23);
		contentPane.add(comboBox_gioiTinh);
		
		Label label_email = new Label("Email");
		label_email.setBounds(305, 309, 38, 23);
		contentPane.add(label_email);
		
		textField_email = new TextField();
		textField_email.setBounds(349, 309, 123, 23);
		contentPane.add(textField_email);
		
		Label label_password = new Label("Password");
		label_password.setBounds(286, 338, 57, 23);
		contentPane.add(label_password);
		
		textField_password = new TextField();
		textField_password.setBounds(349, 338, 123, 23);
		contentPane.add(textField_password);
		
		Button button_Search = new Button("Tìm kiếm");
		button_Search.addActionListener(action);
		button_Search.setBounds(485, 28, 76, 23);
		contentPane.add(button_Search);
		
		Button button_insert = new Button("Thêm");
		button_insert.addActionListener(action);
		button_insert.setBounds(510, 290, 76, 23);
		contentPane.add(button_insert);
		
		Button button_edit = new Button("Sửa");
		button_edit.addActionListener(action);
		button_edit.setBounds(510, 319, 76, 23);
		contentPane.add(button_edit);
		
		Button button_delete = new Button("Xóa");
		button_delete.addActionListener(action);
		button_delete.setBounds(510, 348, 76, 23);
		contentPane.add(button_delete);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 633, 22);
		contentPane.add(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuFile.add(menuOpen);
		
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(action);
		menuFile.add(menuSave);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuClose = new JMenuItem("Close");
		menuClose.addActionListener(action);
		menuFile.add(menuClose);
		
		Label label_password_1 = new Label("Salary");
		label_password_1.setBounds(286, 367, 57, 23);
		contentPane.add(label_password_1);
		
		textField_salary = new TextField();
		textField_salary.setBounds(349, 367, 123, 23);
		contentPane.add(textField_salary);
		
		Button button_save = new Button("Lưu");
		button_save.addActionListener(action);;
		button_save.setBounds(510, 378, 76, 23);
		contentPane.add(button_save);
		
		Label label_maNV = new Label("Mã NV");
		label_maNV.setBounds(78, 280, 38, 23);
		contentPane.add(label_maNV);
		
		textField_maNV = new TextField();
		textField_maNV.setBounds(122, 280, 123, 23);
		contentPane.add(textField_maNV);
		
		Button button_Clear = new Button("Clear");
		button_Clear.setBounds(485, 54, 76, 23);
		contentPane.add(button_Clear);
		
		this.setVisible(true);
	}

	public void xoaForm() {
		textField_maNV.setText("");
		textField_tenNV.setText("");
		textField_email.setText("");	
		textField_password.setText("");
		textField_tuoi.setText("");
		comboBox_gioiTinh.setSelectedIndex(-1);
		textField_salary.setText("0");
	}

	public void themNhanVienVaoTable(NhanVien nv) {
		DefaultTableModel model_tb = (DefaultTableModel) table.getModel();
		model_tb.addRow(new Object[] {
				nv.getMaNV()+"",
				nv.getName()+"",
				nv.getPassword()+"",
				nv.getAge()+"", 
				nv.getGender()+"", 
				nv.getEmail()+"",
				nv.getSalary()+""
			});
	}
	
	public void themOrCapNhatNhanVien(NhanVien nv) {
		DefaultTableModel model_tb = (DefaultTableModel) table.getModel();
		if(!this.model.kiemTraTonTai(nv)) {
			this.model.insert(nv);
			this.themNhanVienVaoTable(nv);
		}else{
			this.model.update(nv);
			int row_s = model_tb.getRowCount();
			for(int i = 0; i < row_s; i++) {
				String id = model_tb.getValueAt(i, 0)+"";
				if(id.equals(nv.getMaNV()+"")) {
					model_tb.setValueAt(nv.getMaNV()+"", i, 0);
					model_tb.setValueAt(nv.getName()+"", i, 1);
					model_tb.setValueAt(nv.getAge()+"", i, 2);
					model_tb.setValueAt(nv.getGender()+"", i, 3);
					model_tb.setValueAt(nv.getEmail()+"", i, 4);
					model_tb.setValueAt(nv.getPassword()+"", i, 5);
					model_tb.setValueAt(nv.getSalary()+"", i, 6);
				}
			}
		}
		
	}
	public NhanVien getNhanVien() {
		DefaultTableModel model_tb = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		
		String mnv = model_tb.getValueAt(i_row, 0)+"";
		String name = model_tb.getValueAt(i_row, 1)+"";
		String age = model_tb.getValueAt(i_row, 5)+"";
		String gender = model_tb.getValueAt(i_row, 2)+"";
		String email = model_tb.getValueAt(i_row, 3)+"";
		String password = model_tb.getValueAt(i_row, 4)+"";
		String salary = model_tb.getValueAt(i_row, 6)+"";
		
		NhanVien nv = new NhanVien(mnv, name, age, gender, email, password, salary);
		return nv;
	}

	public void hienthiNhanVien() {
		NhanVien nv = getNhanVien();
		
		this.textField_maNV.setText(nv.getMaNV()+"");
		this.textField_tenNV.setText(nv.getName()+"");
		this.textField_tuoi.setText(nv.getAge()+"");
		this.comboBox_gioiTinh.setSelectedItem(nv.getGender()+"");
		this.textField_email.setText(nv.getEmail()+"");
		this.textField_password.setText(nv.getPassword()+"");
		this.textField_salary.setText(nv.getSalary()+"");
	}

	public void xoaNhanVien() {
		DefaultTableModel model_tb = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa thông tin đã chọn?");
		if(choice == JOptionPane.YES_OPTION) {
			NhanVien nv = getNhanVien();
			this.model.delete(nv);
			model_tb.removeRow(i_row);
		}
	}

	public void themNhanVien() {
		String mnv = this.textField_maNV.getText()+"";
		String name = this.textField_tenNV.getText()+"";
		String age = this.textField_tuoi.getText()+"";
		String gender = this.comboBox_gioiTinh.getSelectedItem() +"";
		String email = this.textField_email.getText()+"";
		String password = this.textField_password.getText()+"";
		String salary = this.textField_salary.getText()+"";
			
		NhanVien nv = new NhanVien(mnv, name, age, gender, email, password, salary);
		this.themOrCapNhatNhanVien(nv);
		
	}

	public void timkiemNV() {
		taiLaiDuLieu();
		int gioiTinh = this.comboBox_timgioiTinh.getSelectedIndex()-1;
		String tim_tenNV = this.textField_timTen.getText();
		DefaultTableModel model_tb = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		
		Set<String> xoaNhanVien = new TreeSet<String>();
		if(gioiTinh >= 0) {
			for(int i = 0; i<i_row;i++) {
				String maNV = model_tb.getValueAt(i_row, 0)+"";
				String tagGioiTinh = model_tb.getValueAt(i, 3)+"";
				if(!tagGioiTinh.equals("Nam")) {
					xoaNhanVien.add(maNV);
				}else if(!tagGioiTinh.equals("Nữ")) {
					xoaNhanVien.add(maNV);
				}
			}
		}
		if(tim_tenNV.length()>0) {
			for(int i = 0; i<i_row;i++) {
				String maNV = model_tb.getValueAt(i_row, 0)+"";
				String tenNVTim = model_tb.getValueAt(i, 1)+"";
				if(!tenNVTim.equals(tim_tenNV)) {
					xoaNhanVien.add(maNV);
				}
			}
		}
		for (String maNV : xoaNhanVien) {
			System.out.println(maNV);
			i_row = model_tb.getRowCount();
			for(int i=0;i<i_row;i++) {
				String maNVTable = model_tb.getValueAt(i_row, 0)+"";
				if(maNVTable.equals(maNV.toString())) {
					try {
						model_tb.removeRow(i);
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}
	
	public void taiLaiDuLieu() {
		while(true) {
			DefaultTableModel model_tb = (DefaultTableModel) table.getModel();
			int i_row = model_tb.getRowCount();
			if(i_row == 0) {
				break;
			}else {
				try {
					model_tb.removeRow(0);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		for(NhanVien nv : this.model.getDsNhanVien()) {
			this.themOrCapNhatNhanVien(nv);
		}
	}

	public void dongForm() {
		int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát khỏi chương trình?",
				"Exit", JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.YES_NO_OPTION) {
			System.exit(0);
		}
		
	}

	public void openFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			moFile(file);
			taiLaiDuLieu();
		}
	}
	
	public void moFile(File file) {
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
//			NhanVien nv = null;
			while (true) {
	            try {
	                NhanVien nv = (NhanVien) ois.readObject();
	                ds.add(nv);
	            } catch (EOFException e) {
	                break; // Kết thúc file, thoát khỏi vòng lặp
	            }
	        }
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsNhanVien(ds);
	}

	public void luuFile(String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(NhanVien nv : this.model.getDsNhanVien()) {
				oos.writeObject(nv);
			}
			oos.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void saveFile() {
		if(this.model.getTenFile().length()>0) {
			luuFile(this.model.getTenFile());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				luuFile(file.getAbsolutePath());
			}
		}
	}
}
