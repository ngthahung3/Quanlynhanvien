package model;

import java.util.ArrayList;

public class QLNV {
	private ArrayList<NhanVien> dsNhanVien;
	private String choice;
	private String tenFile;
	
	public QLNV() {
		this.dsNhanVien = new ArrayList<NhanVien>();
		this.choice = "";
		this.tenFile = "";
	}
	

	public String getChoice() {
		return choice;
	}


	public void setChoice(String choice) {
		this.choice = choice;
	}


	public QLNV(ArrayList<NhanVien> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}

	public ArrayList<NhanVien> getDsNhanVien() {
		return dsNhanVien;
	}

	public void setDsNhanVien(ArrayList<NhanVien> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}
	
	public void insert(NhanVien nhanVien) {
		this.dsNhanVien.add(nhanVien);
	}
	
	public void delete(NhanVien nhanVien) {
		this.dsNhanVien.remove(nhanVien);
	}
	
	public void update(NhanVien nhanVien) {
		this.dsNhanVien.remove(nhanVien);
		this.dsNhanVien.add(nhanVien);
	}


	public String getTenFile() {
		return tenFile;
	}


	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}


	public boolean kiemTraTonTai(NhanVien nv) {
		for(NhanVien nhanVien : dsNhanVien) {
			if(nhanVien.getMaNV() == nv.getMaNV()) {
				return true;
			}
		}
		return false;
	}
	
	public NhanVien findNhanVienByTaiKhoan(String userName) {
        for (NhanVien nv : dsNhanVien) {
            if (nv.getName().equals(userName)) {
                return nv;
            }
        }
        return null;
    } 
}
