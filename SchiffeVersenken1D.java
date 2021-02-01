package schiffeversenken;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SchiffeVersenken1D {
	
	String playField(boolean[] damageField) {
		String field = "";
		for(int x = 0; x < damageField.length; x++) {
			field += " " + x + " "; 
		}
		
		field += "\n";
		
		for (int i = 0; i <= damageField.length -1 ; i++) {
			if (damageField[i]) {
				field += " X ";
			}else if(!damageField[i]) 
				field += " ~ ";
			
			
		}
		
		return field;
	}
	
	
	String toString(boolean[] spielFeld) {
		String field = "";
		for(int x = 0; x < spielFeld.length; x++) {
			field += " " + x + " "; 
		}
		
		field += "\n";
		
		for (int i = 0; i <= spielFeld.length -1 ; i++) {
			if (spielFeld[i]) {
				field += " X ";
			}else
				field += " ~ ";
		}
		
		return field;
	}

	private int eingabeTipp(Scanner scan) {
		int r = -1;
		
		try {
			r = scan.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("Input have to be INT!");
		}
		
		return r;
	}
	
	private boolean[] preparingField(boolean[] field, Schiff ship) {

		for(int i = 0; i <= field.length - 1; i++) {
			field[i] = false;
		}
		
		for(int i = 0; i <= (field.length - 1); i++) {
			if(ship.getStart() == i) {
				for(int j = i; j <= ship.getEnd(); j++) {
					field[j] = true;
				}
			}
		}
		
		return field;
	}
	

	public void run() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Game started.");
		boolean[] field = new boolean[10];
		boolean versenkt = false;
		Schiff ship = new Schiff(field);
		
		//preparing game
		System.out.println("Preparing Field");
		preparingField(field, ship);
		System.out.println("Field Finished \n\n ---START--- \n");
		
		//game logic
		do {
			
			//System.out.println(toString(field)); <------------shows the position of the ship
			System.out.println(playField(ship.getDamage()));
			System.out.println("Geben sie Ziel ein: ");
			int eing = eingabeTipp(scan);
			if(ship.getStart() <= eing && eing<= ship.getEnd()) {
				ship.setDamage(eing);
				System.out.println("Das war ein TREFFER!\n");
				if(ship.isDestroied()) {
					versenkt = true;
					System.out.println("Du hast es versenkt!");
				}
			}else
				System.out.println("Das ging daneben.\n");
			
		}while(!versenkt);
		scan.close();
		System.out.println(toString(field));
		
	}

}
