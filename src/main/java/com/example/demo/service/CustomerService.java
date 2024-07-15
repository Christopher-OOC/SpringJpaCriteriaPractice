package com.example.demo.service;

import com.example.demo.model.dto.CustomerDto;
import com.example.demo.model.dto.EventCeremonyDto;

public interface CustomerService {
	
	void save(CustomerDto customerDto);
	
	CustomerDto findByEmail(String email);
	
	CustomerDto findByCustomerId(String customerId);

	void postEventCeremony(String customerId, EventCeremonyDto dto, String ceremonyName);

}
