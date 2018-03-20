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
	public void actionPerformed(ActionEvent parEvent)
		{
		if(parEvent.getSource().equals(chPanelCalendrier.chPanel.chLesJours))
			{
			Date laDate = new Date();
			DateFormat dfl = DateFormat.getDateInstance(DateFormat.FULL);
			chPanelFormulaire.setDate(dfl);
			}
		if(parEvent.getSource().equals(PanelFormulaire.chBoutonAjout))
			{
			Evenement leEvent = PanelFormulaire.getEvenement();
			chAgenda.ajout(leEvent);
			JOptionPane.showMessageDialog((JButton) leEvent.getSource(), chAgenda.toString(2));
			chPanelFormulaire.reset();
//			chPanelCalendrier.setDate(chPanelFormulaire.getDate());
			}
		}
	}