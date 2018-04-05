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
	JButton[] chLesJours = new JButton[42]; 
	public PanelMois(Controleur parControleur, modele.Date today)
		{
		JPanel lePanel = new JPanel();
		lePanel.setLayout(new GridLayout(1, 7));
		JPanel lePanel1 = new JPanel();
		lePanel1.setLayout(new GridLayout(6, 7));
		
		
		DateFormat dfl = DateFormat.getDateInstance(DateFormat.FULL);
		String leJour = dfl.format(new Date());
		String[] leJour1 = leJour.split(" ");
		String leJour2 = leJour1[0];
		
		int debutMois = Integer.parseInt(leJour1[1]);
		int finMois = modele.Date.dernierJourDuMois(today.getMois(), today.getAnnee());
		debutMois = finMois - (finMois - 1);
		
		
		String[] laSemaine = {"lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi", "dimanche"};
		leControleur = parControleur;
		int[] les31 = {1, 3, 5, 7, 8, 10, 12};
		int[] les30 = {4, 6, 9, 11};
		
			
		
		for(int i=0; i<laSemaine.length; i++)
			{
			chJoursSemaine[i] = new JLabel(laSemaine[i]);
			}
		
		for(int i=0; i<chLesJours.length; i++)
			{
			chLesJours[i] = new JButton();
			chLesJours[i].setFocusPainted(false);
			chLesJours[i].setContentAreaFilled(false);
			chLesJours[i].setFocusable(false);
			chLesJours[i].setEnabled(false);
			}
		
		System.out.println("Début du mois: " + debutMois);
		
		for(int i=debutMois+6; i<finMois+7; i++)
			{
			chLesJours[i].setText(""+(i-6));
			chLesJours[i].addActionListener(leControleur);
			chLesJours[i].addActionListener(this);
			chLesJours[i].setEnabled(true);
			}
		
		
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
	public void ajouterCalendrier(JPanel parPanel, JButton[] parTab, int parDebut, int parFin)
		{
		for(int i=parDebut; i<parFin+10; i++)
			{
			parPanel.add(parTab[i]);
			}
		}
	public void actionPerformed(ActionEvent parEvent)
		{
		for(int i=0; i<42; i++)
			{
			chLesJours[i].setContentAreaFilled(false);
			}
		for(int i=0; i<42; i++)
			{
			if(parEvent.getSource().equals(chLesJours[i]))
				{
				chLesJours[i].setContentAreaFilled(true);
				}
			}
		}
	}