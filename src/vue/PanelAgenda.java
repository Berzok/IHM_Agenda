package vue;
import java.text.ParseException;

import modele.*;

import javax.swing.*;

public class PanelAgenda extends JPanel
	{
	public PanelAgenda() throws ParseException
		{
		Agenda leAgenda = new Agenda();
		leAgenda.ajout(new Evenement(new Date(5, 7, 1741), "Tourte", "Morrowind"));
		leAgenda.ajout(new Evenement(new Date(13, 4, 2009), "Terezi", "Skaia"));
		leAgenda.afficherContenu();
		PanelFormulaire lePanel = new PanelFormulaire(leAgenda);
		this.add(lePanel);
		}
	}