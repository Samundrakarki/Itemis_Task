package com.itemis.salesTaxApp.Items;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {
	
	Book book;
	
	@BeforeEach
	void setUp() throws Exception {
		book = new Book(12, true, 5);
	}

	@Test
	void setQuantityTest() {
		book.setQuantity(10);
		int expected = 10;
		int actual = book.getQuantity();
		assertEquals(actual, expected, "The result of setter method of quantity");
	}
	
	@Test
	void getQuantityTest() {
		int expected = 5;
		int actual = book.getQuantity();
		assertEquals(actual, expected, "THe result of getter method of quantity");
	
	}
	
	@Test
	void testSetPrice() {
		book.setPrice(17.05);
		double expected = 17.05;
		double actual = book.getPrice();
		assertEquals(expected, actual, "The result of comparision of expected and actual value of price");	
	}
	
	@Test 
	void testGetPrice() {
		double expected = 12;
		double actual = book.getPrice();
		assertEquals(expected, actual, "The result of comparision of expected and actual value of price");
	}
	

	@Test
	void testsetImported() {
		book.setImported(true);
		boolean expected = true;
		boolean actual = book.isImported();
		assertEquals(actual, expected, "The result of comparision of expected and actual import status");
	}

	@Test
	void testIsImported() {
		boolean expected = true;
		boolean actual = book.isImported();		
		assertEquals(expected, actual, "The result of comparision of expected and actual import status");
	}
	
	@Test
	void testGetName() {
		String expected = "book";
		String actual = book.getName();
		assertEquals(expected, actual, "The result of comparision of expected and actual name of the item");
	}
	
	@Test
	void testGetOriginalPrice() {
		double expected = 12;
		double actual = book.getOriginalPrice();
		assertEquals(actual, expected, "The result of comparision of expected and actual value of price");
	}

	@Test
	void testCheckImported() {
		boolean expected = true;
		boolean actual = book.checkImported();		
		assertEquals(expected, actual, "The result of comparision of expected and actual import status");
	}

	@Test
	void testGetImported() {
		double expected = ((double) 5 / (double) 100) * book.getOriginalPrice();
		double actual = book.getImportedTax();
		assertEquals(expected, actual, "The result of comparision of expected and actual value of imported tax");
	}
	
	
	@Test
	void testGetPriceAfterTaxForImportedItem() {
		book.setImported(true);
		double expected = book.getOriginalPrice() + ((double) 5 / (double) 100) * book.getOriginalPrice();
		double actual = book.getPriceAfterTax();
		assertEquals(expected, actual, "The result of comparision of expected and actual value of price after tax for an imported item");
	}

	@Test
	void testGetPriceAfterTax() {
		book.setImported(false);
		double expected = book.getOriginalPrice();
		double actual = book.getPriceAfterTax();
		assertEquals(expected, actual, "The result of comparision of expected and actual value of price after tax of an item that is not imported");
	}

	@Test
	void testIsBSTApplicable() {
		boolean status = book.isBSTApplicable();
		assertFalse(status, "The result of basic sales tax applicability on item.");
	}	
	
	@Test
	void testGetTotalTax() {
		book.setImported(false);
		double expected = 0;
		double actual = book.getTotalTax();
		assertEquals(expected, actual, "The result of comparision of total tax imposed on the item");
		
	}
	
	@Test
	void testGetTotalTaxImported() {
		book.setImported(true);
		double expected = book.getImportedTax();
		double actual = book.getTotalTax();
		assertEquals(expected, actual, "The result of comparision of total tax imposed on the item");
		
	}
}
