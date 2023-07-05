package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoginView;

public class LoginController implements ActionListener{
	public LoginView view;
	
	public LoginController(LoginView view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if(cm.equals("Đăng nhập")) {
			this.view.loginIn();
		}else if(cm.equals("Hủy")) {
			this.view.dongForm();
		}
	}
	
}
