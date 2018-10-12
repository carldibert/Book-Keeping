import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 * 
 * @author Andrey
 *
 */
public class AuthorButtonPanel extends JToolBar {

	// ********************************
	// ATTRIBUTES
	// ********************************
	
	private JButton buttonNewAuthor;
	private JButton buttonUpdateAuthor;
	private JButton buttonDeleteAuthor;
	private JButton buttonCancelAuthor;
	
	// ********************************
	// CONSTRUCTOR
	// ********************************
	
	public AuthorButtonPanel() {
		this.setFloatable(false);
		this.setAlignmentY(LEFT_ALIGNMENT);
		
		buttonNewAuthor = new JButton("New");
		buttonNewAuthor.setMnemonic('N');
		buttonNewAuthor.setIcon(new ImageIcon("images/new.png"));
		buttonNewAuthor.setFocusPainted(false);
		
		buttonUpdateAuthor = new JButton("Update");
		buttonUpdateAuthor.setMnemonic('U');
		buttonUpdateAuthor.setIcon(new ImageIcon("images/accept.png"));
		buttonUpdateAuthor.setFocusPainted(false);
		
		buttonDeleteAuthor = new JButton("Delete");
		buttonDeleteAuthor.setMnemonic('D');
		buttonDeleteAuthor.setIcon(new ImageIcon("images/discard.png"));
		buttonDeleteAuthor.setFocusPainted(false);
		
		buttonCancelAuthor = new JButton("Cancel");
		buttonCancelAuthor.setMnemonic('C');
		buttonCancelAuthor.setIcon(new ImageIcon("images/cancel.png"));
		buttonCancelAuthor.setFocusPainted(false);
			
		this.add(buttonNewAuthor);
		this.add(buttonUpdateAuthor);
		this.add(buttonDeleteAuthor);
		this.add(buttonCancelAuthor);
		
		this.NewState();
		
	}//end of Constructor


	// ********************************
	// GETS/SETS
	// ********************************
	
	/**
	 * @return the buttonNewAuthor
	 */
	public JButton getButtonNewAuthor() {
		return buttonNewAuthor;
	}

	/**
	 * @return the buttonUpdateAuthor
	 */
	public JButton getButtonUpdateAuthor() {
		return buttonUpdateAuthor;
	}

	/**
	 * @return the buttonDeleteAuthor
	 */
	public JButton getButtonDeleteAuthor() {
		return buttonDeleteAuthor;
	}

	/**
	 * @return the buttonCancelAuthor
	 */
	public JButton getButtonCancelAuthor() {
		return buttonCancelAuthor;
	}

	// ********************************
	// METHODS
	// ********************************
	
	/**
	 * Used when the list has no items selected
	 */
	public void NewState(){
		this.buttonNewAuthor.setEnabled(true);
		this.buttonUpdateAuthor.setEnabled(false);
		this.buttonDeleteAuthor.setEnabled(false);
		this.buttonCancelAuthor.setEnabled(false);
	}
	
	/**
	 * Used when the list has an item selected
	 */
	public void UpdateState(){
		this.buttonNewAuthor.setEnabled(false);
		this.buttonUpdateAuthor.setEnabled(true);
		this.buttonDeleteAuthor.setEnabled(true);
		this.buttonCancelAuthor.setEnabled(true);
	}	
	
} // end of class
