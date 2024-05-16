package com.music.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String userName;
	private String email;
	private String passWord;
	private String re_passWord;
	private String role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getRe_passWord() {
		return re_passWord;
	}
	public void setRe_passWord(String re_passWord) {
		this.re_passWord = re_passWord;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + ", passWord=" + passWord + ", re_passWord="
				+ re_passWord + "]";
	}
	public User(String userName, String email, String passWord, String re_passWord) {
		super();
		this.userName = userName;
		this.email = email;
		this.passWord = passWord;
		this.re_passWord = re_passWord;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

}
