package com.itemis.salesTaxApp.Items;

/**
 * MusicCD is a concrete class that implements BSTItems. This is an item that can be ordered from the application. 
 *
 */
public class MusicCD implements BSTItems {
	private double price;
	private boolean isImported;
	private int quantity;
	private final String name = "music CD";
	
	/**
	 * 
	 * A parameterized constructor that assigns the value of price, import status and quantity of MusicCD. 
	 * 
	 * @param price price of MusicCD
	 * @param isImported import status of MusicCD
	 * @param quantity quantity of Chocolate that is being MusicCD
	 */
	public MusicCD(double price, boolean isImported, int quantity) {
		super();
		this.price = price;
		this.isImported = isImported;
		this.quantity = quantity;
	}

	/**
	 * Get the price of MusicCD 
	 * @return price of the MusicCD
	 */
	public double getPrice() {
		return price;
	}


	/**
	 * Set the price of the MusicCD
	 * @param price price of the MusicCD
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Get the import status of MusicCD 
	 * @return import status of MusicCD
	 */
	public boolean isImported() {
		return isImported;
	}

	/**
	 * Set the import status of MusicCD 
	 * @param isImported import status of MusicCD
	 */
	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}
	
	/**
	 * Set the quantity of MusicCD 
	 * @param quantity Quantity of the MusicCD
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Get the quantity of MusicCD 
	 * @return quantity of the MusicCD
	 */
	@Override
	public int getQuantity() {
		return quantity;
	}
	/**
	 * Get the name of MusicCD 
	 * @return name of MusicCD
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Get the original price of MusicCD 
	 * @return price excluding the MusicCD
	 */
	@Override
	public double getOriginalPrice() {
		return this.getPrice();
	}

	/**
	 * Checks if the item is imported or not 
	 * @return import status of the MusicCD
	 */
	@Override
	public boolean checkImported() {
		return this.isImported();
	}

	/**
	 * Calculates the import tax of the MusicCD
	 * @return import tax of the MusicCD
	 */
	@Override
	public double getImportedTax() {
		return (importedTax * this.getPrice());
	}
	
	/**
	 * Calculates the basic sales tax of the MusicCD
	 * @return basic sales tax of the MusicCD
	 */
	@Override
	public double getBasicTax() {
		return (basicTax * this.getOriginalPrice());
	}
	
	/**
	 * Calculates the price including the tax of MusicCD
	 * @returns price including the tax of the MusicCD
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
	 * Checks if basic sales tax is applicable or not for MusicCD 
	 * @return status of basic sales tax for MusicCD
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
