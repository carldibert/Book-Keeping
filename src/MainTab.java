import javax.swing.JList;
import javax.swing.JTabbedPane;

/**
 * 
 * @author Andrey
 *
 */
public class MainTab extends JTabbedPane {

	// ********************************
	// ATTRIBUTES
	// ********************************
	
	private AuthorPanel authorPanel;
	private PublisherPanel publisherPanel;
	private BookPanel bookPanel;
	
	// ********************************
	// CONSTRUCTOR
	// ********************************
	
	public MainTab(){
		
		authorPanel = new AuthorPanel();
		publisherPanel = new PublisherPanel();
		bookPanel = new BookPanel();
		
		addTab("Publishers", null, publisherPanel);
		addTab("Authors", null, authorPanel);
		addTab("Books", null, bookPanel);
				
	}
	
	// ********************************
	// GETS/SETS
	// ********************************
	
	public AuthorPanel getAuthorPanel(){
		return authorPanel;
	}
	
	public PublisherPanel getPublisherPanel(){
		return publisherPanel;
	}
	
	public BookPanel getBookPanel(){
		return bookPanel;
	}
	
	// ********************************
	// METHODS
	// ********************************
	
}// end of class
