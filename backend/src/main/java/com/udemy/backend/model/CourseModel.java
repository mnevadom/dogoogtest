package com.udemy.backend.model;

import javax.persistence.Column;

public class CourseModel {
	// le pongo los mismos atributos que Course pero sin los que no necesito en los controllers por ej
	
	private String name;
	private String description;
	private int price;
	private int hours;
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}

	
	
}
