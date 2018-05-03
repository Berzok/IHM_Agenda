package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.Box;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;

public class FenetreAgenda extends JFrame {
	 PanelAgenda panelAgenda;
	 static FenetreAgenda myself;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
		{
		
		try
			{
			FenetreAgenda frame = new FenetreAgenda();
			frame.setVisible(true);
			}
		catch (Exception e)
			{
			e.printStackTrace();
			}
		}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public FenetreAgenda() throws ParseException
		{
		setTitle("Agenda");
		myself = this;
		new Thread()
		{
		public void run()
			{
			myself.actualiser();
			}
		}.start();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(750, 400);
		panelAgenda = new PanelAgenda();
		getContentPane().add(panelAgenda);
		panelAgenda.setLayout(new BoxLayout(panelAgenda, BoxLayout.LINE_AXIS));
		}
	public void actualiser()
		{
		myself.revalidate();
		myself.repaint();
		}
	}
