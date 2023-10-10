package com.educandoweb.course2.repositories;

import com.educandoweb.course2.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {


}
