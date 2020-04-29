package com.cognizant.service;

import static org.junit.Assert.*;


import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieServiceTest {
	
	static {
		System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "debug");
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieService.class);
	private static MovieService movieService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		movieService = context.getBean(MovieService.class);
	}
	
	@Test
	public void testGetMovieListAdmin() {
		LOGGER.info("start");
		List<Movie> movies = movieService.getMovieListAdmin();
		assertNotNull(movies);
		int size = movies.size();
		assertNotEquals(0, size);
		LOGGER.debug("admin-movies{}:", movies);
		LOGGER.info("end");
	}
	
	@Test
	public void testGetMovieListCustomer() {
		LOGGER.info("start");
		List<Movie> movies = movieService.getMovieListCustomer();
		assertNotNull(movies);
		int size = movies.size();
		assertNotEquals(0, size);
		LOGGER.debug("customer-movies{}:", movies);
		LOGGER.info("end");
	}
	
	@Test
	public void testModifyMovie() {
		LOGGER.info("start");
		int previous_size = movieService.getMovieListAdmin().size();
		Movie movie = new Movie(3, "Titanic", "$2,187,463,954", true, DateUtil.convertToDate("21/08/2017"), "Romance", false);
		movieService.modifyMovie(movie);
		int new_size = movieService.getMovieListAdmin().size();
		assertEquals(new_size, previous_size);
		Movie movie_get = movieService.getMovie(4);
		assertNotNull(movie_get);
		LOGGER.debug("movie_updated{}:", movie_get);
		LOGGER.info("end");
	}
	
	@Test
	public void testGetMovie() {
		LOGGER.info("start");
		Movie movie = movieService.getMovie(1);
		assertNotNull(movie);
		LOGGER.debug("movie{}:", movie);
		LOGGER.info("end");
	}

}