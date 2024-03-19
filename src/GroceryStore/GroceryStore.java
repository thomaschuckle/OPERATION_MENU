/* Student Name: Vi Tuan Ha
 * Lab Professor: Howard Rosenblum
 * Due Date: February 7th, 2024
 * Description: Assignment 01
 */

package GroceryStore;

import java.util.*;
import InventoryManager.*;
import inventoryexception.*;

public class GroceryStore {
	private String[][] inv_data;
	Scanner sc = new Scanner(System.in);
	
	public GroceryStore(String[][] inv_data) {
		this.inv_data = inv_data;
	}
	
	public void displayInventory() {
		for(int i=0; i<inv_data.length; i++) {
			System.out.printf("%s: %s\n", inv_data[i][0], inv_data[i][1]);
		}
	}
	
	public void purchaseItems() throws InputMismatchException {
		boolean finished = false; //Loop control variable
		int current_amount;
		int amount_update = 0;
		int final_amount;
		
		do {
			System.out.print("Enter item name to purchase or 'exit' to exit: ");
			String a = sc.next().toLowerCase();
			if(a.equalsIgnoreCase("exit")) {
				finished = true; //Exit loop if user type "exit"
			}else {
				int index = InventoryManager.findItemIndex(inv_data, a); //find item index using method created in InventoryManager class.
				if(index>=0) {
					current_amount = Integer.valueOf(inv_data[index][1]); 
					boolean finished2 = false; //Second loop control variable.
					do {
						System.out.print("Enter the quantity to purchase: ");
						try {
							amount_update = sc.nextInt();
							final_amount = current_amount - amount_update;
							if(final_amount>=0) {
								InventoryManager.updateInventory(inv_data, index, final_amount);
								System.out.println("Purchase Successful! Updated Inventory: ");
								displayInventory();
								finished2 = true;
								finished = true;
							}else {
								System.out.println("Not enough stock, please lower your purchase amount.");
							}
						}catch(InputMismatchException ime) {
							InventoryException ie = new InventoryException("Invalid purchase amount, please try again"); //Creating new Exception object if caught.
							System.out.println(ie.getMessage()); //Get error message of the Exception object and print it out.
							sc.nextLine(); //Refresh scanner.
						}
					}while(!finished2);
		
				}else {
					System.out.println("Invalid Item Name, Please Try Again");
					sc.nextLine();
				}
			}
		}while(!finished);
	}
	
	public void restockItems() throws InputMismatchException {
		boolean finished = false;
		int current_amount;
		int amount_update = 0;
		int final_amount;
		
		do {
			System.out.print("Enter item name to restock or 'exit' to exit: ");
			String a = sc.next().toLowerCase();
			if(a.equalsIgnoreCase("exit")) {
				finished = true;
			}else {
				int index = InventoryManager.findItemIndex(inv_data, a);
				if(index>=0) {
					current_amount = Integer.valueOf(inv_data[index][1]);
					boolean finished2 = false;
					do {
						System.out.print("Enter the quantity to restock: ");
						try {
							amount_update = sc.nextInt();
							final_amount = current_amount + amount_update;
							if(amount_update>=0) {
								InventoryManager.updateInventory(inv_data, index, final_amount);
								System.out.println("Restock Successful! Updated Inventory: ");
								displayInventory();
								finished2 = true;
								finished = true;
							}else {
								System.out.println("Invalid restock amount, please enter positive quantity.");
							}
						}catch(InputMismatchException ime) {
							InventoryException ie = new InventoryException("Invalid restock amount, please try again");
							System.out.println(ie.getMessage());
							sc.nextLine();
						}
					}while(!finished2);
		
				}else {
					System.out.println("Invalid Item Name, Please Try Again");
					sc.nextLine();
				}
			}
		}while(!finished);
	}
	
	public void manageInventory() {
		boolean finished = false;
		
		do {
			operationsMenu(); //Calls operationsMenu().
			try {
				int a = sc.nextInt(); //Get user input.
				switch(a) {
				case 1:
					purchaseItems(); //Go to purchaseItems()
					break;
				case 2: 
					restockItems(); //Go to restockItems()
					break;
				case 3: 
					finished = true;
					sc.close(); //Close keyboard.
					System.exit(1); //Exit program when user finishes.
					break;
				default: 
					System.out.println("Invalid Entry: Enter an integer between 1 and 3\n");
					break;
					}
			}catch(InputMismatchException ime) {
				InventoryException ie = new InventoryException("Invalid Entry: Enter an integer between 1 and 3\n"); //Creating new Exception object if caught 
				System.out.println(ie.getMessage());
				sc.nextLine();
			}
		}while(!finished);
	}
	
	public void operationsMenu() {
		System.out.print("Menu:\n 1. Purchase Items\n 2. Restock Items\n 3. Exit\nChoose an option: "); //Prints out menu options for user.
	}

}