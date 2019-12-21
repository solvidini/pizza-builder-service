package com.pizzabuilder.service.pizzabuilderservice.model;

import java.io.Serializable;
import java.util.Date;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private final String username;
	private final Date expirationDate;
	private final Integer expiresIn;

//	public JwtResponse(String jwttoken) {
//		this.jwttoken = jwttoken;
//	}

	public JwtResponse(String jwttoken, String username, Date expirationDate) {
		this.jwttoken = jwttoken;
		this.username = username;
		this.expirationDate = expirationDate;
		this.expiresIn = 3600;
	}

	public String getToken() {
		return this.jwttoken;
	}

	public String getUsername() {
		return this.username;
	}

	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public Integer getExpiresIn() {
		return expiresIn;
	}

}