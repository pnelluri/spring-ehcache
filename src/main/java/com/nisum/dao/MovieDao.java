package com.nisum.dao;

import org.springframework.stereotype.Component;

import com.nisum.bo.Movie;
@Component
public interface MovieDao{

	Movie findByDirector(String name);

}