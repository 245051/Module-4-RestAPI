package com.example.practice.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

public class dto {
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@NotNull(message="Name cannot be null")
	private String ename;
	@NotBlank
	private String eaddress;
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date edate;
	@Email(message="Enter the valid email")
	private String email;
	@Min(value = 18)
	@Max(value=60)
	private int age;
	private String Pattern;
	public dto(@NotNull(message = "Name cannot be null") String ename, @NotBlank String eaddress, Date edate,
			@Email(message = "Enter the valid email") String email, @Min(18) @Max(60) int age,
			@Pattern(regexp = "^[A-Za-z]*$") String pattern) {
		super();
		this.ename = ename;
		this.eaddress = eaddress;
		this.edate = edate;
		this.email = email;
		this.age = age;
		this.pattern = pattern;
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
	@Pattern(regexp="^[A-Za-z]*$")
	private String pattern;

}