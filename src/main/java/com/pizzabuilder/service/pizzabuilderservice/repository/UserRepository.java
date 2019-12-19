package com.pizzabuilder.service.pizzabuilderservice.repository;

import com.pizzabuilder.service.pizzabuilderservice.model.UserDao;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserDao, Integer> {
    UserDao findByUsername(String username);
}