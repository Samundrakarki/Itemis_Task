package com.itemis.salesTaxApp.Order;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.itemis.salesTaxApp.Items.*;

class OrderTest {

	Order order;
	ArrayList<Items> orderItems;
	
	@BeforeEach
	void setUp() throws Exception {
		orderItems = new ArrayList<Items>();
		order = new Order(orderItems, 0, 0);
	}

	@Test
	void testPlaceOrderForCaseOne() {
		order.placeOrder(1, 12, false, 2);
		
		double expectedPrice = 12;
		boolean expectedImportStatus = false;
		int  expectedQuantity = 2;
		
		double actualPrice = orderItems.get(0).getOriginalPrice();
		boolean actualImportStatus = orderItems.get(0).checkImported();
		int actualQuantity = orderItems.get(0).getQuantity();
		
		assertTrue(orderItems.get(0) instanceof Book, "The result should be an instance of book" );
		assertEquals(expectedPrice, actualPrice, "The result of comprision between expected and actual price of the item");
		assertEquals(expectedImportStatus, actualImportStatus, "The result of comprision between expected and actual import of the item");
		assertEquals(expectedQuantity, actualQuantity, "The result of comprision between expected and actual quantity of the item");
	}
	
	@Test
	void testPlaceOrderForCaseTwo() {
		order.placeOrder(2, 12, false, 2);
		
		double expectedPrice = 12;
		boolean expectedImportStatus = false;
		int  expectedQuantity = 2;
		
		double actualPrice = orderItems.get(0).getOriginalPrice();
		boolean actualImportStatus = orderItems.get(0).checkImported();
		int actualQuantity = orderItems.get(0).getQuantity();
		
		assertTrue(orderItems.get(0) instanceof ChocolateBar, "The result should be an instance of chocolate" );
		assertEquals(expectedPrice, actualPrice, "The result of comprision between expected and actual price of the item");
		assertEquals(expectedImportStatus, actualImportStatus, "The result of comprision between expected and actual import of the item");
		assertEquals(expectedQuantity, actualQuantity, "The result of comprision between expected and actual quantity of the item");
	}
	
	@Test
	void testPlaceOrderForCaseThree() {
		order.placeOrder(3, 12, false, 2);
		
		double expectedPrice = 12;
		boolean expectedImportStatus = false;
		int  expectedQuantity = 2;
		
		double actualPrice = orderItems.get(0).getOriginalPrice();
		boolean actualImportStatus = orderItems.get(0).checkImported();
		int actualQuantity = orderItems.get(0).getQuantity();
		
		assertTrue(orderItems.get(0) instanceof ChocolateBox, "The result should be an instance of book" );
		assertEquals(expectedPrice, actualPrice, "The result of comprision between expected and actual price of the item");
		assertEquals(expectedImportStatus, actualImportStatus, "The result of comprision between expected and actual import of the item");
		assertEquals(expectedQuantity, actualQuantity, "The result of comprision between expected and actual quantity of the item");
	}
	
	@Test
	void testPlaceOrderForCaseFour() {
		order.placeOrder(4, 12, false, 2);
		
		double expectedPrice = 12;
		boolean expectedImportStatus = false;
		int  expectedQuantity = 2;
		
		double actualPrice = orderItems.get(0).getOriginalPrice();
		boolean actualImportStatus = orderItems.get(0).checkImported();
		int actualQuantity = orderItems.get(0).getQuantity();
		
		assertTrue(orderItems.get(0) instanceof HeadachePills, "The result should be an instance of book" );
		assertEquals(expectedPrice, actualPrice, "The result of comprision between expected and actual price of the item");
		assertEquals(expectedImportStatus, actualImportStatus, "The result of comprision between expected and actual import of the item");
		assertEquals(expectedQuantity, actualQuantity, "The result of comprision between expected and actual quantity of the item");
	}
	
	@Test
	void testPlaceOrderForCaseFive() {
		order.placeOrder(5, 12, false, 2);
		
		double expectedPrice = 12;
		boolean expectedImportStatus = false;
		int  expectedQuantity = 2;
		
		double actualPrice = orderItems.get(0).getOriginalPrice();
		boolean actualImportStatus = orderItems.get(0).checkImported();
		int actualQuantity = orderItems.get(0).getQuantity();
		
		assertTrue(orderItems.get(0) instanceof MusicCD, "The result should be an instance of book" );
		assertEquals(expectedPrice, actualPrice, "The result of comprision between expected and actual price of the item");
		assertEquals(expectedImportStatus, actualImportStatus, "The result of comprision between expected and actual import of the item");
		assertEquals(expectedQuantity, actualQuantity, "The result of comprision between expected and actual quantity of the item");
	}
	
	@Test
	void testPlaceOrderForCaseSix() {
		order.placeOrder(6, 12, false, 2);
		
		double expectedPrice = 12;
		boolean expectedImportStatus = false;
		int  expectedQuantity = 2;
		
		double actualPrice = orderItems.get(0).getOriginalPrice();
		boolean actualImportStatus = orderItems.get(0).checkImported();
		int actualQuantity = orderItems.get(0).getQuantity();
		
		assertTrue(orderItems.get(0) instanceof Perfume, "The result should be an instance of book" );
		assertEquals(expectedPrice, actualPrice, "The result of comprision between expected and actual price of the item");
		assertEquals(expectedImportStatus, actualImportStatus, "The result of comprision between expected and actual import of the item");
		assertEquals(expectedQuantity, actualQuantity, "The result of comprision between expected and actual quantity of the item");
	}
	
	@Test
	void testCalcuateTotalTax() {
		orderItems.add(new Book(12.99, true, 3));
		orderItems.add(new MusicCD(35.0, false, 1));
		double actual = order.getTotalTax();
		
		double expected = 0;
		
		//should add a method getTax that returns total tax on the item
		for(Items items : orderItems) {
			expected += items.getTotalTax();
		}
		assertEquals(expected, actual, "The result of the method that should return total tax of the item");
		
		
	}
	
	@Test
	void testCalcuateTotalPrice() {
		orderItems.add(new Book(12.99, true, 3));
		orderItems.add(new MusicCD(35.0, false, 1));
		double actual = order.getTotalPrice();
		
		double expected = 0;
		
		//should add a method getTax that returns total tax on the item
		for(Items items : orderItems) {
			expected += items.getPriceAfterTax();
		}
		assertEquals(expected, actual, "The result of the method that should return total tax of the item");		
	}
	
	

}
