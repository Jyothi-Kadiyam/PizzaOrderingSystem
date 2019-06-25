package com.cg.pos.service;

import java.util.ArrayList;

//import com.cg.pos.cart.serviceimpl.CartManagementServicesImpl;
import com.cg.pos.entity.PizzaDetailsDTO;
//import com.cg.pos.pizza.entity.PizzaDetails;
//import com.cg.pos.pizza.staticdb.dto.POSDatabase;

public interface CartService {
public ArrayList<PizzaDetailsDTO> addItemToCart(int pizzaSelect);
public ArrayList<PizzaDetailsDTO> removeItemFromCart();
public void confirmOrder(); 
	

}
