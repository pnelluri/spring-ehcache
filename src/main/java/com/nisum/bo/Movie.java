package com.nisum.bo;

import java.io.Serializable;

import org.springframework.stereotype.Component;
@Component
public class Movie {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDirectory() {
		return directory;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	int id;
	String name;
	public Movie() {
		super();
	}
	String directory;
	public Movie(int id, String name, String directory) {
		super();
		this.id = id;
		this.name = name;
		this.directory = directory;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", directory=" + directory + "]";
	}

	//getters and setters
	//constructor with fields
	//toString()
}
