
public class Card {
	
	public int Number;
	public String color;
	public String element; 
	public int OwnerID;
	public Card(int num, String el,String col,int o) {
		Number = num;
		color = col;
		element = el;
		OwnerID = o;
	}
	
	public int getOwner() {
		return OwnerID;
	}
	
	
	
	

}
