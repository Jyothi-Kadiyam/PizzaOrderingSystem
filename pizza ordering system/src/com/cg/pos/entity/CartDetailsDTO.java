package com.cg.pos.entity;


public class CartDetailsDTO {
private String pizzaName;
private int quantity;
private double cost;
public String getPizzaName() {
	return pizzaName;
}
public void setPizzaName(String pizzaName) {
	this.pizzaName = pizzaName;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getCost() {
	return cost;
}
public void setCost(double cost) {
	this.cost = cost;
}

}
