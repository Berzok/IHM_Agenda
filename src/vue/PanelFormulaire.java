package vue;
import modele.*;
import javax.swing.JPanel;

import java.awt.Color;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;


public class PanelFormulaire extends JPanel implements ActionListener
	{
	private JTextField chLieuEvent;
	private JTextField chTitreEvent;
	private Agenda leAgenda;
	private JButton chAjouterEvent;
	private JLabel lbLabel;
	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public PanelFormulaire(Agenda parAgenda) throws ParseException
		{
		setBackground(new Color(222, 184, 135));
		leAgenda = parAgenda;
		Date today = new Date();
		DateFormat dfl = DateFormat.getDateInstance(DateFormat.FULL);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {30, 50, 0, 0, 0, 11};
		gridBagLayout.rowHeights = new int[] {10, 0, 12, 10, 11, 14, 9, 10, 11, 10, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		JLabel chLabelDate = new JLabel(dfl.format(today));
		chLabelDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_chLabelDate = new GridBagConstraints();
		gbc_chLabelDate.gridwidth = 2;
		gbc_chLabelDate.fill = GridBagConstraints.BOTH;
		gbc_chLabelDate.insets = new Insets(0, 0, 5, 5);
		gbc_chLabelDate.gridx = 1;
		gbc_chLabelDate.gridy = 1;
		add(chLabelDate, gbc_chLabelDate);
		
		JButton chBoutonAjout = new JButton("+");
		chBoutonAjout.setBackground(new Color(222, 184, 135));
		GridBagConstraints gbc_chBoutonAjout = new GridBagConstraints();
		gbc_chBoutonAjout.insets = new Insets(0, 0, 5, 0);
		gbc_chBoutonAjout.gridx = 4;
		gbc_chBoutonAjout.gridy = 1;
		add(chBoutonAjout, gbc_chBoutonAjout);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 1;
		gbc_horizontalStrut.gridy = 2;
		add(horizontalStrut, gbc_horizontalStrut);
		
		JLabel LabelTitre = new JLabel("Titre");
		LabelTitre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_LabelTitre = new GridBagConstraints();
		gbc_LabelTitre.insets = new Insets(0, 0, 5, 5);
		gbc_LabelTitre.anchor = GridBagConstraints.NORTHWEST;
		gbc_LabelTitre.gridx = 1;
		gbc_LabelTitre.gridy = 3;
		add(LabelTitre, gbc_LabelTitre);
		
		chTitreEvent = new JTextField();
		chTitreEvent.setColumns(30);
		GridBagConstraints gbc_chTitreEvent = new GridBagConstraints();
		gbc_chTitreEvent.gridwidth = 3;
		gbc_chTitreEvent.insets = new Insets(0, 0, 5, 0);
		gbc_chTitreEvent.fill = GridBagConstraints.HORIZONTAL;
		gbc_chTitreEvent.gridx = 2;
		gbc_chTitreEvent.gridy = 3;
		add(chTitreEvent, gbc_chTitreEvent);
		
		JLabel labelLieu = new JLabel("Lieu");
		labelLieu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_labelLieu = new GridBagConstraints();
		gbc_labelLieu.anchor = GridBagConstraints.WEST;
		gbc_labelLieu.insets = new Insets(0, 0, 5, 5);
		gbc_labelLieu.gridx = 1;
		gbc_labelLieu.gridy = 5;
		add(labelLieu, gbc_labelLieu);
		
		chLieuEvent = new JTextField();
		GridBagConstraints gbc_chLieuEvent = new GridBagConstraints();
		gbc_chLieuEvent.gridwidth = 3;
		gbc_chLieuEvent.insets = new Insets(0, 0, 5, 0);
		gbc_chLieuEvent.fill = GridBagConstraints.HORIZONTAL;
		gbc_chLieuEvent.gridx = 2;
		gbc_chLieuEvent.gridy = 5;
		add(chLieuEvent, gbc_chLieuEvent);
		chLieuEvent.setColumns(10);
		
		JLabel labelDebut = new JLabel("D\u00E9but");
		labelDebut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_labelDebut = new GridBagConstraints();
		gbc_labelDebut.insets = new Insets(0, 0, 5, 5);
		gbc_labelDebut.anchor = GridBagConstraints.WEST;
		gbc_labelDebut.gridx = 1;
		gbc_labelDebut.gridy = 7;
		add(labelDebut, gbc_labelDebut);
		
		String[] heuresEvent = new String[24];
		String[] minutesEvent = new String[60];
		for(int i=0; i<24;i++)
			{
			heuresEvent[i] = i+"";
			}
		for(int i=0; i<60;i++)
			{
			minutesEvent[i] = i+"";
			}
		
		JComboBox comboBox = new JComboBox(heuresEvent);
		
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 7;
		add(comboBox, gbc_comboBox);
		
		JLabel label = new JLabel(":");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 3;
		gbc_label.gridy = 7;
		add(label, gbc_label);
		
		JComboBox comboBox_1 = new JComboBox(minutesEvent);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 4;
		gbc_comboBox_1.gridy = 7;
		add(comboBox_1, gbc_comboBox_1);
		
		JLabel lblFin = new JLabel("Fin");
		GridBagConstraints gbc_lblFin = new GridBagConstraints();
		gbc_lblFin.insets = new Insets(0, 0, 5, 5);
		gbc_lblFin.anchor = GridBagConstraints.WEST;
		gbc_lblFin.gridx = 1;
		gbc_lblFin.gridy = 8;
		add(lblFin, gbc_lblFin);
		
		JComboBox comboBox_2 = new JComboBox(heuresEvent);
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 2;
		gbc_comboBox_2.gridy = 8;
		add(comboBox_2, gbc_comboBox_2);
		
		JLabel label_1 = new JLabel(":");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 8;
		add(label_1, gbc_label_1);
		
		JComboBox comboBox_3 = new JComboBox(minutesEvent);
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_3.gridx = 4;
		gbc_comboBox_3.gridy = 8;
		add(comboBox_3, gbc_comboBox_3);
		
		JLabel lblDescription = new JLabel("Description");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.anchor = GridBagConstraints.WEST;
		gbc_lblDescription.gridx = 1;
		gbc_lblDescription.gridy = 10;
		add(lblDescription, gbc_lblDescription);
		
		JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.gridheight = 2;
		gbc_textArea.gridwidth = 3;
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 2;
		gbc_textArea.gridy = 10;
		add(textArea, gbc_textArea);
		}
	public void actionPerformed(ActionEvent parEvent)
		{
		
		}
}
