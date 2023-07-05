package model;

import java.io.Serializable;

public class NhanVien implements Serializable{
	private String maNV;
	private String name;
	private String password;
	private String age;
	private String gender;
	private String email;
	private String salary;
	
	private static final long serialVersionUID = 1;
	
	public NhanVien(String maNV, String name, String password, String age, String gender, String email, String salary) {
		this.maNV = maNV;
		this.name = name;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.salary = salary;
	}

	public NhanVien() {
		this.maNV = maNV;
		this.name = name;
		this.password = password;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "NhanVien [username=" + name + ", password=" + password + ", age=" + age + ", gender=" + gender
				+ ", email=" + email + ", salary=" + salary +"]";
	}
	
	
}
