package com.cg.pos.utility;

import java.util.ArrayList;
import java.util.Iterator;

import com.cg.pos.entity.PizzaDetailsDTO;
import com.cg.pos.exceptions.*;
import com.cg.pos.staticdb.PizzaDetailsStaticDb;

public class ValidatePizzaDetails {
	static {
		PizzaDetailsStaticDb.StaticDb();
	}

	/**
	 * Validating inputs and checking whether StoreName and id is in the static
	 * database or not
	 * 
	 * @param storeName
	 * @param id
	 * @return
	 * @throws InvalidInputsException
	 */
	//
	public boolean isValidEnteredInputs(String storeName, int id) throws InvalidInputsException {

		ArrayList<PizzaDetailsDTO> list;
		list = PizzaDetailsStaticDb.getPizzaDetailList();
		String tempId = Integer.toString(id);
		if (!(storeName.matches("[A-Za-z]+")) || !tempId.matches("[0-9]{4}")) {
			throw new InvalidInputsException("Store Name must contain only characters and id must be integer");
		} else {
			Iterator<PizzaDetailsDTO> index = list.iterator();

			while (index.hasNext()) {
				PizzaDetailsDTO pizza = (PizzaDetailsDTO) index.next();
				if (storeName.equals(pizza.getStoreName()) && id == pizza.getItemId()) {
					return true;
				}
			}

			return false;
		}

	}

	// public boolean isValidId(int id) throws InvalidItemIdException {
	//
	// String stringId = Integer.toString(id);
	// if (stringId.matches("[a-z A-Z]+") || !stringId.matches("[0-9]")) {
	// throw new InvalidItemIdException("Must have 4 digits and only in between
	// 0-9");
	// }
	//
	// return true;
	// }
	/**
	 * Validating the pizzaName.
	 * 
	 * @param pizzaName
	 * @return
	 * @throws InvalidItemNameException
	 */
	public boolean isValidName(String pizzaName) throws InvalidItemNameException {
		if (!pizzaName.matches("[a-z A-Z]+{1,25}")) {

			throw new InvalidItemNameException("Must have alphabets within in the range of 30");
		}
		return true;
	}

	/**
	 * Validating StoreName
	 * 
	 * @param storeName
	 * @return
	 * @throws InvalidStoreNameException
	 */
	public boolean isValidStoreName(String storeName) throws InvalidStoreNameException {
		if (!storeName.matches("[a-z A-Z]+{1,25}")) {

			throw new InvalidStoreNameException("Must have alphabets within in the range of 30");
		}
		return true;
	}

	/**
	 * Validating Quantity
	 * 
	 * @param quantity
	 * @return
	 * @throws InvalidItemQuantityException
	 */
	public boolean isValidQuantity(int quantity) throws InvalidItemQuantityException {
		String StringQuantity = Integer.toString(quantity);
		if (!StringQuantity.matches("[0-9]{1,5}") || quantity <= 0) {

			throw new InvalidItemQuantityException("Must contain digits and it should not be zero");
		}

		return true;
	}

	/**
	 * Validating Cost
	 * 
	 * @param cost
	 * @return
	 * @throws InvalidItemCostException
	 */

	public boolean isValidCost(double cost) throws InvalidItemCostException {
		String StringCost = Double.toString(cost);
		if (StringCost.isEmpty() || cost <= 0.0 || StringCost.matches("[A-Z a-z]")) {
			throw new InvalidItemCostException("Cost must contain numbers and it should not be zero");
		}
		return true;

	}

	/**
	 * Validating Addons
	 * 
	 * @param addOns
	 * @return
	 * @throws InvalidAddOnsException
	 */

	public boolean isValidAddOn(String addOns) throws InvalidAddOnsException {
		if (!addOns.matches("[A-Z a-z]+{1,30}")) {
			throw new InvalidAddOnsException(" Addons must have alphabets within in the range of 30");
		}
		return true;
	}

	/**
	 * Checking whether static Database id having objects or not.
	 * 
	 * @return
	 * @throws EmptyCollectionException
	 */

	public boolean isEmptyCollection() throws EmptyCollectionException {
		ArrayList<PizzaDetailsDTO> list = null;
		list = PizzaDetailsStaticDb.getPizzaDetailList();
		if (list.isEmpty()) {
			throw new EmptyCollectionException("no more items... Sorry!!");
		}
		return false;
	}

}
