package com.educandoweb.course2.services;

import com.educandoweb.course2.entities.Category;
import com.educandoweb.course2.entities.User;
import com.educandoweb.course2.repositories.CategoryRepository;
import com.educandoweb.course2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }

}
