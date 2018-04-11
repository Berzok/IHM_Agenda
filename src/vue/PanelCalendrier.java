package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

import modele.Date;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


public class PanelCalendrier  extends JPanel implements ActionListener
	{
	Controleur leControleur;
	
	String tabNomBoutons[] = {"<--", "-->"};
	modele.Date leJour;
	JButton tabBoutons[] = new JButton[tabNomBoutons.length];
	JLabel tabEtiquettes[] = new JLabel[12];
	String tabIntitules[];
	final static String[] chMois = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"};
	static PanelMois chPanel;
	public PanelCalendrier(Controleur parControleur, modele.Date today)
		{
		leControleur = parControleur;
		chPanel = new PanelMois(leControleur, today);
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
		
		int leMois = new Date().getMois();
		
		
		//ElÃ©ments du panel centre
		File repertoire = new File ("pictures");
		String [ ] intitules_images = repertoire.list() ;
		
		String tabIntitules[] = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
		JLabel tabEtiquettes[] = new JLabel[tabIntitules.length];
		for(int i=0 ; i<tabEtiquettes.length ; i++) {
			tabEtiquettes[i] = new JLabel(tabIntitules[i]);
//			panelCentre.add(tabEtiquettes[i],tabIntitules[i]); //ajout des Ã©tiquettes dans le panel centre
		}
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(panelSud, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
					.addGap(67))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(chPanel, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(chPanel, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
					.addGap(44)
					.addComponent(panelSud, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		setLayout(groupLayout);
//		add(panelCentre,BorderLayout.CENTER);
//		panelCentre.setLayout(new GridLayout(1, 0, 0, 0));
		
	} //constrcuteur du panelfils


	public void actionPerformed(ActionEvent parEvt)
		{
		for(int i=0; i<tabBoutons.length; i++)
			{
			if(parEvt.getSource() == tabBoutons[1])
				{
				leJour = new modele.Date(leJour.getJour(), leJour.getMois()+1, leJour.getAnnee()); 
				chPanel = new PanelMois(leControleur, leJour);
				System.out.println("le bouton: " + leJour.toString());
				leControleur.chPanelFormulaire.chDate = leJour;
				this.truc(leJour);
				break;
				}
			}
		}
	public void truc(modele.Date parDate)
		{
		leControleur.changerDateFormulaire(parDate);
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