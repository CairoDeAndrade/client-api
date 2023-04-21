package com.devsuperior.movieflix.dto;

import javax.validation.constraints.NotBlank;

import com.devsuperior.movieflix.entities.Review;

public class ReviewInsertDTO {
	
	@NotBlank(message = "Required field!")
	private String text;
	
	private Long movieId;
	
	public ReviewInsertDTO() {
	}

	public ReviewInsertDTO(Long id, String text) {
		this.text = text;
	}
	
	public ReviewInsertDTO(Review entity) {
		text = entity.getText();
		movieId = entity.getMovie().getId();
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
}
