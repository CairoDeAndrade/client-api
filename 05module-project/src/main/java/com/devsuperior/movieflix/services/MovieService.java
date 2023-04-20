package com.devsuperior.movieflix.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieDetailedDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Transactional
	public Page<MovieDTO> findAllPaged(Pageable pageable, Long genreId){
		Genre genre = (genreId == 0) ? null : genreRepository.getOne(genreId);
		Page<Movie> page = movieRepository.findMovies(genre, pageable);
		movieRepository.findMoviesWithGenres(page.getContent());
		return page.map(movie -> new MovieDTO(movie, movie.getGenre()));
	}
	
	@Transactional
	public MovieDetailedDTO findById(Long id) {
		Optional<Movie> entity = movieRepository.findById(id);
		Movie movie = entity.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new MovieDetailedDTO(movie, movie.getGenre());
	}
}
