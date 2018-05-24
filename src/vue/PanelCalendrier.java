package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modele.Date;


// TODO: Auto-generated Javadoc
/**
 * The Class PanelCalendrier.
 */
@SuppressWarnings("serial")
public class PanelCalendrier  extends JPanel implements ActionListener
	{
	
	/** The le controleur. */
	Controleur leControleur;
	
	/** The tab nom boutons. */
	String tabNomBoutons[] = {"<--", "-->"};
	
	/** The le jour. */
	Date leJour;
	
	/** The tab boutons. */
	JButton tabBoutons[] = new JButton[tabNomBoutons.length];
	
	/** The tab etiquettes. */
	JLabel tabEtiquettes[] = new JLabel[12];
	
	/** The tab intitules. */
	String tabIntitules[];
	
	/** The Constant chMois. */
	final static String[] chMois = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"};
	
	/** The ch panel. */
	 PanelMois panelMois;
	
	/**
	 * Instantiates a new panel calendrier.
	 *
	 * @param today the today
	 */
	public PanelCalendrier(Date today)
		{
		this.setLayout(new BorderLayout());
		panelMois = new PanelMois(today);
		leJour = today;
		
		JPanel panelSud = new JPanel();
		for (int i=0 ; i<tabNomBoutons.length ; i++)
			{
			tabBoutons[i] = new JButton(tabNomBoutons[i]);
			panelSud.add(tabBoutons[i]); //ajout des boutons dans le panel sud
			tabBoutons[i].addActionListener(this);
			}
		
		//ElÃ©ments du panel sud
		
		
		for(int i=0; i<chMois.length; i++)
			{
			tabEtiquettes[i] = new JLabel(chMois[i]);
			}
		
		
		String tabIntitules[] = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
		JLabel tabEtiquettes[] = new JLabel[tabIntitules.length];
		for(int i=0 ; i<tabEtiquettes.length ; i++)
			{
			tabEtiquettes[i] = new JLabel(tabIntitules[i]);
//			panelCentre.add(tabEtiquettes[i],tabIntitules[i]); //ajout des Ã©tiquettes dans le panel centre
			}
		
		
		this.add(panelMois, BorderLayout.CENTER);
		this.add(panelSud, BorderLayout.SOUTH);
		
	} //constrcuteur du panelfils


	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent parEvt)
		{
		for(int i=0; i<tabBoutons.length; i++)
			{
			if(parEvt.getSource() == tabBoutons[0])
				{
				leJour = new modele.Date(leJour.getJour(), leJour.getMois()-1, leJour.getAnnee()); 
				panelMois = new PanelMois(leJour);
				break;
				}
			if(parEvt.getSource() == tabBoutons[1])
				{
				leJour = new modele.Date(leJour.getJour(), leJour.getMois()+1, leJour.getAnnee()); 
				panelMois = new PanelMois(leJour);
				System.out.println("le bouton: " + leJour.toString());
				break;
				}
			}
		}
	
	/**
	 * Enregistre ecouteur.
	 *
	 * @param controleur the controleur
	 */
	public void enregistreEcouteur(Controleur controleur)
		{
		for(int i=0; i<panelMois.chLesJours.length; i++)
			{
			panelMois.chLesJours[i].addActionListener(controleur);
			}
		}
	
	/**
	 * Sets the date.
	 *
	 * @param parDate the new date
	 */
	public void setDate(modele.Date parDate)
		{
		leJour = parDate;
		
		}
	}