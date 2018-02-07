package com.nisum.dao;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.nisum.bo.Movie;

@Component("mdi")
public class MovieDaoImpl implements MovieDao{

	@Cacheable(value="movieFindCache",key="#name")
	public Movie findByDirector(String name) {
		slowQuery(2000);
		System.out.println("findByDirector is running...");
		return new Movie(1,name,"Robert Zemeckis");
	}
	@CachePut(value="movieFindCache",key="#name")
	public Movie saveMovie(int id,String name,String mvName) {
		return new Movie(id,name,mvName);
	}
	private void slowQuery(long seconds){
	    try {
                Thread.sleep(seconds);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
	}

}