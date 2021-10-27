package com.itemis.salesTaxApp.Items;

/**
 * Items is an interface that is  implemented by class that is an item that can be ordered from the application. 
 * @author Samundra karki
 */

public interface Items {
	
	/**
	 * Get the original price i.e. excluding the taxes of an item. This method is implemented by all of the item that can be ordered and is called in Order class.  
	 * @return price excluding the item
	 */
	public double getOriginalPrice();
	
	/**
	 * Checks if an item is imported or not. This method is implemented by all of the item that can be ordered and is called in Order class 
	 * @return import status of the item
	 */
	public boolean checkImported();
	
	/**
	 * Calculates the price including the tax of the item. This method is implemented by all of the item that can be ordered and is called in Order class
	 * @returns price including the tax of the item
	 */
	public double getPriceAfterTax();
	
	/**
	 * Get the quantity of the item.  This method is implemented by all of the item that can be ordered and is called in Order class
	 * @return quantity of the item
	 */
	public int getQuantity();
	
	/**
	 * Get the name of the item.  This method is implemented by all of the item that can be ordered and is called in Order class
	 * @return name of the item
	 */
	public String getName();
	
	/**
	 * Calculates the import tax of the item. This method is implemented by all of the item that can be ordered and is called in Order class
	 * @return import tax of the item
	 */
	public double getImportedTax();
	
	/**
	 * Calculates the total tax imposed on the item. This method is implemented by all of the item that can be ordered and is called in Order class
	 * @return total tax of the item
	 */
	public double getTotalTax();
	
	
	/**
	 * Checks if basic sales tax is applicable or not for the item. This method is implemented by all of the item that can be ordered and is called in Order class
	 * @return status of basic sales tax applicability for an item.
	 */
	public boolean isBSTApplicable();
}
