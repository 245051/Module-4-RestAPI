package com.example.practice.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.dto.dto;
import com.example.practice.entity.entity;
import com.example.practice.exception.NotFoundId;
import com.example.practice.exception.exception;
import com.example.practice.repository.repository;

@RestController
@RequestMapping()
public class contoller {
	@Autowired
	private repository repo;
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody @Valid dto d){
		entity e=new entity(0,d.getEname(),d.getEaddress(),d.getEdate(),d.getEmail(),d.getAge(),d.getPattern());
		//entity e=entity.build(0,d.getEname(),d.getEmail(),d.getAge(),d.getEdate(),d.getEaddress(),d.getPattern());
		return ResponseEntity.ok().body(repo.save(e));
	
	}
	@GetMapping("/retrieve/{id}")
	public ResponseEntity <entity> fetchbyId(@PathVariable long id){
		Optional<entity> em=repo.findById(id);
		if(em.isPresent()) {
//			repo.findById(id);
			
			return new ResponseEntity<entity>(em.get(),HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<entity>(HttpStatus.NO_CONTENT);
			
		}
	}
	@GetMapping("/retrieveAll")
	public ResponseEntity<List<entity>> fetchAll(){
		return ResponseEntity.ok().body(repo.findAll());
	}
	@PutMapping("/update/{id}")
	public ResponseEntity upadte(@RequestBody @Valid dto d, @PathVariable long id)throws NotFoundId {
		Optional<entity> es=repo.findById(id);
		//entity ej;
		if(es.isPresent()) {
			//ej=es.get();
			entity ej=new entity(id,d.getEname(),d.getEaddress(),d.getEdate(),d.getPattern(),d.getAge(), d.getEmail());
//			ej.setAge(d.getAge());
//			ej.setEaddress(d.getEaddress());
//			ej.setEdate(d.getEdate());
//			ej.setPattern(d.getPattern());
//			ej.setEmail(d.getEmail());
//			ej.setEname(d.getEname());
			return ResponseEntity.ok(repo.save(ej));
			}
		else {
			throw new NotFoundId("We cannot found the Id");
		}
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id )throws exception{
		Optional<entity> re=repo.findById(id);
		if(re.isPresent()) {
			repo.deleteById(id);
			return ResponseEntity.status(HttpStatus.FOUND).body("Deleted");
		}
		else {
			throw new exception(" Cannnot be Deleted");
		}
	}
	
}