package com.itemis.salesTaxApp.Items;

/**
 * Perfume is a concrete class that implements BSTItems. This is an item that can be ordered from the application. 
 *
 */
public class Perfume implements BSTItems {
	private double price;
	private boolean isImported;
	private int quantity;
	private final String name = "bottle of perfume";

	/**
	 * 
	 * A parameterized constructor that assigns the value of price, import status and quantity of Perfume. 
	 * 
	 * @param price price of Perfume
	 * @param isImported import status of Perfume
	 * @param quantity quantity of Chocolate that is being Perfume
	 */
	public Perfume(double price, boolean isImported, int quantity) {
		super();
		this.price = price;
		this.isImported = isImported;
		this.quantity = quantity;
	}

	/**
	 * Set the quantity of Perfume 
	 * @param quantity Quantity of the Perfume
	 */
	public void setQuanitity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Get the price of Perfume 
	 * @return price of the Perfume
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Set the price of the Perfume
	 * @param price price of the Perfume
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Get the import status of Perfume 
	 * @return import status of Perfume
	 */
	public boolean isImported() {
		return isImported;
	}

	/**
	 * Set the import status of Perfume 
	 * @param isImported import status of Perfume
	 */
	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}
	
	/**
	 * Get the name of Perfume 
	 * @return name of Perfume
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/**
	 * Get the quantity of Perfume 
	 * @return quantity of the Perfume
	 */
	@Override
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Get the original price of Perfume 
	 * @return price excluding the Perfume
	 */
	@Override
	public double getOriginalPrice() {
		return this.getPrice();
	}

	/**
	 * Checks if the item is imported or not 
	 * @return import status of the Perfume
	 */
	@Override
	public boolean checkImported() {
		return this.isImported();
	}

	/**
	 * Calculates the import tax of the Perfume
	 * @return import tax of the Perfume
	 */
	@Override
	public double getImportedTax() {
		return (importedTax * this.getPrice());
	}
	
	/**
	 * Calculates the basic sales tax of the Perfume
	 * @return basic sales tax of the Perfume
	 */
	@Override
	public double getBasicTax() {
		return (basicTax * this.getOriginalPrice());
	}
	
	/**
	 * Calculates the price including the tax of Perfume
	 * @returns price including the tax of the Perfume
	 */
	@Override
	public double getPriceAfterTax() {
		if(this.isImported() == true) {
			return (this.getOriginalPrice() + this.getImportedTax() + this.getBasicTax());	
		}
		else {
			return(this.getOriginalPrice() + this.getBasicTax());
		}
	}

	/**
	 * Checks if basic sales tax is applicable or not for Perfume 
	 * @return status of basic sales tax for Perfume
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
			return this.getBasicTax() + this.getImportedTax();
		}else {
			return this.getBasicTax();
		}
	}


}
