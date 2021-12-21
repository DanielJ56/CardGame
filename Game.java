import java.util.*;

public class Game {
	
	public Deck p1Deck;
	public Deck p2Deck;
	public int p1ID;
	public int p2ID;
	
	public WinStack p1WonCards;
	public WinStack p2WonCards; 
	public int gameState = -1;
	
	
	public Game(Deck p1, Deck p2 ) {
		
		p1Deck = p1;
		p2Deck = p2;
		p1ID = p1Deck.OwnerID;
		p2ID = p2Deck.OwnerID;
		p1WonCards = new WinStack(p1Deck.getOwnerID());
		p2WonCards = new WinStack(p2Deck.getOwnerID());
	}
	
	public int compCards(Card p1C, Card p2C) {
		if (p1C.element.equals(p2C.element)) {
			if (p1C.Number > p2C.Number) {
				return p1C.OwnerID;
			} else if (p2C.Number > p1C.Number) {
				return p2C.OwnerID;
			} else {
				return -404;
			}
		} else if (p1C.element.equals("F") && p2C.element.equals("W")) {
			return p2C.getOwner();
		} else if (p1C.element.equals("F") && p2C.element.equals("S")) {
			return p1C.getOwner();
		} else if (p1C.element.equals("S") && p2C.element.equals("F")) {
			return p2C.getOwner();
		} else if (p1C.element.equals("S") && p2C.element.equals("W")) {
			return p1C.getOwner();
		} else if (p1C.element.equals("W")&& p2C.element.equals("F")) {
			return p1C.getOwner();
		} else {
			return p2C.getOwner();
		}
	}
	
	public void round() {
		Card p1Card = p1Deck.Draw();
		Card p2Card = p2Deck.Draw();
		if (p1Card==null &&p2Card == null) {
			System.out.println("null");
			System.out.println("null");
			this.gameState=404;
		} else if (p1Card==null) {
			this.gameState = p2Deck.OwnerID;
			System.out.println("null");
			System.out.println(p2Card.element + p2Card.Number + p2Card.color);
		} else if (p2Card == null) {
			System.out.println(p1Card.element + p1Card.Number + p1Card.color);
			System.out.println("null");
			this.gameState = p1Deck.OwnerID;
		} else {
			System.out.println(p1Card.element + p1Card.Number + p1Card.color);
			System.out.println(p2Card.element + p2Card.Number + p2Card.color);
			
			int winner = this.compCards(p1Card, p2Card);
			if (winner == this.p1ID) {
				System.out.println("Player 1 won");
				p1WonCards.addCard(p1Card);
				if (p1WonCards.won()==true) {
					this.gameState = p1WonCards.PlayerID;
				}
				
			} else if (winner == this.p2ID) {
				System.out.println("Player 2 won");
				p2WonCards.addCard(p2Card);
				if (p2WonCards.won()==true) {
					this.gameState = p2WonCards.PlayerID;
				}
			} else {
				System.out.println("TIE");
			}

		}
		
		
	}
	
	
}
