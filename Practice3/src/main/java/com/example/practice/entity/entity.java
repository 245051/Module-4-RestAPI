package com.example.practice.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class entity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String ename;
	private String eaddress;
	private Date edate;
	private String email;
	private int age;
	private String pattern;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEaddress() {
		return eaddress;
	}
	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
		this.edate = edate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public entity() {
		
	}
	public entity(long id, String ename, String eaddress, Date edate, String email, int age, String pattern) {
		super();
		this.id = id;
		this.ename = ename;
		this.eaddress = eaddress;
		this.edate = edate;
		this.email = email;
		this.age = age;
		this.pattern = pattern;
	}
	
	
	
	
	

}
