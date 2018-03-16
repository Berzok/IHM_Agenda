package modele;
import java.util.ArrayList ;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet ;


public class Agenda implements Comparable<Evenement> {
	private ArrayList<Evenement> listEvts ;
	private TreeSet<Evenement> arbreEvts ;
	private TreeMap<Integer,Evenement> mapEvts ;
	
	// Question 1, 5
	public Agenda() {
		listEvts = new ArrayList<Evenement>();
		arbreEvts = new TreeSet<Evenement>() ;
		mapEvts = new TreeMap<Integer, Evenement>();
	}
	
	// Question 1, 5
	public void ajout(Evenement parEvt) {
		listEvts.add(parEvt);
//		arbreEvts.add(parEvt);
		//mapEvts.add(new GregorianCalendar.add(parEvt.getChDate()).get(Calendar.WEEK_OF_YEAR), parEvt) ;
	}
	
	// Question 2
	public int compareTo(Evenement parEvts) {
		
		return 0;
	}
	
	
	// Question 3
	public int nbExpose() {
		int iter = 0 ;// le nombre de fois où il y a "exposé" dans le titre
		for(int index = 0 ; index < this.listEvts.size() ; index++) {
			if(this.listEvts.get(index).getChNom().contains("exposé"))
				iter++ ;
		}
		return iter;
	}
	
	public void afficherContenu()
		{
		for(int i=0; i<this.listEvts.size(); i++)
			{
			System.out.println("Le "+ this.listEvts.get(i).getChDate() + ", " + this.listEvts.get(i).getChNom() + " à " + this.listEvts.get(i).getChLieu());
			}
		}
	
	// Question 4
	public int nbEvtEnregistre(Date parDate) {
		int nbEvts = 0 ;
		Iterator<Evenement> iter = this.arbreEvts.iterator();
		while(iter.hasNext())
			if (iter.next().getChDate().compareTo(parDate)==0)
				nbEvts++ ;
		return nbEvts ;
	}
}