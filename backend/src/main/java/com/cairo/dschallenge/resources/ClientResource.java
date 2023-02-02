package com.cairo.dschallenge.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cairo.dschallenge.dto.ClientDTO;
import com.cairo.dschallenge.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<List<ClientDTO>> findAll(){
		List<ClientDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
		ClientDTO clientDto = service.findById(id);
		return ResponseEntity.ok().body(clientDto);
	}
	
//	@PostMapping
//	public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO clientDto){
//		service.insert(client);
//		return ResponseEntity.ok().body(client);
//	}
}
