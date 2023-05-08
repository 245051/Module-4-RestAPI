package com.example.practice.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practice.dto.Dto;
import com.example.practice.entity.BlogEntity;
import com.example.practice.exception.BlogException;
import com.example.practice.exception.UpdateException;
import com.example.practice.repository.RepositoryIface;
@Service
public class BlogService {
	@Autowired
	private RepositoryIface repo;
	public  BlogEntity makeDb(@Valid Dto b) {
		BlogEntity be=BlogEntity.build(0,b.getB_title(),b.getB_content());
		return repo.save(be);
	}
	public List<BlogEntity> fetchall() {
		
		return repo.findAll();
	}
	public BlogEntity fetchId(long id) {//throws IdNotFoundException {
		
	
	     Optional<BlogEntity> be = repo.findById(id);
	     if(be.isPresent())
	    	 return be.get();
	     else
	    	  return null;
	
	
	}
	public String delete(long id) throws BlogException{
		Optional<BlogEntity> de = repo.findById(id);
		if(de.isPresent()) {
			repo.deleteById(id);
			return "Deleted";
			
		}else {
		throw new BlogException("Cannot find this Id"+id);	
		}
		
		
	}
	public BlogEntity update(@Valid Dto be)throws UpdateException {
		BlogEntity b=new BlogEntity();
		b.setB_id(be.getId());
		b.setB_content(be.getB_content());
		b.setB_title(be.getB_title());
		return repo.save(b);
	}
	

}
