package com.itemis.salesTaxApp.Items;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChocolateBarTest {

	ChocolateBar chocolate;
	
	@BeforeEach
	void setUp() throws Exception {
		chocolate = new ChocolateBar(15, false, 5);
	}

	@Test
	void setQuantityTest() {
		chocolate.setQuantity(10);
		int expected = 10;
		int actual = chocolate.getQuantity();
		assertEquals(actual, expected, "The result of setter method of quantity");
	}
	
	@Test
	void getQuantityTest() {
		int expected = 5;
		int actual = chocolate.getQuantity();
		assertEquals(actual, expected, "THe result of getter method of quantity");
	
	}
	
	@Test
	void testSetPrice() {
		chocolate.setPrice(17.05);
		double expected = 17.05;
		double actual = chocolate.getPrice();
		assertEquals(expected, actual, "The result of comparision of expected and actual value of price");	
	}
	
	@Test 
	void testGetPrice() {
		double expected = 15;
		double actual = chocolate.getPrice();
		assertEquals(expected, actual, "The result of comparision of expected and actual value of price");
	}
	

	@Test
	void testsetImported() {
		chocolate.setImported(true);
		boolean expected = true;
		boolean actual = chocolate.isImported();
		assertEquals(actual, expected, "The result of comparision of expected and actual import status");
	}

	@Test
	void testIsImported() {
		boolean expected = false;
		boolean actual = chocolate.isImported();		
		assertEquals(expected, actual, "The result of comparision of expected and actual import status");
	}
	
	@Test
	void testGetName() {
		String expected = "chocolate bar";
		String actual = chocolate.getName();
		assertEquals(expected, actual, "The result of comparision of expected and actual name of the item");
	}
	
	@Test
	void testGetOriginalPrice() {
		double expected = 15;
		double actual = chocolate.getOriginalPrice();
		assertEquals(actual, expected, "The result of comparision of expected and actual value of price");
	}

	@Test
	void testCheckImported() {
		boolean expected = false;
		boolean actual = chocolate.checkImported();		
		assertEquals(expected, actual, "The result of comparision of expected and actual import status");
	}

	@Test
	void testGetImported() {
		double expected = ((double) 5 / (double) 100) * chocolate.getOriginalPrice();
		double actual = chocolate.getImportedTax();
		assertEquals(expected, actual, "The result of comparision of expected and actual value of imported tax");
	}
	
	
	@Test
	void testGetPriceAfterTaxForImportedItem() {
		chocolate.setImported(true);
		double expected = chocolate.getOriginalPrice() + ((double) 5 / (double) 100) * chocolate.getOriginalPrice();
		double actual = chocolate.getPriceAfterTax();
		assertEquals(expected, actual, "The result of comparision of expected and actual value of price after tax for an imported item");
	}

	@Test
	void testGetPriceAfterTax() {
		double expected = chocolate.getOriginalPrice();
		double actual = chocolate.getPriceAfterTax();
		assertEquals(expected, actual, "The result of comparision of expected and actual value of price after tax of an item that is not imported");
	}

	@Test
	void testIsBSTApplicable() {
		boolean status = chocolate.isBSTApplicable();
		assertFalse(status, "The result of basic sales tax applicability on item.");
		
	}
	
	@Test
	void testGetTotalTax() {
		chocolate.setImported(false);
		double expected = 0;
		double actual = chocolate.getTotalTax();
		assertEquals(expected, actual, "The result of comparision of total tax imposed on the item");
		
	}
	
	@Test
	void testGetTotalTaxImported() {
		chocolate.setImported(true);
		double expected = chocolate.getImportedTax();
		double actual = chocolate.getTotalTax();
		assertEquals(expected, actual, "The result of comparision of total tax imposed on the item");	
	}
}
