package com.educandoweb.course2.repositories;

import com.educandoweb.course2.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {


}
