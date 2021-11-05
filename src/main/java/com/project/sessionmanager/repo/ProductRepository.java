package com.project.sessionmanager.repo;

import com.project.sessionmanager.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    //public Product findById(Integer productid);
    //public Product findByName(String productname);
}
