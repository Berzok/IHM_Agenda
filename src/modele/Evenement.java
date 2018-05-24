package modele;

import javax.swing.JButton;


public class Evenement implements Comparable <Evenement>{
	private Date chDate;
	private String chNom;
	private String chLieu;
	
	public Evenement(Date parDate, String parNom, String parLieu)
		{
		this.chDate = parDate;
		this.chNom = parNom;
		this.chLieu = parLieu;
		}//Constructeur
	
	public String toString(){
		return chDate + " " + chNom + " " + chLieu;
	}//toString
	
	public Date getChDate(){
		return this.chDate;
	}//Accesseur Date
	
	public String getChNom(){
		return this.chNom;
	}//Accesseur Nom
	
	public String getChLieu(){
		return this.chLieu;
	}//Accesseur Lieu
	
	public void setChDate(Date parDate){
		this.chDate = parDate;
	}
	
	public void setChNom(String parNom){
		this.chNom = parNom;
	}
	
	public void setChLieu(String parLieu){
		this.chLieu = parLieu;
	}
	
//	public static Evenement lireEvenement() throws ExceptionDate{
//		System.out.println("Entrer Date");
//		Date d1 = Date.lireDate();
//		System.out.println("Entrer nom");
//		String Nom = Clavier.lireString();
//		System.out.println("Entrer lieu");
//		String Lieu = Clavier.lireString();
//		Evenement E = new Evenement(d1, Nom, Lieu);
//		return E;
//	}//lireEvenement
	
	public int compareTo(Evenement parEvent){
//		if (this.chDate.comparTo(parEvent.chDate)!=0)
			{
//				return this.chDate.comparTo(parEvent.chDate);//les dates sont identiques
			}
		if(this.chNom.compareTo(parEvent.chNom)!=0)
				return this.chNom.compareTo(parEvent.chNom);//les noms sont identiques
		return this.chLieu.compareTo(parEvent.chLieu);
	}//comparTo

	public JButton getSource() {
		// TODO Auto-generated method stub
		return null;
	}
	
}//Evenement
