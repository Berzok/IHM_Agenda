package vue;
import java.text.ParseException;

import modele.*;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PanelAgenda2 extends JPanel
	{
	private JTable table;
	private JTable table_1;
	public PanelAgenda2() throws ParseException
		{
		
		String[] jourMois = new String[31];
		for(int i=0; i<24;i++)
			{
			jourMois[i] = i+"";
			}
		
		
		setBackground(new Color(95, 158, 160));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{348, 0};
		gridBagLayout.rowHeights = new int[]{407, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		table = new JTable();
		table.setBackground(new Color(95, 158, 160));
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		add(table, gbc_table);
		
		table_1 = new JTable();
		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.fill = GridBagConstraints.BOTH;
		gbc_table_1.gridx = 0;
		gbc_table_1.gridy = 1;
		add(table_1, gbc_table_1);
		Agenda leAgenda = new Agenda();
		leAgenda.ajout(new Evenement(new Date(5, 7, 1741), "Tourte", "Morrowind"));
		leAgenda.ajout(new Evenement(new Date(13, 4, 2009), "Terezi", "Skaia"));
		leAgenda.afficherContenu();
		}
	}