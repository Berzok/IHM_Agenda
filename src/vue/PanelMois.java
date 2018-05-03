package vue;

import modele.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.xml.bind.ParseConversionEvent;

public class PanelMois extends JPanel implements ActionListener
	{
	static Controleur leControleur;
	final static JLabel[] chJoursSemaine = new JLabel[7];
	JButton[] chLesJours = new JButton[50]; 
	static int debutMois;
	public PanelMois(Controleur parControleur, modele.Date today)
		{
		System.out.println("LE PANEL MOIS " + today);
		JPanel lePanel = new JPanel();
		lePanel.setLayout(new GridLayout(1, 7));
		JPanel lePanel1 = new JPanel();
		lePanel1.setLayout(new GridLayout(6, 7));
		
		
		
		int finMois = modele.Date.dernierJourDuMois(today.getMois(), today.getAnnee());
		this.trouverDebutMois(today);
		
		
		
		String[] laSemaine = {"lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi", "dimanche"};
		leControleur = parControleur;
		int[] les31 = {1, 3, 5, 7, 8, 10, 12};
		int[] les30 = {4, 6, 9, 11};
		
			
		
		for(int i=0; i<laSemaine.length; i++)
			{
			chJoursSemaine[i] = new JLabel(laSemaine[i]);
			}
		
		this.actualiserMois(today);
		
		
		for(int i=0; i<7; i++)
			{
			lePanel.add(chJoursSemaine[i]);
			}
		
		this.ajouterCalendrier(lePanel1, chLesJours, debutMois, finMois);
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lePanel, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
				.addComponent(lePanel1, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lePanel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lePanel1, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		}
	
	
	public void actualiserMois(modele.Date parDate)
		{
		System.out.println(parDate.toString());
		System.out.println(debutMois);
		this.trouverDebutMois(parDate);
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
	
		for(int i=debutMois; i<modele.Date.dernierJourDuMois(parDate.getMois(), parDate.getAnnee())+6; i++)
			{
			chLesJours[i].setText(""+(i-5));
			chLesJours[i].addActionListener(leControleur);
			chLesJours[i].addActionListener(this);
			chLesJours[i].setEnabled(true);
			}
		this.revalidate();
		}
	
	public void ajouterCalendrier(JPanel parPanel, JButton[] parTab, int parDebut, int parFin)
		{
		for(int i=0; i<parFin+12; i++)
			{
			parPanel.add(parTab[i]);
			}
		}
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
				leControleur.chDate = new modele.Date(Integer.parseInt(chLesJours[i].getText()), new modele.Date().getMois(), new modele.Date().getAnnee());
				}
			}
		}
	public void trouverDebutMois(modele.Date parDate)
		{
		String debutSemaine = parDate.toString().split(" ")[0];
		switch (debutSemaine)
			{
			case "lundi":
				debutMois = 0;
			case "mardi":
				debutMois = 1;
			case "mercredi":
				debutMois = 2;
			case "jeudi":
				debutMois = 3;
			case "vendredi":
				debutMois = 4;
			case "samedi":
				debutMois = 5;
			case "dimanche":
				debutMois = 6;
			}
		}
	}