package com.hai.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hai.demo.entity.Product;
import com.hai.demo.repositoy.RepositoryIface;

@Service
public class AwsService {
	
	@Autowired
	private RepositoryIface repro;
	

	public Product addproduct(Product product)
	{
		// TODO Auto-generated method stub
		return repro.save(product);
	}

	public Product retrproduct(long id) {
		// TODO Auto-generated method stub
		return repro.getById(id) ;
	}

	public List<Product> rallproduct() {
		// TODO Auto-generated method stub
		return repro.findAll();
	}

	public String deleteno(long id) {
		repro.deleteById(id);
		return "deleted";
	}

	public String deleteallid() {
		repro.deleteAll();
		return "Everthing is deleted";
	}

	public Product updateallo(Product product) {
		Product p=null;
		Optional<Product> op=repro.findById(product.getId());
		if(op.isPresent()) {
			p=op.get();
			p.setName(product.getName());
			p.setPrice(product.getPrice());
			p.setQty(product.getQty());
			repro.save(p);
		}
		return p;
		
		
		
		
	}

}
