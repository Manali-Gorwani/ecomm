package com.project.sessionmanager.services;

import com.project.sessionmanager.models.Product;
import com.project.sessionmanager.models.User;
import com.project.sessionmanager.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    //@Autowired
    //ProductRepository productRepository;

    private final ProductRepository productRespository;

    @Autowired
    public ProductService(ProductRepository productRespository) {
        this.productRespository = productRespository;
    }

    public List<Product> findAll() {
        return productRespository.findAll();
    }

    /*public Optional<Product> findById(Integer productid) {
        return productRespository.findById(productid);
    }*/

    public Product save(Product p) {
        return productRespository.save(p);
    }
    /*
    public void deleteById(Integer productid) {
        productRespository.deleteById(productid);
    }*/
}
