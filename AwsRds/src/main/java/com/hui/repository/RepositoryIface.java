package com.hui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hui.resource.Product;

@Repository
public interface RepositoryIface extends JpaRepository<Product,Long> {

}
