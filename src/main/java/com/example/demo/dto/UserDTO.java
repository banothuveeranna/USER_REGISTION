package com.example.demo.dto;

import jakarta.persistence.Column;

public class UserDTO {
	
	
	private Integer userId;


	private String email;


    private String pwd;


    private String pwdUpdated;


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getPwdUpdated() {
		return pwdUpdated;
	}


	public void setPwdUpdated(String pwdUpdated) {
		this.pwdUpdated = pwdUpdated;
	}


    
    
    
}
