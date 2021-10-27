package com.itemis.salesTaxApp;

import java.io.IOException;
import java.util.Scanner;
import com.itemis.salesTaxApp.CustomException.InvalidInputException;
import com.itemis.salesTaxApp.Order.Order;


/**
 *This application provides an interface to take the order from the user and provide the receipt of the order. 
 *The receipt of the order consists of the price  of the item after adding the tax, total tax of the order and total amount.
 * 
 * @author Samundra karki
 * @version 1.0 
 */
public class SalesTaxApp 
{
	private int orderItem;

	private int quantity;
	private double price;
	private boolean importStatus;
	Order order;
	
	/**
	 * A no-arg constructor that initializes the the value of orderItem, quantity, price, import price and instantiates order class.
	 */
	public SalesTaxApp() {
		orderItem = 1;
		quantity = 1;
		price = 12.49;
		importStatus = false;
		order = new Order();
		
	}

	/**
	 * A parameterized constructor that sets the the value of orderItem, quantity, price, import price and order to the provided value.
	 */
    public SalesTaxApp(int orderItem, int quantity, double price, boolean importStatus, Order order) {
		super();
		this.orderItem = orderItem;
		this.quantity = quantity;
		this.price = price;
		this.importStatus = importStatus;
		this.order = order;
	}
    
    /**
     * Get the index of the item ordered
     * @return index of the item.
     */
    public int getOrderItem() {
		return orderItem;
	}
    
    /**
     * Get the price of the item ordered
     * @return price of the item.
     */
	public double getPrice() {
		return price;
	}

    /**
     * Get the quantity of the item ordered
     * @return quantity of the item.
     */
	public int getQuantity() {
		return quantity;
	}
    
    /**
     *  Checks if the entry message is Entry or Exit. If not then it throws InvalidInputException.
     * @param entryMessage string passed by the user to enter or quit the application.
     * @throws InvalidInputException 
     */
    public void invalidEntryMessageCheck(String entryMessage) throws InvalidInputException {
    	if(!(entryMessage.matches("Enter"))  && !(entryMessage.matches("Exit"))) {
			IOException err = new IOException();
			throw new InvalidInputException("The entry-input does not match to \"Enter\" or \"Exit\"", err);
		}
    }

    /**
     *  Checks if the chose item is available in the application. If the item is not available then it throws InvalidInputException.
     * @param itemChose item chose by the user.
     * @throws InvalidInputException 
     */
    public void invalidItemChoseCheck(double itemChose) throws InvalidInputException {
    	if(itemChose < 0 || itemChose > 6) {
			IOException err = new IOException();
			throw new InvalidInputException("The item-input value should be in the range of 1 to 6", err);
		}
    }
    
    /**
     *  Checks if the quantity passed by the customer is greater than or equal to 1. If quantity is not valid then it throws InvalidInputException.
     * @param entryMessage string passed by the user to enter or quit the application.
     * @throws InvalidInputException 
     */
    public void invalidQuantityCheck(int quantity) throws InvalidInputException {
    	if(quantity <= 0) {
			IOException err = new IOException();
			throw new InvalidInputException("The qunatity-input value should be a non negative number", err);
		}
    }
    
    /**
     *  Checks if the price passed by the customer is greater than or equal to 0.01. If quantity is not valid then it throws InvalidInputException.
     * @param entryMessage string passed by the user to enter or quit the application.
     * @throws InvalidInputException 
     */
    public void invalidPriceCheck(double price) throws InvalidInputException {
    	if(price <= 0.01) {
			IOException err = new IOException();
			throw new InvalidInputException("The price-input value should be a non negative number that is greater than or equal to 0.01", err);
		}
    }
    
	@SuppressWarnings("resource")
	public static void main( String[] args) throws IOException, InvalidInputException{
    	String entryExitInstruction = "Please type \"Enter\" to buy items. To exit type \"Exit\" the application.(without quotes)";
		String welcomeMessage = "Welcome to sales tax application. "
				+ "\nNOTE: Please read the instruction very carefully. If you pass an invalid input, the application will close without the desired output."
				+ "\nYou will be instructed to choose an item from the given list: "
				+ "\n1. Book \n2. Choclate Bar \n3. Choclate Box \n4. Packet of headache pills  \n5. Music CD \n6. Perfume  "
				+ "\nTo place an order, please type the index of the item you want to buy. For eg. type 1 to buy book, 2 to buy chocolate bar and so on. "
				+ "\nThen you need to give the quantity of the item, price of the item and import status of the item."
				+ "\nIf you don't want to buy anything, press 0 when asked to enter the item you want to buy.";
		String informationMessageItem = "Please enter the index of the item that you want to buy( enter 0 if you want to quit this application) :";
		String informationMessageAdditionalItem = "Do you want to buy more items? If yes, choose the item from list and enter the index of the item you want to buy."
				+ "\n1. Book \n2. Choclate Bar \n3. Choclate Box \n4. Packet of headache pills  \n5. Music CD \n6. Perfume "
				+ "\nElse, enter 0 to get your order and receipt of the order. ";
		String informationMessagePrice = "Please enter the price(we expect that you are paying some amount to purchase the item i.e. the price cannot be less than or equal to 0.01): ";
		String informationMessageQuantity = "Please enter the quantity of the item you are buying:";
		String informationMessageImportStatus = "Please type \"true\" if the item is imported else type \"false\"(without quotes): ";
		String exitInformation = "Thank you for using sales tax application.";
		
		System.out.println(entryExitInstruction);
		
		SalesTaxApp app = new SalesTaxApp();
		
		//using scanner object to get the result from user
		Scanner input = new Scanner(System.in);
		
		String status = input.nextLine();
		app.invalidEntryMessageCheck(status);
		
		// Ask if the customer want to enter or exit the application.
		if(status.matches("Exit")){
			System.out.println(exitInformation);
		}else {		
			System.out.println(welcomeMessage);
			System.out.println(informationMessageItem);	
			
			while(true) {			
				//Ask the customer what item they want to buy. 
				app.orderItem = input.nextInt();
				app.invalidItemChoseCheck(app.orderItem);
					
				//If customer don't want to anymore buy then 0 would exit the application.
				if(app.orderItem == 0) {
					if(app.order.getOrderItem().isEmpty()) {
						System.out.println(exitInformation);
					}else {
						app.order.dispalyOrder();
						app.order.displayReceipt();
					}
					break;
				}else {	
					//as customer for the quantity of the item they want to buy.
					System.out.println(informationMessageQuantity);
					app.quantity = input.nextInt();
					app.invalidQuantityCheck(app.quantity);

					//ask customer for the price of the item.
					System.out.println(informationMessagePrice);
					app.price = input.nextFloat();
					app.invalidPriceCheck(app.price);
						
					//ask customer is the item is imported or not.
					System.out.println(informationMessageImportStatus);
					app.importStatus = input.nextBoolean();
						
					//order the item.
					app.order.placeOrder(app.orderItem, app.price, app.importStatus, app.quantity);										
					
					//ask if user wants to buy more item.
					System.out.println(informationMessageAdditionalItem);
				}
			}			
		}
	}
}
