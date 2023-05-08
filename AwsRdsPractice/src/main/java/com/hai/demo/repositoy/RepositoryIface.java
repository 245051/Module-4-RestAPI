package com.hai.demo.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hai.demo.entity.Product;



@Repository
public interface RepositoryIface extends JpaRepository<Product,Long> {

}
