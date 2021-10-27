package com.itemis.salesTaxApp.Items;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HeadachePillsTest {
	
	HeadachePills headachePills;
	
	@BeforeEach
	void setUp() throws Exception {
		headachePills = new HeadachePills(0.5, false, 1); 
	}

	@Test
	void setQuantityTest() {
		headachePills.setQuantity(10);
		int expected = 10;
		int actual = headachePills.getQuantity();
		assertEquals(actual, expected, "The result of setter method of quantity");
	}
	
	@Test
	void getQuantityTest() {
		int expected = 1;
		int actual = headachePills.getQuantity();
		assertEquals(actual, expected, "THe result of getter method of quantity");
	
	}
	
	@Test
	void testSetPrice() {
		headachePills.setPrice(17.05);
		double expected = 17.05;
		double actual = headachePills.getPrice();
		assertEquals(expected, actual, "The result of comparision of expected and actual value of price");	
	}
	
	@Test 
	void testGetPrice() {
		double expected = 0.5;
		double actual = headachePills.getPrice();
		assertEquals(expected, actual, "The result of comparision of expected and actual value of price");
	}
	

	@Test
	void testsetImported() {
		headachePills.setImported(true);
		boolean expected = true;
		boolean actual = headachePills.isImported();
		assertEquals(actual, expected, "The result of comparision of expected and actual import status");
	}

	@Test
	void testIsImported() {
		boolean expected = false;
		boolean actual = headachePills.isImported();		
		assertEquals(expected, actual, "The result of comparision of expected and actual import status");
	}
	
	@Test
	void testGetName() {
		String expected = "packet of headache pills";
		String actual = headachePills.getName();
		assertEquals(expected, actual, "The result of comparision of expected and actual name of the item");
	}
	
	@Test
	void testGetOriginalPrice() {
		double expected = 0.5;
		double actual = headachePills.getOriginalPrice();
		assertEquals(actual, expected, "The result of comparision of expected and actual value of price");
	}

	@Test
	void testCheckImported() {
		boolean expected = false;
		boolean actual = headachePills.checkImported();		
		assertEquals(expected, actual, "The result of comparision of expected and actual import status");
	}

	@Test
	void testGetImported() {
		double expected = ((double) 5 / (double) 100) * headachePills.getOriginalPrice();
		double actual = headachePills.getImportedTax();
		assertEquals(expected, actual, "The result of comparision of expected and actual value of imported tax");
	}
	
	
	@Test
	void testGetPriceAfterTaxForImportedItem() {
		headachePills.setImported(true);
		double expected = headachePills.getOriginalPrice() + ((double) 5 / (double) 100) * headachePills.getOriginalPrice();
		double actual = headachePills.getPriceAfterTax();
		assertEquals(expected, actual, "The result of comparision of expected and actual value of price after tax for an imported item");
	}

	@Test
	void testGetPriceAfterTax() {
		double expected = headachePills.getOriginalPrice();
		double actual = headachePills.getPriceAfterTax();
		assertEquals(expected, actual, "The result of comparision of expected and actual value of price after tax of an item that is not imported");
	}

	@Test
	void testIsBSTApplicable() {
		boolean status = headachePills.isBSTApplicable();
		assertFalse(status, "The result of basic sales tax applicability on item.");
	}
	
	@Test
	void testGetTotalTax() {
		headachePills.setImported(false);
		double expected = 0;
		double actual = headachePills.getTotalTax();
		assertEquals(expected, actual, "The result of comparision of total tax imposed on the item");
		
	}
	
	@Test
	void testGetTotalTaxImported() {
		headachePills.setImported(true);
		double expected = headachePills.getImportedTax();
		double actual = headachePills.getTotalTax();
		
		assertEquals(expected, actual, "The result of comparision of total tax imposed on the item");	
	}



}
