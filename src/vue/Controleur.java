package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modele.*;



public class Controleur implements ActionListener
	{
	Agenda chAgenda;
	PanelFormulaire chPanelFormulaire;
	PanelCalendrier chPanelCalendrier;
	
	public Controleur (Agenda parAgenda, PanelFormulaire parPanelForm, PanelCalendrier parPanelCalend)
		{
		chAgenda = parAgenda;
		chPanelFormulaire = parPanelForm;
		chPanelCalendrier = parPanelCalend;
		chPanelFormulaire.enregistreEcouteur(this);
		chPanelCalendrier.enregistreEcouteur(this);
		}
	public void changerDateFormulaire(modele.Date parDate)
		{
		System.out.println("Controleur ok");
		chPanelFormulaire.setDate(parDate);
		}
	public void actionPerformed(ActionEvent parEvent)
		{
		for(int i=0; i<PanelCalendrier.chPanel.chLesJours.length; i++)
			{
			if(parEvent.getSource().equals((PanelCalendrier.chPanel.chLesJours[i])))
				{
				modele.Date lautreDate = new modele.Date();
				modele.Date laDate = new modele.Date(Integer.parseInt(PanelCalendrier.chPanel.chLesJours[i].getText()), lautreDate.getMois(), lautreDate.getAnnee());
//				String laDate = PanelCalendrier.chPanel.chJoursSemaine[i%7-1].getText() + " " + PanelCalendrier.chPanel.chLesJours[i].getText() + " " + lautreDate2[2] + " " + lautreDate2[3];
				chPanelCalendrier.setDate(laDate);
				chPanelFormulaire.setDate(laDate);
				}
			}
		if(parEvent.getSource().equals(PanelFormulaire.chBoutonAjout))
			{
			Evenement leEvent = PanelFormulaire.getEvenement();
			chAgenda.ajout(leEvent);
			JOptionPane.showMessageDialog((JButton) leEvent.getSource(), chAgenda.toString(1));
			chPanelFormulaire.reset();
			}
		}
	}