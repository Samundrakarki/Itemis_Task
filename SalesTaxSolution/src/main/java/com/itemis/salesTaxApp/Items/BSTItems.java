package com.itemis.salesTaxApp.Items;

/**
 * (BasicSalesTax) BSTItems class is an interface that is  implemented by the classes that needs to pay the basic salex tax. 
 * 
 * @author Samundra karki
 *
 */
public interface BSTItems extends Items {
	
		double importedTax =(double) 5 / (double) 100;
		double basicTax = (double)10 / (double) 100;
		boolean bstStatus = true; 
		
		/**
		 * Calculates the basic sales tax of the item.  
		 * 
		 * @return basic sales tax of an item. 
		 *
		 */
		public double getBasicTax();

}
