package com.example.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practice.entity.BlogEntity;
@Repository
public interface RepositoryIface extends JpaRepository<BlogEntity, Long>{

}
