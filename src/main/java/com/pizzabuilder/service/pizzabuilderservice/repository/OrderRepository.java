package com.pizzabuilder.service.pizzabuilderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzabuilder.service.pizzabuilderservice.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
