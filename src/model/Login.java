package model;

import java.util.ArrayList;
import java.util.List;

public class Login {
	private static List<NhanVien> list = new ArrayList<>();
	private static NhanVien user;
	private static final String admin = "admin";
	
	public static List<NhanVien> getList() {
		return list;
	}
	
	public static void setList(List<NhanVien> list) {
		Login.list = list;
	}

	public static NhanVien getUser() {
		return user;
	}

	public static void setUser(NhanVien user) {
		Login.user = user;
	}
	
	public static String dangNhap(String username, String password) {
		if(username.equals(admin) && password.equals(admin)) {
            return "admin";
        }else{
            for (NhanVien nhanVien : list) {
                if (nhanVien.getName().equals(username) && nhanVien.getPassword().equals(password)) {
                    return "nhanvien";
                }
            }
        }
		return "";
	}
}
