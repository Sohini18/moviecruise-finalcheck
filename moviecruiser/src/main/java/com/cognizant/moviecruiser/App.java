package com.cognizant.moviecruiser;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;
import com.cognizant.moviecruiser.util.DateUtil;

public class App {

	static {
		System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "debug");
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	private static MovieService movieService;

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		movieService = context.getBean(MovieService.class);
		
		getMovieListAdmin();
		// getMovieListCustomer();
		// Movie movie = new Movie(3, "Titanic", "$2,187,463,954", true, DateUtil.convertToDate("21/08/2017"), "Romance", false);
		// editMovie(movie);
		// getMovie(1);

	}

	public static void getMovieListAdmin() {
		LOGGER.info("start");
		List<Movie> movies = movieService.getMovieListAdmin();
		LOGGER.debug("admin-movies{}:", movies);
		LOGGER.info("end");
	}

	public static void getMovieListCustomer() {
		LOGGER.info("start");
		List<Movie> movies = movieService.getMovieListCustomer();
		LOGGER.debug("customer-movies{}:", movies);
		LOGGER.info("end");
	}

	public static void editMovie(Movie movie) {
		LOGGER.info("start");
		movieService.modifyMovie(movie);
		LOGGER.info("end");
	}

	public static void getMovie(long movieId) {
		LOGGER.info("start");
		Movie movie = movieService.getMovie(movieId);
		LOGGER.debug("movie{}:", movie);
		LOGGER.info("end");
	}
}