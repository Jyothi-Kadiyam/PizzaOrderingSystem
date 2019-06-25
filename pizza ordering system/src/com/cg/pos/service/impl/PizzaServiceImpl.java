package com.cg.pos.service.impl;

import com.cg.pos.staticdb.*;

import java.util.ArrayList;
import java.util.Iterator;

import com.cg.pos.entity.PizzaDetailsDTO;
import com.cg.pos.exceptions.EmptyCollectionException;
import com.cg.pos.exceptions.InvalidAddOnsException;
import com.cg.pos.exceptions.InvalidItemCostException;
import com.cg.pos.exceptions.InvalidItemNameException;
import com.cg.pos.exceptions.InvalidItemQuantityException;
import com.cg.pos.service.PizzaService;
import com.cg.pos.utility.*;

public class PizzaServiceImpl implements PizzaService {

	ArrayList<PizzaDetailsDTO> list = PizzaDetailsStaticDb.getPizzaDetailList();

	ValidatePizzaDetails validatePizzaDetails = new ValidatePizzaDetails();
	PizzaDetailsDTO pizzaDetails;

	/**
	 * modifying name
	 */
	@Override
	public ArrayList<PizzaDetailsDTO> modifyName(int pizzaId, String name) throws InvalidItemNameException {

		if (validatePizzaDetails.isValidName(name)) {

			Iterator<PizzaDetailsDTO> i = list.iterator();
			while (i.hasNext()) {

				PizzaDetailsDTO pizza = (PizzaDetailsDTO) i.next();
				if (pizzaId == pizza.getItemId()) {
					pizza.setItemName(name);
				}
			}

			return PizzaDetailsStaticDb.getPizzaDetailList();

		}
		return PizzaDetailsStaticDb.getPizzaDetailList();

	}

	/**
	 * modifying Quantity
	 */

	@Override
	public ArrayList<PizzaDetailsDTO> modifyQuantity(int pizzaId, int quantity) throws InvalidItemQuantityException {

		if (validatePizzaDetails.isValidQuantity(quantity)) {

			Iterator<PizzaDetailsDTO> index = list.iterator();
			while (index.hasNext()) {

				PizzaDetailsDTO pizza = (PizzaDetailsDTO) index.next();
				if (pizzaId == pizza.getItemId()) {
					pizza.setQuantity(quantity);

				}
			}
			return PizzaDetailsStaticDb.getPizzaDetailList();
		}
		return PizzaDetailsStaticDb.getPizzaDetailList();

	}

	/**
	 * modifying cost
	 */
	@Override
	public ArrayList<PizzaDetailsDTO> modifyCost(int pizzaId, double cost) throws InvalidItemCostException {

		if (validatePizzaDetails.isValidCost(cost)) {

			Iterator<PizzaDetailsDTO> index = list.iterator();
			while (index.hasNext()) {
				PizzaDetailsDTO pizza = (PizzaDetailsDTO) index.next();
				if (pizzaId == pizza.getItemId()) {
					pizza.setCost(cost);
				}
			}

			return PizzaDetailsStaticDb.getPizzaDetailList();
		}
		return PizzaDetailsStaticDb.getPizzaDetailList();
	}

	/**
	 * modifying addOns
	 */
	@Override
	public ArrayList<PizzaDetailsDTO> modifyAddOns(int pizzaId, String addOns) throws InvalidAddOnsException {

		if (validatePizzaDetails.isValidAddOn(addOns)) {

			Iterator<PizzaDetailsDTO> index = list.iterator();
			while (index.hasNext()) {
				PizzaDetailsDTO pizza = (PizzaDetailsDTO) index.next();
				if (pizzaId == pizza.getItemId()) {
					pizza.setAddOns(addOns);
				}
				return PizzaDetailsStaticDb.getPizzaDetailList();
			}
		}
		return PizzaDetailsStaticDb.getPizzaDetailList();
	}

	/**
	 * deleting pizzaDetails
	 */
	@Override
	public ArrayList<PizzaDetailsDTO> deletePizzaDetails(int id) throws EmptyCollectionException {

		Iterator<PizzaDetailsDTO> index = list.iterator();
		if (list.isEmpty()) {
			throw new EmptyCollectionException("no more items to delete... Sorry!!");
		}
		while (index.hasNext()) {
			PizzaDetailsDTO pizza = (PizzaDetailsDTO) index.next();
			if (id == pizza.getItemId()) {
				index.remove();
				return PizzaDetailsStaticDb.getPizzaDetailList();

			}
		}

		return PizzaDetailsStaticDb.getPizzaDetailList();
	}

	@Override
	public ArrayList<PizzaDetailsDTO> getDetails() {

		return PizzaDetailsStaticDb.getPizzaDetailList();
	}

}
