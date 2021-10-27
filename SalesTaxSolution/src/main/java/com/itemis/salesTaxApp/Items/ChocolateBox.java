package com.itemis.salesTaxApp.Items;


/**
 * ChocolateBox is a concrete class that implements BSTEItems. This is an item that can be ordered from the application. 
 *
 */
public class ChocolateBox implements BSTEItems {
	private double price;
	private boolean isImported;
	private int quantity;
	private final String name = "box of chocolates";

	/**
	 * 
	 * A parameterized constructor that assigns the value of price, import status and quantity of Chocolate. 
	 * 
	 * @param price price of Chocolate
	 * @param isImported import status of Chocolate
	 * @param quantity quantity of Chocolate that is being ordered
	 */
	public ChocolateBox(double price, boolean isImported, int quantity) {
		super();
		this.price = price;
		this.isImported = isImported;
		this.quantity = quantity;
	}
	
	/**
	 * Get the quantity of Chocolate 
	 * @return quantity of the Chocolate
	 */
	@Override 
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Set the quantity of Chocolate 
	 * @param quantity Quantity of the Chocolate
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Get the name of Chocolate 
	 * @return name of Chocolate
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Get the price of Chocolate 
	 * @return price of the Chocolate
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Set the price of the Chocolate
	 * @param price price of the Chocolate
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Get the import status of Chocolate 
	 * @return import status of Chocolate
	 */
	public boolean isImported() {
		return isImported;
	}
	
	/**
	 * Set the import status of Chocolate 
	 * @param isImported import status of Chocolate
	 */
	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}
	
	/**
	 * Get the original price of Chocolate
	 * @return price excluding the Chocolate
	 */
	@Override
	public double getOriginalPrice() {
		return this.getPrice();
	}

	/**
	 * Checks if the item is imported or not 
	 * @return import status of the Chocolate
	 */
	@Override
	public boolean checkImported() {
		return this.isImported();
	}

	/**
	 * Calculates the import tax of the Chocolate
	 * @return import of the Chocolate
	 */
	@Override
	public double getImportedTax() {
		return (importedTax * this.getPrice());
	}

	/**
	 * Calculates the price including the tax of Chocolate
	 * @returns price including the tax of the Chocolate
	 */
	@Override
	public double getPriceAfterTax() {
		if(this.isImported() == true) {
			return (this.getOriginalPrice() + this.getImportedTax());	
		}
		else {
			return(this.getOriginalPrice());
		}
	}
	
	/**
	 * Checks if basic sales tax is applicable or not for Chocolate 
	 * @return status of basic sales tax for Chocolate
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
