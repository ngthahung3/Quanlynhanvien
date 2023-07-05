package model;

import java.io.Serializable;

public class Admin implements Serializable{
	private String username;
	private String password;
	private String email;
	private String name = "admin";
	
	private static final long serialVersionUID = 1;

	public Admin(String username, String password, String email, String name) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
	}
	
	public Admin(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + ", email=" + email + ", name=" + name + "]";
	}
	
	
}