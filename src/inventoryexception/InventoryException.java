/* Student Name: Vi Tuan Ha
 * Lab Professor: Howard Rosenblum
 * Due Date: February 7th, 2024
 * Description: Assignment 01
 */

package inventoryexception;

public class InventoryException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //Eclipse suggest adding this to avoid warning: "The serializable class InventoryException does not declare a static final serialVersionUID field of type long".
	
	//Constructor for the parent (Exception) class, accept one argument which is the error message.
	public InventoryException(String e) {
		super(e); 
	}
}
