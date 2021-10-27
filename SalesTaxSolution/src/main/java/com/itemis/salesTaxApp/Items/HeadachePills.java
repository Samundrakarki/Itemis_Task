package com.itemis.salesTaxApp.Items;


/**
 * HeadachePills is a concrete class that implements BSTEItems. This is an item that can be ordered from the application. 
 *
 */
public class HeadachePills implements BSTEItems {
	private double price;
	private boolean isImported;
	private int quantity;
	private final String name = "packet of headache pills";
	
	/**
	 * 
	 * A parameterized constructor that assigns the value of price, import status and quantity of HeadachePills. 
	 * 
	 * @param price price of HeadachePills
	 * @param isImported import status of HeadachePills
	 * @param quantity quantity of Chocolate that is being HeadachePills
	 */
	public HeadachePills(double price, boolean isImported, int quantity) {
		super();
		this.price = price;
		this.isImported = isImported;
		this.quantity = quantity;
	}

	/**
	 * Set the quantity of HeadachePills 
	 * @param quantity Quantity of the HeadachePills
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Get the price of HeadachePills 
	 * @return price of the HeadachePills
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Set the price of the HeadachePills
	 * @param price price of the HeadachePills
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Get the import status of HeadachePills 
	 * @return import status of HeadachePills
	 */
	public boolean isImported() {
		return isImported;
	}

	/**
	 * Set the import status of HeadachePills 
	 * @param isImported import status of HeadachePills
	 */
	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}
	
	/**
	 * Get the quantity of HeadachePills 
	 * @return quantity of the HeadachePills
	 */
	@Override 
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Get the name of HeadachePills 
	 * @return name of HeadachePills
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Get the original price of HeadachePills 
	 * @return price excluding the HeadachePills
	 */
	@Override
	public double getOriginalPrice() {
		return this.getPrice();
	}

	/**
	 * Checks if the item is imported or not 
	 * @return import status of the HeadachePills
	 */
	@Override
	public boolean checkImported() {
		return this.isImported();
	}

	/**
	 * Calculates the import tax of the HeadachePills
	 * @return import of the HeadachePills
	 */
	@Override
	public double getImportedTax() {
		return (importedTax * this.getPrice());
	}

	/**
	 * Calculates the price including the tax of HeadachePills
	 * @returns price including the tax of the HeadachePills
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
	 * Checks if basic sales tax is applicable or not for HeadachePills 
	 * @return status of basic sales tax for HeadachePills
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
