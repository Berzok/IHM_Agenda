package vue;
import java.awt.Dimension;
import java.text.ParseException;

import modele.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.CardLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelAgenda.
 */
public class PanelAgenda extends JPanel
	{
	
	/** The ch controleur. */
	Controleur chControleur;
	
	/** The le agenda. */
	Agenda leAgenda;
	
	/** The le panel. */
	PanelCalendrier panelCalendrier;
	
	/** The le panel 1. */
	PanelFormulaire panelFormulaire;
	
	PanelAffichage panelAffichage;
	
	/**
	 * Instantiates a new panel agenda.
	 *
	 * @throws ParseException the parse exception
	 */
	public PanelAgenda() throws ParseException
		{
		CardLayout gestionnaireCartes = new CardLayout();
		setLayout(gestionnaireCartes);
		leAgenda = new Agenda();
		leAgenda.ajout(new Evenement(new Date(5, 7, 1741), "Tourte", "Morrowind"));
		leAgenda.ajout(new Evenement(new Date(13, 4, 2009), "Terezi", "Skaia"));
		leAgenda.afficherContenu();
		panelCalendrier = new PanelCalendrier(new modele.Date()); panelCalendrier.setSize(300, 400);
		panelFormulaire = new PanelFormulaire();
		chControleur = new Controleur(leAgenda, panelFormulaire, panelCalendrier, panelAffichage, this);
		panelAffichage = new PanelAffichage(new Date(), leAgenda);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(panelCalendrier);
		add(panelFormulaire);
		add(panelAffichage);
		}
	
	/**
	 * Recreate le panel.
	 *
	 * @throws ParseException the parse exception
	 */
	public void recreate_lePanel() throws ParseException
		{
		panelCalendrier = new PanelCalendrier(new modele.Date()); panelCalendrier.setSize(300, 400);
		GroupLayout groupLayout = (GroupLayout) panelCalendrier.getLayout();
		panelFormulaire = new PanelFormulaire();
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(panelCalendrier);
		add(panelFormulaire);
		}
	}


//package vue;
//import java.awt.Dimension;
//import java.text.ParseException;
//
//import modele.*;
//
//import javax.swing.*;
//import javax.swing.GroupLayout.Alignment;
//import javax.swing.LayoutStyle.ComponentPlacement;
//import java.awt.GridLayout;
//import java.awt.Component;
//import java.awt.BorderLayout;
//
//public class PanelAgenda extends JPanel
//	{
//	Controleur chControleur;
//	Agenda leAgenda;
//	PanelCalendrier lePanel;
//	PanelFormulaire lePanel1;
//	public PanelAgenda() throws ParseException
//		{
//		leAgenda = new Agenda();
//		leAgenda.ajout(new Evenement(new Date(5, 7, 1741), "Tourte", "Morrowind"));
//		leAgenda.ajout(new Evenement(new Date(13, 4, 2009), "Terezi", "Skaia"));
//		leAgenda.afficherContenu();
//		lePanel = new PanelCalendrier(chControleur, new modele.Date()); lePanel.setSize(300, 400);
//		GroupLayout groupLayout = (GroupLayout) lePanel.getLayout();
//		lePanel1 = new PanelFormulaire(chControleur);
//		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
//		chControleur = new Controleur(leAgenda, lePanel1, lePanel, this);
//		add(lePanel);
//		add(lePanel1);
//		}
//	public void recreate_lePanel() throws ParseException
//		{
//		lePanel = new PanelCalendrier(chControleur, new modele.Date()); lePanel.setSize(300, 400);
//		GroupLayout groupLayout = (GroupLayout) lePanel.getLayout();
//		lePanel1 = new PanelFormulaire(chControleur);
//		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
//		chControleur = new Controleur(leAgenda, lePanel1, lePanel, this);
//		add(lePanel);
//		add(lePanel1);
//		}
//	}