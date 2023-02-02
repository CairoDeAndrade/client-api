package com.cairo.dschallenge.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cairo.dschallenge.dto.ClientDTO;
import com.cairo.dschallenge.entities.Client;
import com.cairo.dschallenge.repositories.ClientRepository;
import com.cairo.dschallenge.services.exceptions.ResourceNotFound;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll(){
		List<Client> list = repository.findAll();
		return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id){
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new ResourceNotFound("Entity not found"));
		return new ClientDTO(entity);
	}
	
//	@Transactional
//	public ClientDTO insert(ClientDTO clientDto) {
//		Client entity = new Client(null, clientDto.getName(), clientDto.getCpf(), clientDto.getIncome(), clientDto.getBirthDate(), clientDto.getChildren());
//		repository.save(entity);
//		return new ClientDTO(entity);
//	}
}
