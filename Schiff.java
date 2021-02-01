package schiffeversenken;

public class Schiff {
	private int laenge = 0;
	private boolean[] damage;

	private boolean destroied = false;
	//for position
	//not for 1D: private boolean horizontal = true;
	private int start = 0;
	private int end = 0;

	public Schiff(boolean[] field) {

		if(field.length >= 5) {
			damage = new boolean[field.length];
			/*
			for(int i = 0; i <= damage.length - 1; i++) {
				damage[i] = false;
			}
			*/
			System.out.println("Generat Ship length.");
			generateShipLength();
			System.out.println("ship lenght = " + laenge);
			System.out.println("Generate Ship Position");
			generateShipPos(field);
			System.out.println("Ship Ready");
			
		}else
			System.err.println("Field is to small!");


	}


	public int getStart() {
		return start;
	}


	public int getEnd() {
		return end;
	}

	public int getLaenge() {
		return laenge;
	}

	public boolean isDestroied() {
		checkDemage();
		return destroied;
	}

	public void setDamage(int pos) {
		damage[pos] = true;
	}

	private void checkDemage() {
		int dem = 0;
		
		for (int i = 0; i < damage.length; i++) {
			if(damage[i] == true)
				dem++;
		}
		
		if(laenge == dem)
			destroied = true;
	}

	private void generateShipPos(boolean[] field) {
		do {
			start = (int) (Math.random() * field.length);
			end = start + laenge - 1;
			//System.out.println("START = " + start);
			//System.out.println("ENDE = " + end);
		}while(field.length - 1 < end);

	}

	private void generateShipLength() {
		do {
			laenge = (int) (Math.random() * 10);
		}while(laenge <= 0 || laenge > 5);
	}

	public boolean[] getDamage() {
		return damage;
	}
	
	

}
