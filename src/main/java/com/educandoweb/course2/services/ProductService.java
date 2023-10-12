package com.educandoweb.course2.services;

import com.educandoweb.course2.entities.Product;
import com.educandoweb.course2.entities.User;
import com.educandoweb.course2.repositories.ProductRepository;
import com.educandoweb.course2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = productRepository.findById(id);
        return obj.get();
    }

}
