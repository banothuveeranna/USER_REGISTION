package com.example.demo.entities;


import java.time.LocalDate;
import java.util.Locale.IsoCountryCode;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_master")
public class UserEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name ="user_id")
	private Integer userId;

@Column(name ="user_name")
	private String uname;

@Column(name ="email")
	private String email;

@Column(name ="pwd")
    private String pwd;

@Column(name ="pwd_Updated")
    private String pwdUpdated;

@Column(name ="phno")
    private Long phno;
    @ManyToOne
    @JoinColumn(name = "country_id")
    
    private CountyEntity country;
    @ManyToOne
    @JoinColumn(name = "state_id")
    private StateEntity state;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity city;
    
    @CreationTimestamp
    @Column(name = "create_date",updatable = false)
    private LocalDate createdDate;
    @UpdateTimestamp
    
    @Column(name = "updated_date",insertable = false)
    private LocalDate updatedDate;
    
	public Integer getUserId() {
		
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
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
	public Long getPhno() {
		return phno;
	}
	public void setPhno(Long phno) {
		this.phno = phno;
	}
	public CountyEntity getCountry() {
		return country;
	}
	public void setCountry(CountyEntity country) {
		this.country = country;
	}
	public StateEntity getState() {
		return state;
	}
	public void setState(StateEntity state) {
		this.state = state;
	}
	public CityEntity getCity() {
		return city;
	}
	public void setCity(CityEntity city) {
		this.city = city;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDate getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
    
    
}
