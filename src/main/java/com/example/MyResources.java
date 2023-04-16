package com.example;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Template;

import com.example.model.ToDoDAO;
import com.example.model.ToDoDTO;

@Path("/")
public class MyResources {
	@Inject
	private ToDoDAO toDoDAO;

	@GET
	@Path("list")
	@Template(name = "/todo")
	public String getToDo() {
		toDoDAO.getAll();
		return "";
	}

	@POST
	@Path("list")
	@Template(name = "/todo")
	public String postToDo(@BeanParam ToDoDTO toDo) {
		toDoDAO.create(toDo);
		toDoDAO.getAll();
		return "";
	}

	@GET
	@Path("clear")
	public Response clearToDo() {
		toDoDAO.deleteAll();
		return Response.seeOther(URI.create("list")).build();
	}
}
