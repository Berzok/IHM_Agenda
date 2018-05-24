/**
 * 
 */
package vue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import modele.Date;
import modele.Agenda;

/**
 * @author Ugo
 *
 */
public class PanelAffichage extends JPanel{

	/**
	 * @param laDate
	 * 
	 */
	
	public PanelAffichage(Date parDate, Agenda parAgenda){
		JTable laTable = new JTable();
		laTable.setModel(new ModeleTable(parAgenda));
		
		
		laTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane leScrolling = new JScrollPane(laTable,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		this.add(leScrolling);
		
		
	}
	public void setDate(Date laDate) {
		// TODO Auto-generated method stub
		
	}
	
	}
