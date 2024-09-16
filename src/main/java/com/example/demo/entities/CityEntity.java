package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "city_master")
public class CityEntity {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "city_id")
private Integer cityId;

@Column(name = "city_name")
private String cityName;

@Column(name = "state_id")
private Integer stateId;

public Integer getCityId() {
	return cityId;
}

public void setCityId(Integer cityId) {
	this.cityId = cityId;
}

public String getCityName() {
	return cityName;
}

public void setCityName(String cityName) {
	this.cityName = cityName;
}

public Integer getStateId() {
	return stateId;
}

public void setStateId(Integer stateId) {
	this.stateId = stateId;
}

}
