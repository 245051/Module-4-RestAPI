package com.hui.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hui.repository.RepositoryIface;
import com.hui.resource.Product;

@Service
public class ProductService {
	
	   @Autowired
		RepositoryIface repository;
		//get
		public Product getProduct(long productId) {
			Optional<Product> optional=repository.findById(productId);
	        if(optional.isPresent())
	        	    return optional.get();
	        else
			       return  null;		
		}
		public List<Product> getProducts(){
			return repository.findAll();
		}
		
		//add
		 public boolean add(Product product) {
			repository.save(product);
			 return true;
		 }
		 //update
		 public Product updateProduct(Product product) {
			 return repository.save(product);
		 }
		 //delete
		 public void deleteProduct(long productId) {
			  repository.deleteById(productId);
		 }
		 
		 

}
