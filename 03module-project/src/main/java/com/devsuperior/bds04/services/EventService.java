package com.devsuperior.bds04.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository repository;
	
	@Transactional(readOnly = true)
	public List<EventDTO> findAllSortedByName() {
		List<Event> entities = repository.findAll(Sort.by("name"));
		return entities.stream().map(entity -> new EventDTO(entity)).collect(Collectors.toList());
	}
	
	@Transactional
	public EventDTO insert(EventDTO cityDto) {
		Event entity = copyDtoToEntity(cityDto);
		entity = repository.save(entity);
		return new EventDTO(entity);
	}
	
	public static Event copyDtoToEntity(EventDTO dto) {
		Event entity = new Event();
		entity.setName(dto.getName());
		entity.setUrl(dto.getUrl());
		entity.setDate(dto.getDate());
		entity.setCity(new City(dto.getCityId(), null));
		
		return entity;
	}
}
