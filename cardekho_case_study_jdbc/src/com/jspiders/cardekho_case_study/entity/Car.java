package com.jspiders.cardekho_case_study.entity;

public class Car {
	private int carID;
	private String name;
	private String model;
	private String brand;
	private String fuelType;
	private double price;
	
	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public String toString() {
		return getCarID()+"\t"+getName()+"\t"+getModel()+"\t"+getBrand()+"\t"+getFuelType()+"\t"+getPrice()+"\t";
	}
	
	
}

