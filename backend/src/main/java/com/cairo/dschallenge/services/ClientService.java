package com.cairo.dschallenge.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cairo.dschallenge.dto.ClientDTO;
import com.cairo.dschallenge.entities.Client;
import com.cairo.dschallenge.repositories.ClientRepository;
import com.cairo.dschallenge.services.exceptions.DatabaseException;
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
	
	@Transactional
	public ClientDTO insert(ClientDTO clientDto) {
		Client entity = new Client();
		updateData(entity, clientDto);
		entity = repository.save(entity);
		return new ClientDTO(entity);
	}
	
	@Transactional
	public ClientDTO update(ClientDTO clientDto, Long id) {
		try {
			Client entity = repository.getReferenceById(id);
			updateData(entity, clientDto);
			entity = repository.save(entity);
			return new ClientDTO(entity);
		} 
		catch (EntityNotFoundException e) {
			throw new ResourceNotFound("Id not found: " + id);
		}

	}
	
	private void updateData(Client entity, ClientDTO clientDto) {
		entity.setName(clientDto.getName());
		entity.setCpf(clientDto.getCpf());
		entity.setIncome(clientDto.getIncome());
		entity.setBirthDate(clientDto.getBirthDate());
		entity.setChildren(clientDto.getChildren());
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFound("Id not found: " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
}
