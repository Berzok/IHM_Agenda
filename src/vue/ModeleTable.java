/**
 * 
 */
package vue;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.table.DefaultTableModel;

import modele.Agenda;
import modele.Date;
import modele.Evenement;

/**
 * @author Ugo
 *
 */
public class ModeleTable extends DefaultTableModel {

	/**
	 * @param parAgenda
	 */
	public ModeleTable(Agenda parAgenda) {
		// TODO Auto-generated constructor stub
		
		
		String[] laSemaine = {"lu", "ma", "me", "je", "ve", "sa", "di"};
		
		
		this.setColumnIdentifiers(laSemaine);
		this.setColumnCount(7);
		this.setRowCount(7);
		
		Date today = new Date();
		GregorianCalendar date = new GregorianCalendar();		
		int numSemaine = date.get (Calendar.WEEK_OF_YEAR);
		
		for(Evenement evt: parAgenda.getMap().get(numSemaine)){
			this.setValueAt(evt, 0, evt.getChDate().getJourSemaine());
		}
		
	}
	
	public Class getColumnClass(int parColonne){
		return Evenement.class;
	}

}
