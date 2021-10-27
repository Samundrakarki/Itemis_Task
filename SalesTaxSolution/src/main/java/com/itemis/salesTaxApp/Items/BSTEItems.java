package com.itemis.salesTaxApp.Items;

/**
 * (BasicSalesTaxExcluded) BSTEItems is an interface that is  implemented by the classes that needs to pay the basic salex tax. 
 * 
 * @author Samundra karki
 *
 */

public interface BSTEItems extends Items {
	
	double importedTax =(double) 5 / (double) 100;
	boolean bstStatus = false;

}
