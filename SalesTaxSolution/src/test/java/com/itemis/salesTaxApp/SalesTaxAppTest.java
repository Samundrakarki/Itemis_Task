package com.itemis.salesTaxApp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.itemis.salesTaxApp.CustomException.InvalidInputException;
import com.itemis.salesTaxApp.Order.Order;

class SalesTaxAppTest {

	@Test
	void testGetOrderItem() {
		SalesTaxApp app = new SalesTaxApp();
		int expected = 1;
		assertEquals(expected, app.getOrderItem(), "The result of comparision of expected and actual order item");
	}
	
	@Test
	void testGetQuantity() {
		SalesTaxApp app = new SalesTaxApp();
		int expected = 1;
		assertEquals(expected, app.getQuantity(), "The result of comparision of expected and actual quantitiy of the ordered item");
	}
	
	@Test
	void testGetPrice() {
		SalesTaxApp app = new SalesTaxApp();
		double expected = 12.49;
		assertEquals(expected, app.getPrice(), "The result of comparision of expected and actual order item");
	}
	
	@Test
	void testInvalidEntryMessageCheckInvalidInput() throws InvalidInputException {
		final SalesTaxApp app = new SalesTaxApp();
		InvalidInputException exception = assertThrows(InvalidInputException.class, () -> 
														{app.invalidEntryMessageCheck(" ");});
		assertEquals("The entry-input does not match to \"Enter\" or \"Exit\"", exception.getMessage());
	}
	
	@Test
	void testInvalidEntryMessageCheckVaidInputEnter() throws InvalidInputException {
		final SalesTaxApp app = new SalesTaxApp();
		assertDoesNotThrow(() ->{app.invalidEntryMessageCheck("Enter");});
	}
	
	@Test
	void testInvalidEntryMessageCheckValidInputExit() throws InvalidInputException {
		final SalesTaxApp app = new SalesTaxApp();
		assertDoesNotThrow(() ->  {app.invalidEntryMessageCheck("Exit");});
	}
	
	
	@Test
	void testInvalidItemChoseCheckInvalidInput() throws InvalidInputException {
		final SalesTaxApp app = new SalesTaxApp(9, 1, 12.22, false, new Order());
		InvalidInputException exception = assertThrows(InvalidInputException.class, () -> 
														{app.invalidItemChoseCheck(app.getOrderItem());});
		assertEquals("The item-input value should be in the range of 1 to 6", exception.getMessage());
	}
	
	@Test
	void testInvalidItemChoseCheckValidInput() throws InvalidInputException {
		final SalesTaxApp app = new SalesTaxApp(5, 1, 12.22, false, new Order());
		assertDoesNotThrow(() -> {app.invalidItemChoseCheck(app.getOrderItem());});
	}
	
	@Test
	void testInvalidQuantityCheckInvalidInput() throws InvalidInputException {
		final SalesTaxApp app = new SalesTaxApp(1, 0, 12.22, false, new Order());
		InvalidInputException exception = assertThrows(InvalidInputException.class, () -> 
														{app.invalidQuantityCheck(app.getQuantity());});
		assertEquals("The qunatity-input value should be a non negative number", exception.getMessage());
	}
	
	@Test
	void testInvalidQuantityCheckValidInput() throws InvalidInputException {
		final SalesTaxApp app = new SalesTaxApp(1, 2, 12.22, false, new Order());
		assertDoesNotThrow(() -> {app.invalidQuantityCheck(app.getQuantity());});
	}
	
	@Test
	void testInvalidPriceCheckInvalidInput() throws InvalidInputException {
		final SalesTaxApp app = new SalesTaxApp(1, 1, 0, false, new Order());
		InvalidInputException exception = assertThrows(InvalidInputException.class, () -> 
														{app.invalidPriceCheck(app.getPrice());});
		assertEquals("The price-input value should be a non negative number that is greater than or equal to 0.01", exception.getMessage());
	}
	
	@Test
	void testInvalidPriceCheckValidInput() throws InvalidInputException {
		final SalesTaxApp app = new SalesTaxApp(1, 1, 15.49, false, new Order());
		assertDoesNotThrow(() -> {app.invalidPriceCheck(app.getPrice());});
	}

}
	