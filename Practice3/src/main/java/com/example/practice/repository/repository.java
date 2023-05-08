package com.example.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practice.entity.entity;

@Repository
public interface repository extends JpaRepository<entity,Long>  {

}
