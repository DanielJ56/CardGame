import java.io.*;
import java.util.concurrent.ThreadLocalRandom;


public class main {
	
	
	
	public static void main(String[] args) {
		
		File deck = new File("StarterDeck.txt");
		Deck test = new Deck();
		test.setOwner(1);
		test.AddDeck(deck);
		
		File deck2 = new File("StarterDeck.txt");
		Deck test2 = new Deck();
		test2.setOwner(2);
		test2.AddDeck(deck2);
		
		
		System.out.println("The IDS ARE" + test.OwnerID + test2.OwnerID);
		
		Game g = new Game(test,test2);
		
		while (g.gameState<0) {
			g.round();
		}
		System.out.println(g.gameState);
		
	}
	                                        
	                                        
			
}
