package view;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.LoginController;
import model.Login;
import model.NhanVien;
import model.QLNV;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private static JTextField textField_Username;
	private static JTextField textField_Password;
	private static Component frame;
	private JButton btnLogin;
	private JButton btn_Close;
	
	private Login model;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public LoginView() {
		this.model = new Login();
		ActionListener action = new LoginController(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Tên đăng nhập:");
		lblUsername.setBounds(39, 46, 93, 24);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Mật khẩu:");
		lblPassword.setBounds(61, 98, 71, 24);
		contentPane.add(lblPassword);
		
		textField_Username = new JTextField();
		textField_Username.setBounds(144, 44, 135, 24);
		contentPane.add(textField_Username);
		textField_Username.setColumns(10);
		
		textField_Password = new JTextField();
		textField_Password.setColumns(10);
		textField_Password.setBounds(144, 99, 135, 24);
		contentPane.add(textField_Password);
		
		btnLogin = new JButton("Đăng nhập");
		btnLogin.addActionListener(action);
		btnLogin.setBounds(81, 158, 102, 38);
		contentPane.add(btnLogin);
		
		btn_Close = new JButton("Hủy");
		btn_Close.addActionListener(action);
		btn_Close.setBounds(229, 158, 91, 38);
		contentPane.add(btn_Close);
		this.setVisible(true);
	}

	public void loginIn() {
		String username = textField_Username.getText();
		String password = textField_Password.getText();
		
		String login = Login.dangNhap(username, password);
		if (!login.isEmpty()) {
			setVisible(false);
            openForm(login);
        } else {
            JOptionPane.showMessageDialog(LoginView.this, "Đăng nhập không thành công. Vui lòng thử lại.");
        }
	}


	public static void openForm(String login) {
		try {
			if(login.equals("admin")) {
				QLNVView frame = new QLNVView();
				frame.setVisible(true);
			}else {
                QLNV model = new QLNV();
                List<NhanVien> listNhanVien = model.getDsNhanVien();
                NhanVien nhanVien = model.findNhanVienByTaiKhoan(login);
                if (nhanVien != null && nhanVien.getPassword().equals(login)) {
                    showThongTinNhanVien(nhanVien);
                } else {
                    JOptionPane.showMessageDialog(frame, "Tài khoản hoặc mật khẩu không đúng!", "Lỗi",
                            JOptionPane.ERROR_MESSAGE);
                }
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void showThongTinNhanVien(NhanVien nhanVien) {
		NhanVienView frame = new NhanVienView();
		frame.setVisible(true);
		
	}

	public void dongForm() {
		
		int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát khỏi chương trình?",
				"Exit", JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.YES_NO_OPTION) {
			System.exit(0);
		}
	}

	
		
}
