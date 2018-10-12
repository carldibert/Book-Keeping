import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class AuthorInputPanel extends JPanel{

	//********************************
	// ATTRIBUTES
	//********************************
	
	private JLabel labelId;
	private JLabel labelName;
	private JLabel labelEmail;
	private JLabel labelType;
	private JLabel labelBio;
	private JLabel labelAffiliation;

	private JTextField tfId;
	private JTextField tfName;
	private JTextField tfEmail;
	private JComboBox cbType;
	private JTextArea taBio;
	private JTextField tfAffiliation;
	
	private JPanel topPanel;
	private JPanel bottomPanel;
	
	private String[] type_user = {"Author", "Editor"};
	
	//********************************
	// CONSTRUCTORS
	//********************************
	
	public AuthorInputPanel(){
		this.setLayout(new BorderLayout());
		
		topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(11,1));
		
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1,1));
		
		labelId = new JLabel("ID:");
		labelName = new JLabel("Name:");
		labelEmail = new JLabel("Email:");
		labelType = new JLabel("Type:");
		labelBio = new JLabel("Bio:");
		labelAffiliation = new JLabel("Affiliation:");
		
		tfId = new JTextField();
		tfName = new JTextField(30);
		tfEmail = new JTextField();
		cbType = new JComboBox(type_user);
		taBio = new JTextArea();
		tfAffiliation = new JTextField();

		tfId.setEditable(false);
		
		taBio.setLineWrap(true);
		taBio.setWrapStyleWord(true);
		taBio.setRows(4);
		JScrollPane scrollBio = new JScrollPane(taBio);
        scrollBio.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		topPanel.add(labelId);
		topPanel.add(tfId);
		topPanel.add(labelName);
		topPanel.add(tfName);
		topPanel.add(labelEmail);
		topPanel.add(tfEmail);
		topPanel.add(labelType);
		topPanel.add(cbType);
		topPanel.add(labelAffiliation);
		topPanel.add(tfAffiliation);		
		topPanel.add(labelBio);
		
		bottomPanel.add(scrollBio);
		
		this.add(topPanel, "Center");
		this.add(bottomPanel, "South");
		
	}// end of Constructor

	//********************************
	// GETS/SETS
	//********************************
	
	public JTextField getTfId() {
		return tfId;
	}

	public void setTfId(JTextField tfId) {
		this.tfId = tfId;
	}

	public JTextField getTfName() {
		return tfName;
	}

	public void setTfName(JTextField tfName) {
		this.tfName = tfName;
	}

	public JTextField getTfEmail() {
		return tfEmail;
	}

	public void setTfEmail(JTextField tfEmail) {
		this.tfEmail = tfEmail;
	}

	public JComboBox getCbType() {
		return cbType;
	}

	public void setCbType(JComboBox cbType) {
		this.cbType = cbType;
	}

	public JTextArea getTaBio() {
		return taBio;
	}

	public void setTaBio(JTextArea taBio) {
		this.taBio = taBio;
	}

	public JTextField getTfAffiliation() {
		return tfAffiliation;
	}

	public void setTfAffiliation(JTextField tfAffiliation) {
		this.tfAffiliation = tfAffiliation;
	}
	
	//********************************
	// METHODS
	//********************************
	
	public void resetForm() {
		this.tfId.setText("");
		this.tfName.setText("");
		this.tfEmail.setText("");
		this.cbType.setSelectedItem("Author");
		this.taBio.setText("");
		this.tfAffiliation.setText("");
	}
	
} // end of class
