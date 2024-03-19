
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
