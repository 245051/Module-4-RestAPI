package com.example.practice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlogEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long b_id;
	private String b_title;
	private String b_content;
	public long getB_id() {
		return b_id;
	}
	public void setB_id(long b_id) {
		this.b_id = b_id;
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
	public BlogEntity(long b_id, String b_title, String b_content) {
		super();
		this.b_id = b_id;
		this.b_title = b_title;
		this.b_content = b_content;
	}
	public BlogEntity() {
	}
	public static BlogEntity build(int i, String b_title2, String b_content2) {
		
		return new BlogEntity(i,b_title2,b_content2);
	}
	}

