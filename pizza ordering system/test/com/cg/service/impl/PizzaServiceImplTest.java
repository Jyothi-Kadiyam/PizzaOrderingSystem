package com.cg.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.pos.entity.PizzaDetailsDTO;
import com.cg.pos.exceptions.InvalidInputsException;

import com.cg.pos.exceptions.InvalidAddOnsException;
import com.cg.pos.exceptions.InvalidItemCostException;
import com.cg.pos.exceptions.InvalidItemNameException;
import com.cg.pos.exceptions.InvalidItemQuantityException;
import com.cg.pos.utility.ValidatePizzaDetails;

public class PizzaServiceImplTest {

	ValidatePizzaDetails validatePizzaDetails = new ValidatePizzaDetails();
	PizzaDetailsDTO pizzaDetails = new PizzaDetailsDTO();

	@Test(expected = InvalidInputsException.class)
	public void testValidEntertedIdFailed() throws InvalidInputsException {
		validatePizzaDetails.isValidEnteredInputs("1sdggghhg6456", 125);
	}

	@Test
	public void testValidEnteredIdBySuccess() throws InvalidInputsException {
		boolean actual = validatePizzaDetails.isValidEnteredInputs("Domino", 1001);
		assertEquals(true, actual);
	}

	@Test(expected = InvalidItemNameException.class)
	public void testInValidPizzaName() throws InvalidItemNameException {
		validatePizzaDetails.isValidName("142dgd@@");
	}

	@Test(expected = InvalidItemNameException.class)
	public void testValidPizzaNameByEmpty() throws InvalidItemNameException {
		validatePizzaDetails.isValidName("");
	}

	public void testValidPizzaNameBySuccess() throws InvalidItemNameException {
		boolean actual = validatePizzaDetails.isValidName("cheese pizza");
		assertEquals(true, actual);
	}

	@Test(expected = InvalidItemQuantityException.class)
	public void testValidQuantity() throws InvalidItemQuantityException {
		validatePizzaDetails.isValidQuantity(123449159);
	}

	@Test(expected = InvalidItemQuantityException.class)
	public void testValidQuantityByZero() throws InvalidItemQuantityException {
		validatePizzaDetails.isValidQuantity(0);
	}

	public void testValidQuantityBySuccess() throws InvalidItemCostException {
		boolean actual = validatePizzaDetails.isValidCost(8);
		assertEquals(true, actual);
	}

	@Test(expected = InvalidItemCostException.class)
	public void testValidCost() throws InvalidItemCostException {
		validatePizzaDetails.isValidCost(0);
	}

	@Test
	public void testValidCostBySuccess() throws InvalidItemCostException {
		boolean actual = validatePizzaDetails.isValidCost(8.00);
		assertEquals(true, actual);
	}

	@Test
	public void testValidAddOnBySuccess() throws InvalidAddOnsException {
		boolean actual = validatePizzaDetails.isValidAddOn("cheese with pan");
		assertEquals(true, actual);
	}

	@Test(expected = InvalidAddOnsException.class)
	public void testValidAddOnBySpace() throws InvalidAddOnsException {
	}
	// @Test(expected = EmptyCollectionException.class)
	// public void testEmptyCollection() throws EmptyCollectionException {
	// boolean actual = validateDetails.isEmptyCollection();
	// }
	//

}
