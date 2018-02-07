package com.nisum.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.nisum.bo.Movie;
import com.nisum.dao.MovieDaoImpl;

@Path("employee")
public class App {


	@Autowired
	MovieDaoImpl obj;
	@Path("getEmployee/{eid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeeByEid(@PathParam("eid") String eid) {
		Movie empData = obj.findByDirector(eid);
		System.out.println(empData.toString());
		return Response.status(200).entity(empData).build();
	}
	
	public static void main(String[] args) {
		App ap = new App();
		Movie empData = new MovieDaoImpl().findByDirector("dummy");
		System.out.println("In Main"+empData.toString());
	}
	public  void testCache() {
		Movie empData = new MovieDaoImpl().findByDirector("dummy");
		System.out.println("In Main"+empData.toString());
	}
}