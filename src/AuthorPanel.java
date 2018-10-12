import java.awt.BorderLayout;

import javax.swing.JPanel;

public class AuthorPanel extends JPanel {

	// ********************************
	// ATTRIBUTES
	// ********************************
	
	private AuthorListPanel authorListPanel;
	private AuthorInputPanel authorInputPanel;
	private AuthorButtonPanel authorButtonPanel;
	
	// ********************************
	// CONSTRUCTOR
	// ********************************
	
	public AuthorPanel(){
		this.setLayout(new BorderLayout());
		
		authorListPanel = new AuthorListPanel();
		authorInputPanel = new AuthorInputPanel();
		authorButtonPanel = new AuthorButtonPanel();
		
		this.add(authorListPanel, "West");
		this.add(authorInputPanel, "Center");
		this.add(authorButtonPanel, "North");
	}
	
	// ********************************
	// GETS/SETS
	// ********************************
	
	public AuthorListPanel getAuthorListPanel(){
		return authorListPanel;
	}
	
	public AuthorInputPanel getAuthorInputPanel(){
		return authorInputPanel;
	}
	
	public AuthorButtonPanel getAuthorButtonPanel(){
		return authorButtonPanel;
	}
	
	// ********************************
	// METHODS
	// ********************************
	
}// end of Class
