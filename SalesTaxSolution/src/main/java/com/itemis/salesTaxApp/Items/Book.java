package com.itemis.salesTaxApp.Items;


/**
 * Book is a concrete class that implements BSTEItems. This is an item that can be ordered from the application. 
 *
 */
public class Book implements BSTEItems {
	
	
	private double price;
	private boolean isImported;
	private int quantity;
	private final String name = "book";
	
	/**
	 * 
	 * A parameterized constructor that assigns the value of price, import status and quantity of book. 
	 * 
	 * @param price price of book
	 * @param isImported import status of book
	 * @param quantity quantity of book that is being ordered
	 */
	public Book(double price, boolean isImported, int quantity) {
		super();
		this.price = price;
		this.isImported = isImported;
		this.quantity = quantity;
	}
	
	/**
	 * Get the quantity of book 
	 * @return quantity of the book
	 */
	@Override 
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Set the quantity of book 
	 * @param quantity Quantity of the book
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Get the name of book 
	 * @return name of book
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Get the price of book 
	 * @return price of the book
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Set the price of the book
	 * @param price price of the book
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Get the import status of book 
	 * @return import status of book
	 */
	public boolean isImported() {
		return isImported;
	}
	
	/**
	 * Set the import status of book 
	 * @param isImported import status of book
	 */
	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}

	/**
	 * Get the original price of book. 
	 * @return price excluding the tax
	 */
	@Override
	public double getOriginalPrice() {
		return this.getPrice();
	}
	
	/**
	 * Checks if the item is imported or not 
	 * @return import status of the book
	 */
	@Override
	public boolean checkImported() {
		return this.isImported();
	}
	
	/**
	 * Calculates the import tax of the book
	 * @return import tax of the item
	 */
	@Override
	public double getImportedTax() {
		return (importedTax * this.getPrice());
	}
	
	/**
	 * Calculates the price including the tax of book
	 * @returns price including the tax of the book
	 */
	@Override
	public double getPriceAfterTax() {
		if(this.isImported() == true) {
			return (this.getOriginalPrice() + this.getImportedTax());	
		}
		else {
			return(this.getOriginalPrice() );
		}
	}
	/**
	 * Checks if basic sales tax is applicable or not for this item
	 * @return status of basic sales tax for this item.
	 */
	@Override
	public boolean isBSTApplicable() {
		return bstStatus;
	}

	/**
	 * Calculates total tax on this item
	 * @return total tax imposed for this item.
	 */
	@Override
	public double getTotalTax() {
		if(isImported()) {
			return this.getImportedTax();
		}else {
			return 0;
		}
	}

}
