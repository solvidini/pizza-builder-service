package com.pizzabuilder.service.pizzabuilderservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vladmihalcea.hibernate.type.json.JsonStringType;

@Entity(name = "Book")
@Table(name = "orders")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Order {
	@Id
	@GeneratedValue
	private Integer id;

	@Type(type = "json")
	@Column(columnDefinition = "json")
	private Ingredients ingredients;

	@Type(type = "json")
	@Column(columnDefinition = "json")
	private OrderData orderData;

	@Column
	private Double price;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private UserDao user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public UserDao getUser() {
		return user;
	}

	public void setUser(UserDao user) {
		this.user = user;
	}

	public Ingredients getIngredients() {
		return ingredients;
	}

	public void setIngredients(Ingredients ingredients) {
		this.ingredients = ingredients;
	}

	public OrderData getOrderData() {
		return orderData;
	}

	public void setOrderData(OrderData orderData) {
		this.orderData = orderData;
	}

}
