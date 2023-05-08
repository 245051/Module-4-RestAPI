package com.example.practice.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Dto {
	
	private long id;
	@NotNull(message="Title cannot be Null")
	@Size(min=3,max=200)
	private String b_title;
	@NotNull(message="Content Cannot be null")
	@Size(min=3,max=100)
	private String b_content;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public Dto(long id, @NotNull(message = "Title cannot be Null") @Size(min = 3, max = 200) String b_title,
			@NotNull(message = "Content Cannot be null") @Size(min = 3, max = 100) String b_content) {
		super();
		this.id = id;
		this.b_title = b_title;
		this.b_content = b_content;
	}
	public Dto() {
	}
	}
	
	


