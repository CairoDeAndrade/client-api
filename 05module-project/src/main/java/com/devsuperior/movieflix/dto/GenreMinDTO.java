package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Genre;

public class GenreMinDTO {
	
	private String name;
	
	public GenreMinDTO() {
	}

	public GenreMinDTO(String name) {
		this.name = name;
	}
	
	public GenreMinDTO(Genre entity) {
		name = entity.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
