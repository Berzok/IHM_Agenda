package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modele.*;



// TODO: Auto-generated Javadoc
/**
 * The Class Controleur.
 */
public class Controleur implements ActionListener
	{
	
	/** The ch agenda. */
	Agenda chAgenda;
	
	/** The ch panel formulaire. */
	PanelFormulaire chPanelFormulaire;
	
	/** The ch panel calendrier. */
	PanelCalendrier chPanelCalendrier;
	
	/** The ch panel agenda. */
	PanelAgenda chPanelAgenda;
	
	/** The ch date. */
	modele.Date chDate;

	private PanelAffichage chPanelAffichage;
	
	/**
	 * Instantiates a new controleur.
	 *
	 * @param parAgenda the par agenda
	 * @param parPanelForm the par panel form
	 * @param parPanelCalend the par panel calend
	 * @param panelAffichage 
	 * @param parPanelAgend the par panel agend
	 */
	public Controleur (Agenda parAgenda, PanelFormulaire parPanelForm, PanelCalendrier parPanelCalend, PanelAffichage panelAffichage, PanelAgenda parPanelAgend)
		{
		chAgenda = parAgenda;
		chPanelFormulaire = parPanelForm;
		chPanelCalendrier = parPanelCalend;
		chPanelAgenda = parPanelAgend;
		chPanelAffichage = panelAffichage;
		chPanelFormulaire.enregistreEcouteur(this);
		chPanelCalendrier.enregistreEcouteur(this);
		}
	
	/**
	 * Changer date formulaire.
	 *
	 * @param parDate the par date
	 */
	public void changerDateFormulaire(modele.Date parDate)
		{
		System.out.println("Controleur ok");
		chPanelFormulaire.setDate(parDate);
		}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent parEvent)
		{
		for(int i=0; i<chPanelCalendrier.panelMois.chLesJours.length; i++)
			{
			if(parEvent.getSource() == ((chPanelCalendrier.panelMois.chLesJours[i])))
				{
				modele.Date lautreDate = new modele.Date();
				modele.Date laDate = new modele.Date(Integer.parseInt(chPanelCalendrier.panelMois.chLesJours[i].getText()), lautreDate.getMois(), lautreDate.getAnnee());
//				String laDate = PanelCalendrier.chPanel.chJoursSemaine[i%7-1].getText() + " " + PanelCalendrier.chPanel.chLesJours[i].getText() + " " + lautreDate2[2] + " " + lautreDate2[3];
				chPanelCalendrier.setDate(laDate);
				chPanelFormulaire.setDate(laDate);
				chPanelAffichage.setDate(laDate);
				break;
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