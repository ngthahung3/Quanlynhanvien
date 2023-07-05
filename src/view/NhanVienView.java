package view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.NhanVien;

public class NhanVienView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Tuoi;
	private JTextField textField_Email;
	private JTextField textField_Password;
	
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NhanVienView frame = new NhanVienView();
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
	public NhanVienView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên nhân viên:");
		lblNewLabel.setBounds(22, 24, 81, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblTenNV = new JLabel("Tên nhân viên:");
		lblTenNV.setBounds(115, 24, 101, 21);
		contentPane.add(lblTenNV);
		
		JLabel lblTuoi = new JLabel("Tuổi:");
		lblTuoi.setBounds(22, 71, 81, 21);
		contentPane.add(lblTuoi);
		
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setBounds(22, 113, 81, 21);
		contentPane.add(lblGioiTinh);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(22, 158, 81, 21);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Mật khẩu:");
		lblPassword.setBounds(22, 202, 81, 21);
		contentPane.add(lblPassword);
		
		textField_Tuoi = new JTextField();
		textField_Tuoi.setBounds(90, 70, 126, 21);
		contentPane.add(textField_Tuoi);
		textField_Tuoi.setColumns(10);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(90, 159, 126, 21);
		contentPane.add(textField_Email);
		
		textField_Password = new JTextField();
		textField_Password.setColumns(10);
		textField_Password.setBounds(90, 203, 126, 21);
		contentPane.add(textField_Password);
		
		JComboBox comboBox_Gioitinh = new JComboBox();
		comboBox_Gioitinh.setBounds(90, 112, 126, 22);
		contentPane.add(comboBox_Gioitinh);
		
		JButton btnButton_Submit = new JButton("Thay đổi");
		btnButton_Submit.setBounds(264, 88, 91, 36);
		contentPane.add(btnButton_Submit);
		
		JButton btnButton_Huy = new JButton("Hủy");
		btnButton_Huy.setBounds(264, 158, 91, 36);
		contentPane.add(btnButton_Huy);
	}
	
	NhanVien model = new NhanVien();
    NhanVienView view = new NhanVienView();
    
	private List<NhanVien> readFileData() {
		List<NhanVien> dsNhanVien = new ArrayList<>();

	    try (BufferedReader reader = new BufferedReader(new FileReader("デスクトップ/file.txt"))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] parts = line.split(",");
	            
	            String maNV = parts[0];
	            String name = parts[1];
	            String password = parts[2];
	            String age = parts[3];
	            String gender = parts[4];
	            String email = parts[5];
	            String salary = parts[6];

	            NhanVien nhanVien = new NhanVien(maNV, name, password, age, gender, email, salary);
	            dsNhanVien.add(nhanVien);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return dsNhanVien;
	}
    
}
