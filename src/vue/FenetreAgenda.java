package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.*;

import javax.swing.BoxLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class FenetreAgenda.
 */
public class FenetreAgenda extends JFrame {

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAgenda frame = new FenetreAgenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 *
	 * @throws ParseException the parse exception
	 */
	public FenetreAgenda() throws ParseException {
		setTitle("Agenda");
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		this.add(menuBar);
		PanelAgenda panelAgenda = new PanelAgenda();
		getContentPane().add(panelAgenda);
		panelAgenda.setLayout(new BoxLayout(panelAgenda, BoxLayout.LINE_AXIS));
		JMenuItem lesChoix = new JMenuItem();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1400, 400);
	}
}
