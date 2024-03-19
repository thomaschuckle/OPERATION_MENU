/* Student Name: Vi Tuan Ha
 * Lab Professor: Howard Rosenblum
 * Due Date: February 7th, 2024
 * Description: Assignment 01
 */

package testinventory;

import GroceryStore.*;

public class TestInventoryApp {
	//Main method for calling display inventory and manage inventory.
	public static void main(String[] args) {
		String[][] inv_data = {{"Broccoli", "14"}, {"Sausages", "35"}, {"Bread", "50"}, {"Tortilla", "40"}, {"Eggs", "48"}};
		GroceryStore inv = new GroceryStore(inv_data);
		inv.displayInventory();
		inv.manageInventory();
	}
}
