import java.util.ArrayList;
import java.util.Random;


public class BlackJack {

	public static void main(String args[]){

		int anzKartenGesamt = 0;
		Karte[] stapel = new Karte[312];
		Spieler[] spieler = new Spieler[3];
		Croupier croupier = new Croupier("Croupier", null);
		int[] anzahlKarten = new int[spieler.length+1];

		stapel = Methoden.blackJackKartenGenerieren();

		//		for(int i = 0; i<karten.length; i++){
		//			
		//			System.out.println(stapel[i].getKarte() + "|" +  stapel[i].getWert());
		//			
		//		}

		for(int i = 0; i<(spieler.length+1); i++){

			Random rnd = new Random();

			anzahlKarten[i] = rnd.nextInt(5);

			if(anzahlKarten[i] < 2){

				anzahlKarten[i] = 2;

			}

			anzahlKarten[3] = 1;
			anzKartenGesamt += anzahlKarten[i];

		}

		Karte[] karten = new Karte[anzKartenGesamt];
		karten = Methoden.kartenAusteilen(stapel, anzKartenGesamt);
		int startindex = 0;

		for(int i = 0; i<spieler.length+1; i++){

			ArrayList<Karte> spielerKarten = new ArrayList<>();

			for(int j = startindex; j<(anzahlKarten[i] + startindex); j++){

				spielerKarten.add(karten[j]);

			}

			if(i < spieler.length){

				Spieler s = new Spieler("Spieler" + (i+1), spielerKarten);
				spieler[i] = s;
				startindex += anzahlKarten[i]; 

			}

			else croupier = new Croupier("Croupier", spielerKarten);
		}

		while(croupier.getGesamtWert() < 17){

			Karte[] karte = Methoden.kartenAusteilen(stapel, 1);

			croupier.addKarte(karte[0]);

		}
		
		for(int i = 0; i<spieler.length; i++){
			
			System.out.println(spieler[i].toString());
			System.out.println(spieler[i].getName() + "--" + spieler[i].getGesamtWert() );

		}

		System.out.println(croupier.toString());
		System.out.println(croupier.getName() + "--" + croupier.getGesamtWert());



	}
}