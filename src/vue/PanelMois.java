package vue;

import modele.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelMois.
 */
@SuppressWarnings("serial")
public class PanelMois extends JPanel implements ActionListener
	{
	
	/** The le controleur. */
	Controleur leControleur;
	
	/** The Constant chJoursSemaine. */
	final static JLabel[] chJoursSemaine = new JLabel[7];
	
	/** The ch les jours. */
	JButton[] chLesJours = new JButton[50]; 
	
	/** The debut mois. */
	int debutMois;
	
	/** The fin mois. */
	int finMois;
	
	/**
	 * Instantiates a new panel mois.
	 *
	 * @param today the today
	 */
	public PanelMois(Date today)
		{
		System.out.println("LE PANEL MOIS " + today);
				
		finMois = 31;
		
		debutMois = trouverDebutMois(today);
		
		int debutMois2 = trouverDebutMois(new modele.Date(today.getJour(), today.getMois()+1, today.getAnnee()));  
		
		System.out.println("le début: " + debutMois);
		int totalJours = debutMois + finMois;
		System.out.println("Nombre de jours: " + totalJours);
		System.out.println("Fin du mois: " + finMois);
		
		
		this.setLayout(new GridLayout(0, 7));
		
		
		String[] laSemaine = {" lundi  ", "mardi  ", "mercredi  ", "jeudi  ", "vendredi  ", "samedi  ", "dimanche  "};
		
			
		
		for(int i=0; i<laSemaine.length; i++)
			{
			chJoursSemaine[i] = new JLabel(laSemaine[i]);
			}
		
		this.actualiserMois(today);
		
		
		for(int i=0; i<7; i++)
			{
			this.add(chJoursSemaine[i]);
			}
		
		this.ajouterCalendrier(chLesJours, totalJours);
		
		
		}
	
	
	/**
	 * Actualiser mois.
	 *
	 * @param parDate the par date
	 */
	public void actualiserMois(Date parDate)
		{
		System.out.println(parDate.toString());
		System.out.println(debutMois);
		debutMois = trouverDebutMois(parDate);
		System.out.println(debutMois + "aaa");
		System.out.println(" ");
		for(int i=0; i<chLesJours.length; i++)
			{
			chLesJours[i] = new JButton();
			chLesJours[i].setFocusPainted(false);
			chLesJours[i].setContentAreaFilled(false);
			chLesJours[i].setFocusable(false);
			chLesJours[i].setEnabled(false);
			}
	
		for(int i=trouverDebutMois(parDate); i<=finMois; i++)
			{
			chLesJours[i].setText(""+i);
			chLesJours[i].addActionListener(leControleur);
			chLesJours[i].addActionListener(this);
			chLesJours[i].setEnabled(true);
			}
		this.revalidate();
		}
	
	/**
	 * Ajouter calendrier.
	 *
	 * @param parTab the par tab
	 * @param parFin the par fin
	 */
	public void ajouterCalendrier(JButton[] parTab, int parFin)
		{
		for(int i=0; i<parFin; i++)
			{
			this.add(parTab[i]);
			}
		}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent parEvent)
		{
		for(int i=0; i<50; i++)
			{
			chLesJours[i].setContentAreaFilled(false);
			}
		for(int i=0; i<50; i++)
			{
			if(parEvent.getSource().equals(chLesJours[i]))
				{
				chLesJours[i].setContentAreaFilled(true);
				}
			}
		}
	
	/**
	 * Trouver debut mois.
	 *
	 * @param parDate the par date
	 * @return the int
	 */
	private static int trouverDebutMois(Date parDate)
		{
		String debutSemaine = parDate.toString().split(" ")[0];
		System.out.println("qdqsdqsd" + parDate.toString());
		switch (debutSemaine)
			{
			case "lundi":
				return 0;
			case "mardi":
				return 1;
			case "mercredi":
				return 2;
			case "jeudi":
				return 3;
			case "vendredi":
				return 4;
			case "samedi":
				return 5;
			case "dimanche":
				return 6;
			}
		return 0;
		}
	}