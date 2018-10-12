import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * 
 * @author Andrey
 *
 */
@SuppressWarnings("serial")
public class BookEditingDemo extends JFrame {

	// ********************************
	// ATTRIBUTES
	// ********************************

	private BookEditingData data;
	private MainTab mainTabs;

	// ********************************
	// CONSTRUCTOR
	// ********************************

	public BookEditingDemo() {
		this.setTitle("Book Editing Application");

		mainTabs = new MainTab();

		this.add(mainTabs, "Center");

		pack();

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);

		this.setResizable(false);

		// Create instance of DATA HANDLER
		data = new BookEditingData();

		// Refresh List
		data.SelectAuthors();
		data.SelectPublisher();
		data.SelectChapter();
		data.SelectBook();
		
		mainTabs.getAuthorPanel().getAuthorListPanel().setList(data.getAuthors());
		mainTabs.getAuthorPanel().getAuthorButtonPanel().requestFocusInWindow();
		
		System.out.println(data.getAuthors());
		System.out.println(data.getPublishers());
		System.out.println(data.getBooks());
		System.out.println(data.getChapters());

		setVisible(true);

		this.setListeners();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	// ********************************
	// METHODS
	// ********************************

	public void setListeners() {
		// AUTHOR LIST PANEL
		this.mainTabs.getAuthorPanel().getAuthorListPanel().getAuthorList()
				.addListSelectionListener(new AuthorsListListener());
		// AUTHOR BUTTON PANEL
		this.mainTabs.getAuthorPanel().getAuthorButtonPanel().getButtonNewAuthor()
				.addActionListener(new AuthorButtonListener());
		this.mainTabs.getAuthorPanel().getAuthorButtonPanel().getButtonUpdateAuthor()
				.addActionListener(new AuthorButtonListener());
		this.mainTabs.getAuthorPanel().getAuthorButtonPanel().getButtonDeleteAuthor()
				.addActionListener(new AuthorButtonListener());
		this.mainTabs.getAuthorPanel().getAuthorButtonPanel().getButtonCancelAuthor()
				.addActionListener(new AuthorButtonListener());

	}// end of setListener

