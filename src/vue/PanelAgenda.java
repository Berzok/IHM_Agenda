package vue;
import java.awt.Dimension;
import java.text.ParseException;

import modele.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;

public class PanelAgenda extends JPanel
	{
	Controleur chControleur;
	public PanelAgenda() throws ParseException
		{
		Agenda leAgenda = new Agenda();
		leAgenda.ajout(new Evenement(new Date(5, 7, 1741), "Tourte", "Morrowind"));
		leAgenda.ajout(new Evenement(new Date(13, 4, 2009), "Terezi", "Skaia"));
		leAgenda.afficherContenu();
		PanelCalendrier lePanel = new PanelCalendrier(chControleur);
		PanelFormulaire lePanel1 = new PanelFormulaire(chControleur);
		chControleur = new Controleur(leAgenda, lePanel1, lePanel);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lePanel, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
					.addComponent(lePanel1, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lePanel, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE)
				.addComponent(lePanel1, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE)
		);
		setLayout(groupLayout);
		}
	}