package com.pizzabuilder.service.pizzabuilderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzabuilder.service.pizzabuilderservice.model.Order;
import com.pizzabuilder.service.pizzabuilderservice.model.UserDao;
import com.pizzabuilder.service.pizzabuilderservice.repository.OrderRepository;
import com.pizzabuilder.service.pizzabuilderservice.repository.UserRepository;

@RestController
@CrossOrigin
public class OrderController {

	@Autowired
	private UserRepository userDao;

	@Autowired
	private OrderRepository orderRepository;

	public boolean checkNull(Order order) throws IllegalAccessException {
		if (order.getIngredients() != null && order.getPrice() != null && order.getOrderData() != null)
			return true;
		else
			return false;
	}

	@PostMapping("/orders")
	public ResponseEntity<Object> createOrder(@RequestBody Order order) throws IllegalAccessException {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserDao user = userDao.findByUsername(username);

		if (checkNull(order)) {
			order.setUser(user);
			orderRepository.save(order);
		} else {
			return new ResponseEntity<Object>("Wrong data", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(order, HttpStatus.CREATED);
	}

	@GetMapping("/orders")
	public List<Order> retrieveAllUserOrders() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserDao user = userDao.findByUsername(username);
		return user.getOrders();
	}

}
