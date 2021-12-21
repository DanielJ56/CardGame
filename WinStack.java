
import java.util.HashMap;


public class WinStack {
	int PlayerID;
	
	
	
	
	private int numS = 0;
	private int numW = 0;
	private int numF = 0;
	

	private HashMap<String, Card> S = new HashMap<String, Card>();
	private HashMap<String, Card> F = new HashMap<String, Card>();
	private HashMap<String, Card> W = new HashMap<String, Card>();
	
	
	public WinStack(int id) {
		PlayerID = id;
	}
	
	public void addCard(Card c) {
		String el = c.element;
		String col = c.color;
		if (el.equals("S")) {
			if (S.get(col) == null) {
				S.put(col, c);
				numS = numS + 1;
			} else {	
			}
		}
		if (el.equals("W")) {
			if (S.get(col) == null) {
				S.put(col, c);
				numW = numW + 1;
			} else {	
			}
		}
		if (el.equals("F")) {
			if (S.get(col) == null) {
				S.put(col, c);
				numF = numF + 1;
			} else {	
			}
		}
		
		
	}
	
	public boolean WonBySame() {
		if (numS == 3|| numW ==3 || numF==3) {
			return true;
		} else {
			return false;
		}
	}
	public boolean WonByDiff() {
		if (numS>0 && numW>0 && numF>0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean won() {
		boolean sam = this.WonBySame();
		boolean diff = this.WonByDiff();
		if (sam || diff) {
			return true;
		} else {
			return false;
		}
	}

	
}
