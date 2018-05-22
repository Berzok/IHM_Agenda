package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modele.Date;


@SuppressWarnings("serial")
public class PanelCalendrier  extends JPanel implements ActionListener
	{
	Controleur leControleur;
	
	String tabNomBoutons[] = {"<--", "-->"};
	Date leJour;
	JButton tabBoutons[] = new JButton[tabNomBoutons.length];
	JLabel tabEtiquettes[] = new JLabel[12];
	String tabIntitules[];
	final static String[] chMois = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"};
	static PanelMois chPanel;
	public PanelCalendrier(Controleur parControleur, Date today)
		{
		this.setLayout(new BorderLayout());
		chPanel = new PanelMois(today);
		leControleur = parControleur;
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
		
		
		this.add(chPanel, BorderLayout.CENTER);
		this.add(panelSud, BorderLayout.SOUTH);
		
	} //constrcuteur du panelfils


	public void actionPerformed(ActionEvent parEvt)
		{
		for(int i=0; i<tabBoutons.length; i++)
			{
			if(parEvt.getSource() == tabBoutons[0])
				{
				leJour = new modele.Date(leJour.getJour(), leJour.getMois()-1, leJour.getAnnee()); 
				chPanel = new PanelMois(leJour);
				Controleur.chPanelCalendrier = this;
				Controleur.chPanelCalendrier.enregistreEcouteur(leControleur);
				Controleur.chPanelFormulaire.enregistreEcouteur(leControleur);
				System.out.println("le bouton: " + leJour.toString());
				break;
				}
			if(parEvt.getSource() == tabBoutons[1])
				{
				leJour = new modele.Date(leJour.getJour(), leJour.getMois()+1, leJour.getAnnee()); 
				chPanel = new PanelMois(leJour);
				System.out.println("le bouton: " + leJour.toString());
				break;
				}
			}
		}
	public void enregistreEcouteur(Controleur controleur)
		{
		for(int i=0; i<chPanel.chLesJours.length; i++)
			{
			chPanel.chLesJours[i].addActionListener(controleur);
			}
		}
	public void setDate(modele.Date parDate)
		{
		leJour = parDate;
		}
	}