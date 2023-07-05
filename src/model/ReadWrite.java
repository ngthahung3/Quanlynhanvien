package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadWrite {
	public static void writeNV(String path, List<NhanVien> nhanvien) {
		try {
			FileOutputStream fos = new FileOutputStream(path, false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(nhanvien);
            oos.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<NhanVien> readNV(String path){
		ArrayList<NhanVien> nhanvien = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            nhanvien = (ArrayList<NhanVien>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println("Không tìm thấy file hoặc file rỗng");
        }
        return nhanvien;
	}
}
