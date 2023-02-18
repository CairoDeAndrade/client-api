package com.devsuperior.bds02.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repositories.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository repositoy;
	
	@Transactional
	public EventDTO updateById(EventDTO eventDto, Long id) {
		
		Event entity = repositoy.getReferenceById(id);
		entity.setName(eventDto.getName());
		entity.setDate(eventDto.getDate());
		entity.setUrl(eventDto.getUrl());
		
		entity = repositoy.save(entity);
		return new EventDTO(entity);
	}
}
