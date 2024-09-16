package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginFormDTO;
import com.example.demo.dto.RegisterFormDTO;
import com.example.demo.dto.ResetPwdFormDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entities.CityEntity;
import com.example.demo.entities.CountyEntity;
import com.example.demo.entities.StateEntity;
import com.example.demo.entities.UserEntity;
import com.example.demo.repo.CityRepo;
import com.example.demo.repo.CountryRepo;
import com.example.demo.repo.StateRepo;
import com.example.demo.repo.UserRepo;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private CountryRepo countryRepo;
	@Autowired
	private StateRepo stateRepo;
	@Autowired
	private CityRepo cityRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private EmailService emailService;
	
	@Override
	public Map<Integer, String> getCountries() {
		
		Map<Integer, String> countryMap = new HashMap<>();
		List<CountyEntity> countriesList=countryRepo.findAll();
		
		countriesList.stream().forEach(c ->{
			countryMap.put(c.getCountryId(), c.getCountryName());
		});
		return countryMap;
	}

	@Override
	public Map<Integer, String> getStates(Integer countryId) {
		Map<Integer, String> stateMap = new HashMap<>();


		List<StateEntity> statesList = stateRepo.findByCountryId(countryId);
	
		
		statesList.forEach(s ->{
			stateMap.put(s.getStateId(), s.getStateName());
			
		});
		return stateMap;
	}

	@Override
	public Map<Integer, String> getCities(Integer stateId) {

		Map<Integer,String> citiesMap = new HashMap<>();
		List<CityEntity> citiesList = cityRepo.findByCityId(stateId);
		citiesList.forEach(c ->{
			citiesMap.put(c.getCityId(),c.getCityName());
		});
		return citiesMap;
	}

	@Override
	public boolean duplicateEmailCheck(String email) {
		UserEntity byEmail= userRepo.findByEmail(email);
		if(byEmail !=null) {
			return true;
			
		}else {
			return false;
		}
	}

	@Override
	public boolean saveUser(RegisterFormDTO regFormDTO) {


		UserEntity userEntity= new UserEntity();
		
		BeanUtils.copyProperties(regFormDTO, userEntity);
		CountyEntity country = countryRepo.findById(regFormDTO.getCountryId()).orElse(null);
		userEntity.setCountry(country);
		
		StateEntity state = stateRepo.findById(regFormDTO.getCityId()).orElse(null);
		userEntity.setState(state);
		
		CityEntity city = cityRepo.findById(regFormDTO.getCityId()).orElse(null);
		userEntity.setCity(city);
		
		String randomPwd = gererateRandomPwd();
		
		userEntity.setPwd(randomPwd);
		
		userEntity.setPwdUpdated("No");
		
		UserEntity savedUser = userRepo.save(userEntity);
		
		if (null != savedUser.getUserId()) {
			String subject =" Your Account Created";
			String body ="Yor Password To Login : " + randomPwd;
			String to = regFormDTO.getEmail();
			
			emailService.sendEmail(subject, body, to);
			return true;
		}
		
		
		
		return false;
	}

	@Override
	public UserDTO login(LoginFormDTO loginFormDTO) {
	 
	//UserEntity userEntity	= userRepo.findByEmailAndPwd(loginFormDTO.getEmail(), null);
		
		UserEntity userEntity	= userRepo.findByEmailAndPwd(loginFormDTO.getEmail(), loginFormDTO.getPwd());
		
		
	if(userEntity !=null) {
	UserDTO userDTO = new UserDTO();
	BeanUtils.copyProperties(userEntity, userDTO);
	return userDTO;
	}
		return null;
	}

	@Override
	public boolean resetPwd(ResetPwdFormDTO resetPwdDTO) {
		String email =  resetPwdDTO.getEmail();
		UserEntity entity = userRepo.findByEmail(email);
		entity.setPwd(resetPwdDTO.getNewPwd());
		entity.setPwdUpdated("Yes");
		userRepo.save(entity);
		
		return true;
	}

	
	private String gererateRandomPwd() {
		String upperCaseLetter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCaseLetter = "abcdefghijklmnopqrstuvwxyz";
		
		String alphabets = upperCaseLetter + lowerCaseLetter;
		
		Random random = new Random();
		
		StringBuffer generatedPwd = new StringBuffer();
		for(int i = 0; i<5 ; i++) {
			int randomIndex = random.nextInt(alphabets.length());
			generatedPwd.append(alphabets.charAt(randomIndex));
		}
		return generatedPwd.toString();
	}
	
}
