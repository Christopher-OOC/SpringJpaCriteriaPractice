package com.example.demo.service;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.CateringServiceDto;
import com.example.demo.model.entity.CateringService;
import com.example.demo.model.entity.Customer;
import com.example.demo.repository.CateringServiceRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.utils.EntityCheckerUtils;
import com.example.demo.utils.PublicIdGeneratorUtils;

@Service
public class CateringServicesImpl implements CateringServices {
	
	private CustomerRepository customerRepository;
	
	private CateringServiceRepository cateringServiceRepository;
	
	private EntityCheckerUtils entityCheckerUtils;
	
	private ModelMapper modelMapper;
	
	public CateringServicesImpl(CustomerRepository customerRepository, EntityCheckerUtils entityCheckerUtils, 
			CateringServiceRepository cateringServiceRepository, ModelMapper modelMapper) {
		this.customerRepository = customerRepository;
		this.entityCheckerUtils = entityCheckerUtils;
		this.cateringServiceRepository = cateringServiceRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public void createCateringService(String customerId, CateringServiceDto cateringServiceDto) {
		
		Customer customer = entityCheckerUtils.checkIfCustomerExists(customerId);
		
		
		
		CateringService cateringService = modelMapper.map(cateringServiceDto, CateringService.class);
		cateringService.setCateringServiceId(customer.getCustomerId());
		cateringService.setDateRegistered(new Date());
		cateringService.setCustomer(customer);
		
		customer.setCateringService(cateringService);
		
		customerRepository.save(customer);
	}

}
