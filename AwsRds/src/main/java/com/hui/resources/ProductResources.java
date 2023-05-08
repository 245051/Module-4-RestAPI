package com.hui.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hui.resource.Product;
import com.hui.service.ProductService;
@RestController
// We are having the CRUD ,we call everything fro]m the service package ->ProductService class
public class ProductResources {
	//Product is in repository
		@Autowired
		ProductService service;
		
		//getting one element
		@GetMapping
		@RequestMapping("/retrive/{productId}")//to get details of one item
		//@ApiOperation(value=" fetch product id and returns the product entity")//additional information about method
		public Product fetchProduct(@PathVariable long productId)
		{
			return service.getProduct(productId);
		}
		//getting all elements
		@GetMapping
		@RequestMapping("/retrive/all")
		//@ApiOperation(value="returns the product entity")//additional information about method
		public List<Product> fetchProduct()
		{
			 return service.getProducts();
			
		}
		//add
		@PostMapping
		@RequestMapping(value="/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
		//@ApiOperation(value=" create a product")//additional information about method
		public ResponseEntity<?>addproduct(@RequestBody Product product){
			boolean result=service.add(product);
			if(result) {
				return ResponseEntity.status(HttpStatus.CREATED).body(true);
			}else
				return  ResponseEntity.status(HttpStatus.CREATED).body(false);
		}
		@PutMapping
		@RequestMapping(value="/update",consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public Product updateProduct(@RequestBody Product product) {
			return service.updateProduct(product);
		}
		@DeleteMapping
		@RequestMapping(value="/delete/{productId}")
		public void deleteProduct(@PathVariable long productId) {
			service.deleteProduct(productId);
		}
		
	}
	
