import java.util.ArrayList;


public class Croupier extends Spieler{

	public Croupier(String name, ArrayList<Karte> karten) {
		super(name, karten);

	}
	
	public void addKarte(Karte karte){
		
		super.getKarten().add(karte);
		
	}

	public String toString(){

		String s = "";

		s+= super.getName();
		s+= " ";

		for(int i = 0; i<super.getKarten().size(); i++){

			s+= "|" + super.getKarten().get(i).getKarte();

		}

		return s;

	}

}
