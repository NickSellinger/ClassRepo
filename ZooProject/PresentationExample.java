import java.lang.*;

class UserInterface{
	String itemName = new String;
	double itemPrice = new double;
	public static void main(String[] args){
		//for sample outputs
		itemName = "testItem";
		itemPrice = 9.99;
		//assorted variables for other classes
		sendInfo(itemName, itemPrice);
	}
	
	sendInfo(itemName, itemPrice){
		System.out.println(itemName + itemPrice);
		return itemName, itemPrice;
	}
}