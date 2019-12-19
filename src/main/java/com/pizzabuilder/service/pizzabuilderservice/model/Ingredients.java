package com.pizzabuilder.service.pizzabuilderservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ingredients {
	@JsonProperty("tomato")
	private String tomato;
	@JsonProperty("pepperoni")
	private String pepperoni;
	@JsonProperty("jalapeno")
	private String jalapeno;
	@JsonProperty("cheese")
	private String cheese;
	@JsonProperty("cucumber")
	private String cucumber;
	@JsonProperty("mushroom")
	private String mushroom;
	@JsonProperty("pineapple")
	private String pineapple;
	@JsonProperty("olive")
	private String olive;
	@JsonProperty("paprika")
	private String paprika;
	@JsonProperty("oregano")
	private String oregano;

	public String getTomato() {
		return tomato;
	}

	public void setTomato(String tomato) {
		this.tomato = tomato;
	}

	public String getPepperoni() {
		return pepperoni;
	}

	public void setPepperoni(String pepperoni) {
		this.pepperoni = pepperoni;
	}

	public String getJalapeno() {
		return jalapeno;
	}

	public void setJalapeno(String jalapeno) {
		this.jalapeno = jalapeno;
	}

	public String getCheese() {
		return cheese;
	}

	public void setCheese(String cheese) {
		this.cheese = cheese;
	}

	public String getCucumber() {
		return cucumber;
	}

	public void setCucumber(String cucumber) {
		this.cucumber = cucumber;
	}

	public String getMushroom() {
		return mushroom;
	}

	public void setMushroom(String mushroom) {
		this.mushroom = mushroom;
	}

	public String getPineapple() {
		return pineapple;
	}

	public void setPineapple(String pineapple) {
		this.pineapple = pineapple;
	}

	public String getOlive() {
		return olive;
	}

	public void setOlive(String olive) {
		this.olive = olive;
	}

	public String getPaprika() {
		return paprika;
	}

	public void setPaprika(String paprika) {
		this.paprika = paprika;
	}

	public String getOregano() {
		return oregano;
	}

	public void setOregano(String oregano) {
		this.oregano = oregano;
	}

}
