package com.educandoweb.course2.repositories;

import com.educandoweb.course2.entities.OrderItem;
import com.educandoweb.course2.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {


}
