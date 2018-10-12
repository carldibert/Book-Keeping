import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class AuthorListPanel extends JPanel {

	// ********************************
	// ATTRIBUTES
	// ********************************
	
	private JList authorList;

	// ********************************
	// CONSTRUCTOR
	// ********************************
	
	public AuthorListPanel() {
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createTitledBorder("List of Authors"));

		authorList = new JList();
		authorList.setVisibleRowCount(20);
		authorList.setFixedCellWidth(200);
		authorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane listScrollPane = new JScrollPane(authorList);

		this.add(listScrollPane);
	}// end of constructor

	// ********************************
	// GETS/SETS
	// ********************************
	
	public JList getAuthorList() {
		return authorList;
	}

	public void setList(ArrayList<Author> arrayList){
		authorList.setListData(arrayList.toArray());
	}
	
	// ********************************
	// METHODS
	// ********************************
	
}// end of class
