package vue;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;

public class PanelMois extends JPanel
	{
	JLabel[] chJoursSemaine = new JLabel[7];
	JButton[] chLesJours = new JButton[31]; 
	public PanelMois(int parNumMois)
		{
		String[] laSemaine = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
		
		for(int i=0; i<laSemaine.length; i++)
			{
			chJoursSemaine[i] = new JLabel(laSemaine[i]);
			}
		
		for(int i=0; i<31; i++)
			{
			chLesJours[i] = new JButton((i+1+""));
			chLesJours[i].setFocusPainted(false);
			chLesJours[i].setContentAreaFilled(false);
			}
		
		setLayout(new GridLayout(6, 7));
		for(int i=0; i<7; i++)
			{
			this.add(chJoursSemaine[i]);
			}
		for(int i=0; i<31; i++)
			{
			this.add(chLesJours[i]);
			}
		
		
		}
	}