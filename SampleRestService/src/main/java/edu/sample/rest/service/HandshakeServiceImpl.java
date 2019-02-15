package edu.sample.rest.service;

import org.springframework.stereotype.Service;

@Service
public class HandshakeServiceImpl implements HandshakeService {

	@Override
	public String hello(String clientName) {
		// TODO Auto-generated method stub
		return "Hello " + clientName + "!";
	}

}
