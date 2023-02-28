package com.devsuperior.bds04.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repositories.CityRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository repository;
	
	@Transactional
	public CityDTO insert(CityDTO cityDto) {
		City entity = new City(null, cityDto.getName());
		entity = repository.save(entity);
		return new CityDTO(entity);
	}
}
