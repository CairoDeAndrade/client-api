package com.devsuperior.bds04.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.services.CityService;

@RestController
public class CityController {
	
	@Autowired
	private CityService service;
	
	@PostMapping
	public ResponseEntity<CityDTO> insert(@RequestBody CityDTO cityDto) {
		cityDto = service.insert(cityDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(cityDto.getId()).toUri();
		return ResponseEntity.created(uri).body(cityDto);
	}
}
