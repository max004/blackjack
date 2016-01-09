import java.util.Random;


public class Methoden {

	public static Karte[] blackJackKartenGenerieren(){

		Karte[] karten = new Karte[312];

		for(int i = 0; i<karten.length; i++){

			int zahl = i;

			zahl = zahl%13;

			if(zahl == 0){

				Karte k = new Karte(-1, "A");
				karten[i] = k;		
			}

			else if(zahl == 10){

				Karte k = new Karte(10, "B");
				karten[i] = k;		
			}

			else if(zahl == 11){

				Karte k = new Karte(10, "D");
				karten[i] = k;		
			}

			else if(zahl == 12){

				Karte k = new Karte(10, "K");
				karten[i] = k;		
			}

			else{

				Karte k = new Karte((zahl+1), "" + (zahl+1));
				karten[i] = k;		
			}

		}

		return karten;

	}

	public static Karte[] kartenAusteilen(Karte[] karten, int anzahl){

		Karte[] zufallsKarten = new Karte[anzahl]; 
		Random rnd = new Random();
		int grenze = (karten.length -1);
		int zufallszahl = 0;
		Karte zwischenKarte;

		for(int i = 0; i<zufallsKarten.length; i++){

			zufallszahl = rnd.nextInt(grenze);
			zufallsKarten[i] = karten[zufallszahl];
			zwischenKarte = karten[zufallszahl];
			karten[zufallszahl] = karten[grenze];
			karten[grenze] = zwischenKarte;
			grenze --;

		}

		return zufallsKarten;
	}

	public static void siebenerDrilling(Spieler spieler){



		if((spieler.getGesamtWert())  == 21 && (spieler.getKarten().get(0).getWert()==7) && (spieler.getKarten().get(1).getWert()==7)){

			System.out.println("Der Spieler hat einen Siebenerdrilling");

		}

		else System.out.println("Der Spieler hat keinen Siebenerdrilling");

	}

	public static void siebenerDrilling(Croupier croupier){

		if((croupier.getGesamtWert())  == 21 && (croupier.getKarten().get(0).getWert()==7) && (croupier.getKarten().get(1).getWert()==7)){

			System.out.println("Der Croupier hat einen Siebenerdrilling");

		}

		else System.out.println("Der Croupier hat keinen Siebenerdrilling");

	}


	public static void BlackJack(Spieler spieler){
		
		int counter = 0;
		
		if(spieler.getGesamtWert() == 21){
			
			for(int i = 0; i<spieler.getKarten().size(); i++){
				
				if(spieler.getKarten().get(i).getWert() == 10 || spieler.getKarten().get(i).getKarte().equals("A")){
					
					counter ++;
					
				}
				
			}
			
			if(counter == 2){
				
				System.out.println("Der Spieler hat ein BlackJack");
				
			}
			
		}
		
		else System.out.println("Der Spieler hat kein Blackjack");
		
	}


}
