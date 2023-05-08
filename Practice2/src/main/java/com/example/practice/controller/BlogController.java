package com.example.practice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.dto.Dto;
import com.example.practice.entity.BlogEntity;
import com.example.practice.exception.BlogException;
import com.example.practice.exception.UpdateException;
import com.example.practice.service.BlogService;


@RestController
@RequestMapping("/user")
@Validated
public class BlogController {
	@Autowired
	private BlogService service;
	@PostMapping("/create")
	public ResponseEntity<BlogEntity> create(@RequestBody @Valid Dto b){
		//service.makeDb(b);
		return new ResponseEntity<BlogEntity>(service.makeDb(b),HttpStatus.CREATED);
	}
	@GetMapping("/retrieve")
	public List<BlogEntity> fetchall(){
		return service.fetchall();
	}
	@GetMapping("/retrieveId/{id}")
	public ResponseEntity<?> fetchId(@PathVariable long id){
		
		
	//public BlogEntity fetchId(@PathVariable long id) {
		//return service.fetchId(id);
		//return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.fetchId(id));
			//return new ResponseEntity<>(service.fetchId(id),HttpStatus.ACCEPTED)	
	//	return ResponseEntity.ok(service.fetchId(id));
		return ResponseEntity.notFound().build(); // Give if their is an error
		
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable long id) throws BlogException {
		
		return service.delete(id);
		}
	@PutMapping("/update")
	public BlogEntity update(@RequestBody @Valid Dto be) throws UpdateException{
		return service.update(be);
		
	}
}
	
	

