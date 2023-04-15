package com.example.model;

import javax.ws.rs.FormParam;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class ToDoDTO {
	@FormParam("id")
	private int id;
	@FormParam("title")
	private String title;
	@FormParam("priority")
	private int priority;
}

