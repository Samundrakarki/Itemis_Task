package com.itemis.salesTaxApp.Items;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MusicCDTest {

	MusicCD musicCD;
		
		@BeforeEach
		void setUp() throws Exception {
			musicCD = new MusicCD(15, false, 5);
		}
	
		@Test
		void setQuantityTest() {
			musicCD.setQuantity(10);
			int expected = 10;
			int actual = musicCD.getQuantity();
			assertEquals(actual, expected, "The result of setter method of quantity");
		}
		
		@Test
		void getQuantityTest() {
			int expected = 5;
			int actual = musicCD.getQuantity();
			assertEquals(actual, expected, "THe result of getter method of quantity");
		
		}
		void testSetPrice() {
			musicCD.setPrice(17.05);
			double expected = 17.05;
			double actual = musicCD.getPrice();
			assertEquals(expected, actual, "The result of comparision of expected and actual value of price");	
		}
		
		@Test 
		void testGetPrice() {
			double expected = 15;
			double actual = musicCD.getPrice();
			assertEquals(expected, actual, "The result of comparision of expected and actual value of price");
		}
		

		@Test
		void testsetImported() {
			musicCD.setImported(true);
			boolean expected = true;
			boolean actual = musicCD.isImported();
			assertEquals(actual, expected, "The result of comparision of expected and actual import status");
		}

		@Test
		void testIsImported() {
			boolean expected = false;
			boolean actual = musicCD.isImported();		
			assertEquals(expected, actual, "The result of comparision of expected and actual import status");
		}
		
		@Test
		void testGetName() {
			String expected = "music CD";
			String actual = musicCD.getName();
			assertEquals(expected, actual, "The result of comparision of expected and actual name of the item");
		}
		
		@Test
		void testGetOriginalPrice() {
			double expected = 15;
			double actual = musicCD.getOriginalPrice();
			assertEquals(actual, expected, "The result of comparision of expected and actual value of price");
		}

		@Test
		void testCheckImported() {
			boolean expected = false;
			boolean actual = musicCD.checkImported();		
			assertEquals(expected, actual, "The result of comparision of expected and actual import status");
		}

		@Test
		void testGetImported() {
			double expected = ((double) 5 / (double) 100) * musicCD.getOriginalPrice();
			double actual = musicCD.getImportedTax();
			assertEquals(expected, actual, "The result of comparision of expected and actual value of imported tax");
		}
		
		@Test
		void testGetBasicTax() {
			double expected = ((double) 10 / (double) 100) * musicCD.getOriginalPrice();
			double actual = musicCD.getBasicTax();
			assertEquals(actual, expected, "The result of comparision of expected and actual value of basic sales tax");
		
		}
		
		@Test
		void testGetPriceAfterTaxForImportedItem() {
			musicCD.setImported(true);
			double expected = musicCD.getOriginalPrice() + ((double) 5 / (double) 100) * musicCD.getOriginalPrice() + ((double) 10 / (double) 100) * musicCD.getOriginalPrice();
			double actual = musicCD.getPriceAfterTax();
			assertEquals(expected, actual, "The result of comparision of expected and actual value of price after tax for an imported item");
		}

		@Test
		void testGetPriceAfterTax() {
			double expected = musicCD.getOriginalPrice() + ((double) 10 / (double) 100) * musicCD.getOriginalPrice();
			double actual = musicCD.getPriceAfterTax();
			assertEquals(expected, actual, "The result of comparision of expected and actual value of price after tax of an item that is not imported");
		}

		@Test
		void testIsBSTApplicable() {
			boolean status = musicCD.isBSTApplicable();
			assertTrue(status, "The result of basic sales tax applicability on item.");
			
		}
		
		@Test
		void testGetTotalTax() {
			musicCD.setImported(false);
			double expected = musicCD.getBasicTax();
			double actual = musicCD.getTotalTax();
			assertEquals(expected, actual, "The result of comparision of total tax imposed on the item");	
		}
		
		@Test
		void testGetTotalTaxImported() {
			musicCD.setImported(true);
			double expected = musicCD.getBasicTax() + musicCD.getImportedTax();
			double actual = musicCD.getTotalTax();
			assertEquals(expected, actual, "The result of comparision of total tax imposed on the item");	
		}
}
