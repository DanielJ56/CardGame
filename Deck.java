import java.io.*;
import java.util.*;
public class Deck {
	
	public ArrayList <Card> Deck = new ArrayList<Card>();
	public int OwnerID; 
	public Deck() {
		
	}
	
	public Deck(File f) {
		
		
		try {
			Scanner scn = new Scanner(f);
			
			while (scn.hasNextLine()) {
				String cardSeq = scn.nextLine();
				String[] props = cardSeq.split(",");
				Card cardObj = new Card(Integer.parseInt(props[0]), props[1],props[2],OwnerID);
				Deck.add(cardObj);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void AddDeck(File f) {
		
		if (Deck.isEmpty() == false ) {
			System.out.println("ERROR");
		} else {
			try {
				Scanner scn = new Scanner(f);
				
				while (scn.hasNextLine()) {
					String cardSeq = scn.nextLine();
					String[] props = cardSeq.split(",");
					Card cardObj = new Card(Integer.parseInt(props[0]), props[1],props[2],OwnerID);
					Deck.add(cardObj);
					
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public Card Draw() {
		if (Deck.size() < 1) {
			return null;
		}
		Random r = new Random();
		int draw = r.nextInt(Deck.size());
		Card thisDraw = Deck.get(draw);
		
		Deck.remove(draw);
		return thisDraw;
		
	}
	
	public void setOwner(int o) {
		OwnerID = o;
	}
	
	public int getOwnerID() {
		return OwnerID;
	}

}
