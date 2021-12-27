package com.project.sessionmanager.repo;

import com.project.sessionmanager.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    public Product findByProductname(String productname);
    List<Product> findAll();
    public Product findByProductid(Integer productid);
}
