package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieByGenreDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	private GenreRepository genreRepository;
	
	@Transactional
	public Page<MovieByGenreDTO> findAllPaged(Pageable pageable, Long genreId){
		Genre genre = (genreId == 0) ? null : genreRepository.getOne(genreId);
		Page<Movie> page = movieRepository.findMovies(genre, pageable);
		return page.map(movie -> new MovieByGenreDTO(movie));
	}
}
