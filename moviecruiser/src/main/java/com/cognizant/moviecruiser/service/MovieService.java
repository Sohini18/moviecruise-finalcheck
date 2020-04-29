package com.cognizant.moviecruiser.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.repository.MovieRepository;


@Service
public class MovieService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieService.class);

	@Autowired
	private MovieDao movieDao;

	@Autowired
	private MovieRepository movieRepository;

	public void setMovieDao(MovieDao movieDao) {
		this.movieDao = movieDao;
	}

	@Transactional
	public List<Movie> getMovieListAdmin() {
		LOGGER.info("start");
		// return menuItemDao.getMenuItemListAdmin();
		return movieRepository.findAll();
	}

	@Transactional
	public List<Movie> getMovieListCustomer() {
		LOGGER.info("start");
		// return menuItemDao.getMenuItemListCustomer();
		return movieRepository.getMovieListCustomer(new Date());
	}

	@Transactional
	public Movie getMovie(long movieId) {
		LOGGER.info("start");
		return movieRepository.getOne(movieId);
	}

	@Transactional
	public void modifyMovie(Movie movie) {
		LOGGER.info("start");
		// menuItemDao.modifyMenuItem(menuItem);
		movieRepository.save(movie);
		LOGGER.info("end");
	}
	
}
