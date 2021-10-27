package com.itemis.salesTaxApp.Order;

import java.util.ArrayList;

import com.itemis.salesTaxApp.Items.*;


/**
 * Order class is concrete class which allows the user application to create an instance of the item that is ordered. This class consists of the method that 
 * calculates total price and total tax of the order placed by a costumer. 
 * 
 * @author Samundra karki
 * @since 1.0
 *
 */
public class Order {


	private ArrayList<Items> orderItem;
	private double totalTax;
	private double totalPrice;
	
	/**
	 * A no-arg constructor which instantiates ArrayList of Items object and initializes totalTax and totalPrice to zero.
	 * 
	 */
	public Order() {
		orderItem = new ArrayList<Items>();
		totalTax = 0;
		totalPrice = 0;
	}
	
	/**
	 * A parameterized constructor which instantiates ArrayList of Items object and initializes totalTax and totalPrice to the given values.
	 * 
	 */
	public Order(ArrayList<Items> orderItem, double totalTax, double totalPrice) {
		super();
		this.orderItem = orderItem;
		this.totalTax = totalTax;
		this.totalPrice = totalPrice;
	}
	
	/**
	 * Place the order requested by the customer. Instantiates the item requested by the user.
	 * 
	 * @param item item to be ordered. 
	 * @param price price of the item that is ordered.
	 * @param isImported  imported status of the item.
	 * @param quantity quantity to be ordered.
	 */
	public void placeOrder(int item, double price, boolean isImported, int quantity) {
		switch(item) {
			case 1:
				orderItem.add(new Book(price, isImported, quantity)); 
				break;
			case 2:
				orderItem.add(new ChocolateBar(price, isImported, quantity));
				 break;
			case 3:
				orderItem.add(new ChocolateBox(price, isImported, quantity));
				 break;
			case 4:
				orderItem.add(new HeadachePills(price, isImported, quantity));
				 break;
			case 5:
				orderItem.add(new MusicCD(price, isImported, quantity)); 
				break;
			case 6:
				orderItem.add(new Perfume(price, isImported, quantity));
				 break;
		}
	}
	
	/**
	 * Getter method for ArrayList of the items ordered. This method is useful in test as orderItem is a private privilege, so we need to add getter method. 
	 * @return return the ArrayList of the items that has been ordered. 
	 */
	public ArrayList<Items> getOrderItem() {
		return orderItem;
	}
	
	
	/**
	 * Calculates the total tax of order. The basic tax and import tax of item of the ArrayList(Ordered items) is summed. 
	 * @return total tax of the ordered item. 
	 */
	public double getTotalTax() {
		for(Items item:orderItem) {
				this.totalTax += item.getTotalTax();

		}
		return this.totalTax;
	}

	/**
	 * Calculates the total price of order. 
	 * 
	 * @return total price of the ordered item. 
	 */
	public double getTotalPrice() {
		for(Items item:orderItem) {
			this.totalPrice += item.getPriceAfterTax();
		}
		return this.totalPrice;
	}
	
	/**
	 * Displays the receipt of the order. In order to set precision of the floating point number, I used Math.round(floatValue * 100.00) / 100.00.
	 * . 
	 */
	public void displayReceipt() {
		System.out.println("Your Recipt:");
		for(Items item :orderItem) {
			if(item.checkImported() == true) {
				System.out.println(item.getQuantity() + " imported " + item.getName() +" : " + (Math.round(item.getPriceAfterTax() * 100.00) / 100.00));
			}else {
				System.out.println(item.getQuantity() + " " + item.getName() +" : " + (Math.round(item.getPriceAfterTax() * 100.00) / 100.00));
			}
		}
		System.out.println("Toal tax : " + (Math.round(this.getTotalTax() * 100.00) / 100.00));
		System.out.println("Total price : " + (Math.round(this.getTotalPrice() * 100.00) /100.00));
	}
	

	/**
	 * Displays the order of the customer. In order to set precision of the floating point number, I used Math.round(floatValue * 100.00) / 100.00. 
	 * . 
	 */
	public void dispalyOrder() {
		System.out.println("Your Order:");
		for(Items item : orderItem) {
				if(item.checkImported() == true) {
					System.out.println(item.getQuantity() + " imported " + item.getName() + " at " + (Math.round(item.getOriginalPrice() * 100.00) / 100.00));	
				}else {
					System.out.println(item.getQuantity() + " " + item.getName() + " at " + (Math.round(item.getOriginalPrice() * 100.00) / 100.00));
				}	
		}
	}
}
	