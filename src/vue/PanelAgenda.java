package vue;
import java.awt.Dimension;
import java.text.ParseException;

import modele.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.BorderLayout;

public class PanelAgenda extends JPanel
	{
	Controleur chControleur;
	public PanelAgenda() throws ParseException
		{
		Agenda leAgenda = new Agenda();
		leAgenda.ajout(new Evenement(new Date(5, 7, 1741), "Tourte", "Morrowind"));
		leAgenda.ajout(new Evenement(new Date(13, 4, 2009), "Terezi", "Skaia"));
		leAgenda.afficherContenu();
		PanelCalendrier lePanel = new PanelCalendrier(chControleur, new modele.Date()); lePanel.setSize(300, 400);
		GroupLayout groupLayout = (GroupLayout) lePanel.getLayout();
		PanelFormulaire lePanel1 = new PanelFormulaire(chControleur);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		chControleur = new Controleur(leAgenda, lePanel1, lePanel);
		add(lePanel);
		add(lePanel1);
		}
	}