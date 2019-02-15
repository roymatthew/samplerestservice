package edu.sample.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.sample.rest.service.HandshakeService;

@RestController
public class HandshakeController {
	
	@Autowired
	private HandshakeService service;
	
	@GetMapping(value="/hello/{clientName}")
	public String doHandshake(@PathVariable final String clientName)
	{
		return service.hello(clientName);
	}

}
