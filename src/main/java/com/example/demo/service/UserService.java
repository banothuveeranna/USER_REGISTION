package com.example.demo.service;

import java.util.Map;

import com.example.demo.dto.LoginFormDTO;
import com.example.demo.dto.RegisterFormDTO;
import com.example.demo.dto.ResetPwdFormDTO;
import com.example.demo.dto.UserDTO;

public interface UserService {

	public Map<Integer, String> getCountries();
	public Map<Integer, String> getStates(Integer countryId);
	public Map<Integer, String> getCities(Integer stateId);
	public boolean duplicateEmailCheck(String email);
	public boolean saveUser(RegisterFormDTO regFormDTO);
	public UserDTO login(LoginFormDTO loginFormDTO);
	public boolean resetPwd(ResetPwdFormDTO resetPwdFormDTO);
	
}
