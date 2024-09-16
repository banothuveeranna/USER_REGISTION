package com.example.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.QuoteApiResponseDTO;

@Service
public class DashboardServiceImpl implements DashboardService{

	private String quoteApiURL = "https://dummyjson.com/quotes/random";
	
	@Override
	public QuoteApiResponseDTO getQuote() {
		
		RestTemplate rt= new RestTemplate();
		ResponseEntity<QuoteApiResponseDTO> forEntity=rt.getForEntity(quoteApiURL, QuoteApiResponseDTO.class);
		
		QuoteApiResponseDTO body = forEntity.getBody();
		
		return body;
	}
	
}
