package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.QLNVView;

public class QLNVcontroller implements ActionListener{
	public QLNVView view;
	
	
	public QLNVcontroller(QLNVView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
//		JOptionPane.showConfirmDialog(view, "Bạn vừa nhấn vào "+ cm);
		if(cm.equals("Thêm")) {
			this.view.xoaForm();
			this.view.model.setChoice("Thêm");
		}
		else if(cm.equals("Lưu")) {
			try {
				this.view.themNhanVien();
			} catch (Exception e2) {
				e2.printStackTrace();
			}	
		}else if(cm.equals("Sửa")) {
			this.view.hienthiNhanVien();
		}else if(cm.equals("Xóa")) {
			this.view.xoaNhanVien();
		}else if(cm.equals("Tìm")) {
			this.view.timkiemNV();
		}else if(cm.equals("Clear")) {
			this.view.taiLaiDuLieu();
		}else if(cm.equals("Open")) {
			this.view.openFile();
		}else if(cm.equals("Save")) {
			this.view.saveFile();
		}else if(cm.equals("Close")) {
			this.view.dongForm();
		}
			
	}

}
