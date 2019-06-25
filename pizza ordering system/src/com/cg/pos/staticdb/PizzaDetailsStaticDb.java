package com.cg.pos.staticdb;

import com.cg.pos.entity.*;
import java.util.ArrayList;

public class PizzaDetailsStaticDb {

	private static ArrayList<PizzaDetailsDTO> pizzaDetailList = new ArrayList<PizzaDetailsDTO>();

	public static void StaticDb() {
		PizzaDetailsDTO pizza = new PizzaDetailsDTO(1001, "Domino", "Pizza1", 10, 100.00, "basePan");
		PizzaDetailsDTO pizza1 = new PizzaDetailsDTO(1023, "Pizzahut", "cheese Pizza", 150, 120.00, "extra cheese");
		PizzaDetailsDTO pizza2 = new PizzaDetailsDTO(1024, "Pizzahut", "cheese Pizza", 205, 209.00, "corn cheese");
		PizzaDetailsDTO pizza3 = new PizzaDetailsDTO(1002, "Domino", "cheese Pizza", 198, 202.00, "cheese");
		getPizzaDetailList().add(pizza);
		getPizzaDetailList().add(pizza1);
		getPizzaDetailList().add(pizza2);
		getPizzaDetailList().add(pizza3);

	}

	public static ArrayList<PizzaDetailsDTO> getPizzaDetailList() {
		return pizzaDetailList;
	}

	public static void setPizzaDetailList(ArrayList<PizzaDetailsDTO> pizzaDetailList) {
		PizzaDetailsStaticDb.pizzaDetailList = pizzaDetailList;
	}
}
