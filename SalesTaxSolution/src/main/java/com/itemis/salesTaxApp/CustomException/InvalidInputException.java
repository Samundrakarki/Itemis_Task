package com.itemis.salesTaxApp.CustomException;

import java.io.IOException;

/**
 *InvalidInputException concrete class that implements the IOException. This custom exception is thrown if user passes invalid input. In the context of this application, the user
 *should get this exception if they give the input value that cannot be handled by application. For e.g. passing -10 for quantity in SalesTaxApp class.
 * 
 * @author Samundra karki
 * @version 1.0 
 */
@SuppressWarnings("serial")
public class InvalidInputException extends IOException {
	/**
	 * A parameterized constructor of the InvalidInputExceptionClass
	 * @param errorMessage the message to indicate the cause of the exception
	 * @param err throwable error instance
	 */
	public InvalidInputException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
