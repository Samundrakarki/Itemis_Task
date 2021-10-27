package com.itemis.salesTaxApp.Items;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PerfumeTest {
	Perfume perfume;
	
	@BeforeEach
	void setUp() throws Exception {
		perfume = new Perfume(15, false, 5);
	}

	@Test
	void testSetQuantity() {
		perfume.setQuanitity(10);
		int expected = 10;
		int actual = perfume.getQuantity();
		assertEquals(expected, actual, "The result of comparision of expected and actual value of quantity");
	}
	
	@Test
	void testGetQuantityTest() {
		int expected = 5;
		int actual = perfume.getQuantity();
		assertEquals(expected, actual, "The result of comparision of expected and actual value of quantity");
	
	}
	
	@Test
	void testSetPrice() {
		perfume.setPrice(17.05);
		double expected = 17.05;
		double actual = perfume.getPrice();
		assertEquals(expected, actual, "The result of comparision of expected and actual value of price");	
	}
	
	@Test 
	void testGetPrice() {
		double expected = 15;
		double actual = perfume.getPrice();
		assertEquals(expected, actual, "The result of comparision of expected and actual value of price");
	}
	

	@Test
	void testsetImported() {
		perfume.setImported(true);
		boolean expected = true;
		boolean actual = perfume.isImported();
		assertEquals(actual, expected, "The result of comparision of expected and actual import status");
	}

	@Test
	void testIsImported() {
		boolean expected = false;
		boolean actual = perfume.isImported();		
		assertEquals(expected, actual, "The result of comparision of expected and actual import status");
	}
	
	@Test
	void testGetName() {
		String expected = "bottle of perfume";
		String actual = perfume.getName();
		assertEquals(expected, actual, "The result of comparision of expected and actual name of the item");
	}
	
	@Test
	void testGetOriginalPrice() {
		double expected = 15;
		double actual = perfume.getOriginalPrice();
		assertEquals(actual, expected, "The result of comparision of expected and actual value of price");
	}

	@Test
	void testCheckImported() {
		boolean expected = false;
		boolean actual = perfume.checkImported();		
		assertEquals(expected, actual, "The result of comparision of expected and actual import status");
	}

	@Test
	void testGetImported() {
		double expected = ((double) 5 / (double) 100) * perfume.getOriginalPrice();
		double actual = perfume.getImportedTax();
		assertEquals(expected, actual, "The result of comparision of expected and actual value of imported tax");
	}
	
	@Test
	void testGetBasicTax() {
		double expected = ((double) 10 / (double) 100) * perfume.getOriginalPrice();
		double actual = perfume.getBasicTax();
		assertEquals(actual, expected, "The result of comparision of expected and actual value of basic sales tax");
	
	}
	
	@Test
	void testGetPriceAfterTaxForImportedItem() {
		perfume.setImported(true);
		double expected = perfume.getOriginalPrice() + ((double) 5 / (double) 100) * perfume.getOriginalPrice() + ((double) 10 / (double) 100) * perfume.getOriginalPrice();
		double actual = perfume.getPriceAfterTax();
		assertEquals(expected, actual, "The result of comparision of expected and actual value of price after tax for an imported item");
	}

	@Test
	void testGetPriceAfterTax() {
		double expected = perfume.getOriginalPrice() + ((double) 10 / (double) 100) * perfume.getOriginalPrice();
		double actual = perfume.getPriceAfterTax();
		assertEquals(expected, actual, "The result of comparision of expected and actual value of price after tax of an item that is not imported");
	}

	@Test
	void testIsBSTApplicable() {
		boolean status = perfume.isBSTApplicable();
		assertTrue(status, "The result of basic sales tax applicability on item.");
		
	}
}
