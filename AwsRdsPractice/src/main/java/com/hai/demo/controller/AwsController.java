package com.hai.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hai.demo.entity.Product;
import com.hai.demo.service.AwsService;



@RestController
@RequestMapping("/product/api/6.0")
public class AwsController {
	@Autowired
	private AwsService service;
	
	@PostMapping
	@RequestMapping("/create")
	
	public Product create(@RequestBody Product product)
	{
		return service.addproduct(product);
	}
	@GetMapping
	@RequestMapping("/retrieve/{id}")
	public Product retrieve(@PathVariable long id) {
		return service.retrproduct(id);
		
	}
	@GetMapping
	@RequestMapping("/retrieve/all")
	public List<Product> fetchproduct(){
		return service.rallproduct();
	}
	@DeleteMapping
	@RequestMapping("/delete/{id}")
	public String deleteid(@PathVariable long id) {
		return service.deleteno(id);
	}
	@DeleteMapping
	@RequestMapping("/delete")
	public String deleteall()
	{
		return service.deleteallid();
	}
	@PutMapping
	@RequestMapping("/update")
	public Product updateAll(@RequestBody Product product)
	{
		return service.updateallo(product);
	}
	
}
