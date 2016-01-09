import java.util.ArrayList;


public class Spieler {

	private String name;
	private ArrayList<Karte> karten;
	
	public Spieler(String name){
		
		this.name = name;
		
	}
	
	public Spieler(String name, ArrayList<Karte> karten) {
		super();
		this.name = name;
		this.karten = karten;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Karte> getKarten() {
		return karten;
	}
	public void setKarten(ArrayList<Karte> karten) {
		this.karten = karten;
	}
	
	public int getGesamtWert(){
		
		int gesamtwert = 0;
		int anzahlAss = 0;
		
		for(int i = 0; i<karten.size(); i++){
			
			if(karten.get(i).getKarte().equals("A")){
				
				anzahlAss++;
			}
			
			else{
			
			gesamtwert += this.karten.get(i).getWert();
			
			}
			
		}
		
		if(anzahlAss != 0){
			
			if(((gesamtwert + anzahlAss * 10) -21) <= 0){
				
				gesamtwert += anzahlAss*11;
				
			}
			
			else gesamtwert += anzahlAss*1;
			
			
		}
		
		return gesamtwert; 
		
	}
	
	public String toString(){
		
		String s = "";
		
		s+= this.name;
		s+= " ";
		
		for(int i = 0; i<karten.size(); i++){
			
			s+= "|" + karten.get(i).getKarte();
			
		}
		
		return s;
		
	}
	
}