	// ********************************
	// MAIN METHOD
	// ********************************

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new BookEditingDemo();

	} // end of main method

	// ********************************
	// INNER CLASSES
	// ********************************

	private class AuthorsListListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {

			if (!e.getValueIsAdjusting()) {
				int num = mainTabs.getAuthorPanel().getAuthorListPanel().getAuthorList().getSelectedIndex();
				
				mainTabs.getAuthorPanel().getAuthorButtonPanel().UpdateState();
				
				if(num >= 0){
					Author author = new Author(data.getAuthors().get(num));
	
					mainTabs.getAuthorPanel().getAuthorInputPanel().getTfId().setText(author.getID()+"");			
					mainTabs.getAuthorPanel().getAuthorInputPanel().getTfName().setText(author.getName());
					mainTabs.getAuthorPanel().getAuthorInputPanel().getTfEmail().setText(author.getEmail());
					mainTabs.getAuthorPanel().getAuthorInputPanel().getCbType().setSelectedItem(author.getType());
					mainTabs.getAuthorPanel().getAuthorInputPanel().getTaBio().setText(author.getBio());
					mainTabs.getAuthorPanel().getAuthorInputPanel().getTfAffiliation().setText(author.getAffiliation());
				}
			}
		}
	}// end of inner class AuthorsListListener

	private class AuthorButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			//NEW BUTTON
			if (e.getSource() == mainTabs.getAuthorPanel().getAuthorButtonPanel().getButtonNewAuthor()) {
				
				// Get data from teh FORM
				String name = mainTabs.getAuthorPanel().getAuthorInputPanel().getTfName().getText();
				String email = mainTabs.getAuthorPanel().getAuthorInputPanel().getTfEmail().getText();
				String type = mainTabs.getAuthorPanel().getAuthorInputPanel().getCbType().getSelectedItem().toString();
				String bio = mainTabs.getAuthorPanel().getAuthorInputPanel().getTaBio().getText();
				String affiliation = mainTabs.getAuthorPanel().getAuthorInputPanel().getTfAffiliation().getText();

				// check if name and email are not empty
				if(!name.isEmpty() && !email.isEmpty()){
					
					// Insert
					data.insertAuthor(name, email, type, bio, affiliation);
					
					// Clear Form 
					mainTabs.getAuthorPanel().getAuthorInputPanel().resetForm();
					
					// Refresh List and set buttons
					data.SelectAuthors();
					mainTabs.getAuthorPanel().getAuthorListPanel().setList(data.getAuthors());
					mainTabs.getAuthorPanel().getAuthorButtonPanel().requestFocusInWindow();
					mainTabs.getAuthorPanel().getAuthorButtonPanel().NewState();
				}
				else {
					JOptionPane.showMessageDialog(null, "Name and Email are mandatory.");
				}
			} 
			// UPDATE BUTTON
			else if (e.getSource() == mainTabs.getAuthorPanel().getAuthorButtonPanel().getButtonUpdateAuthor()) {

				// Get data from teh FORM
				String name = mainTabs.getAuthorPanel().getAuthorInputPanel().getTfName().getText();
				String email = mainTabs.getAuthorPanel().getAuthorInputPanel().getTfEmail().getText();
				String type = mainTabs.getAuthorPanel().getAuthorInputPanel().getCbType().getSelectedItem().toString();
				String bio = mainTabs.getAuthorPanel().getAuthorInputPanel().getTaBio().getText();
				String affiliation = mainTabs.getAuthorPanel().getAuthorInputPanel().getTfAffiliation().getText();
				
				// check if name and email are not empty
				if(!name.isEmpty() && !email.isEmpty()){
					
					// Get author selected from the list
					int num = mainTabs.getAuthorPanel().getAuthorListPanel().getAuthorList().getSelectedIndex();
					
					// get corresponding author ID for item selected
					int authorID = data.getAuthors().get(num).getID();
					
					// Update
					data.updateAuthor(authorID, name, email, type, bio, affiliation);
	
					// Refresh List
					data.SelectAuthors();
					mainTabs.getAuthorPanel().getAuthorListPanel().setList(data.getAuthors());
					mainTabs.getAuthorPanel().getAuthorListPanel().getAuthorList().setSelectedIndex(num);
					mainTabs.getAuthorPanel().getAuthorListPanel().getAuthorList().requestFocusInWindow();
				}
				else {
					JOptionPane.showMessageDialog(null, "Name and Email are mandatory.");
				}
				
			} 
			// DELETE BUTTON
			else if (e.getSource() == mainTabs.getAuthorPanel().getAuthorButtonPanel().getButtonDeleteAuthor()) {

				// Get author selected from the list
				int num = mainTabs.getAuthorPanel().getAuthorListPanel().getAuthorList().getSelectedIndex();
				
				// Delete
				data.deleteAuthor(data.getAuthors().get(num).getID());

				// Clear Form 
				mainTabs.getAuthorPanel().getAuthorInputPanel().resetForm();
				
				// Refresh List and set buttons
				data.SelectAuthors();
				mainTabs.getAuthorPanel().getAuthorListPanel().setList(data.getAuthors());
				mainTabs.getAuthorPanel().getAuthorButtonPanel().requestFocusInWindow();				
				mainTabs.getAuthorPanel().getAuthorButtonPanel().NewState();
				
			} 
			// CANCEL BUTTON
			else if (e.getSource() == mainTabs.getAuthorPanel().getAuthorButtonPanel().getButtonCancelAuthor()) {
				
				// Clear Form and set buttons
				mainTabs.getAuthorPanel().getAuthorInputPanel().resetForm();
				
				// Unselect List and set buttons
				mainTabs.getAuthorPanel().getAuthorListPanel().setList(data.getAuthors());
				mainTabs.getAuthorPanel().getAuthorButtonPanel().requestFocusInWindow();				
				mainTabs.getAuthorPanel().getAuthorButtonPanel().NewState();
			}
		}
		
	}// end of inner class AuthorButtonListener

}// end of class
