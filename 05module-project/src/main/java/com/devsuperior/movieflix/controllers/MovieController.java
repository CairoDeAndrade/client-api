package com.devsuperior.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieByGenreDTO;
import com.devsuperior.movieflix.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@GetMapping
	public ResponseEntity<Page<MovieByGenreDTO>> findAllPaged(Pageable pageable,
			@RequestParam(value = "genreId", defaultValue = "0") Long genreId){
		Page<MovieByGenreDTO> pageDto = service.findAllPaged(pageable, genreId);
		return ResponseEntity.ok().body(pageDto);
	}
}
