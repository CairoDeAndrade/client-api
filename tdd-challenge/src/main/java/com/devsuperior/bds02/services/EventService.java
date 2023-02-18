package com.devsuperior.bds02.services;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repositories.EventRepository;
import com.devsuperior.bds02.services.exceptions.ResourceNotFound;

@Service
public class EventService {
	
	@Autowired
	private EventRepository repositoy;
	
	@Transactional
	public EventDTO updateById(EventDTO eventDto, Long id) {
		
		try {
			Event entity = repositoy.getReferenceById(id);
			entity.setName(eventDto.getName());
			entity.setDate(eventDto.getDate());
			entity.setUrl(eventDto.getUrl());
			entity = repositoy.save(entity);
			
			return new EventDTO(entity.getId(), entity.getName(), entity.getDate(), entity.getUrl(), eventDto.getCityId());
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFound("Id not found: " + id);
		}

	}
}
