
//adding file to InventoryManager package.
package InventoryManager;

public class InventoryManager {
	
	public static int findItemIndex(String[][] ss, String s) {
		int j = -1; //Setting j = -1, return this if not found item index.
		for(int i=0; i<ss.length; i++) {
			if(ss[i][0].equalsIgnoreCase(s)) {
				j = i; //if found item name inside the inventory, set j to the item index.
			}
		}
		return j;
	}
	
	public static void updateInventory(String[][] ss, int index, int amount) {
			String a = String.valueOf(amount); //Type casting the integer to string.
			ss[index][1] = a; //Setting the type casted integer to be the value of the item based on the index.
	}
}

//This class does not need a constructor as the methods are static and can be called without creating an object.
