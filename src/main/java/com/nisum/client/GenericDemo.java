package com.nisum.client;

import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import com.nisum.bo.Movie;

public class GenericDemo {

	static ClientConfig clientConfig = new ClientConfig();
	static Client client = ClientBuilder.newClient(clientConfig);
	static WebTarget target = client.target(getURI());
	public static void main(String[] args) {
		Movie emp = target.path("spring-app").path("employee").path("getEmployee/{eid}").
				resolveTemplate("eid", 39).request().
				accept(MediaType.APPLICATION_JSON).get().readEntity(Movie.class);
		System.out.println("In Client"+emp.toString());

	}
	public static URI getURI() {
		return UriBuilder.fromUri("http://localhost:8080").build();
	}

}
