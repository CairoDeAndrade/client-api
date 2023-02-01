package com.cairo.dschallenge.resources;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cairo.dschallenge.entities.Client;
import com.cairo.dschallenge.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		List<Client> mockList = new ArrayList<>();
		mockList.add(new Client(null, "Alex Green", "25545696981", 5000.00, Instant.now(), 3));
		mockList.add(new Client(null, "Ben White", "56987598430", 3000.00, Instant.now(), 0));
		mockList.add(new Client(null, "Lara Gray", "25545696981", 7000.00, Instant.now(), 1));
		return ResponseEntity.ok().body(mockList);
	}
}
