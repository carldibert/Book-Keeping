/**
 * 
 * @author Andrey
 *
 */
public abstract class Person {

	// ********************************
	// ATTRIBUTES
	// ********************************
	
	protected int id;
	protected String name;
	protected String title;
	protected String email;
	protected String affiliation;
	protected String bio;
	protected String Picturefilename;
	protected String type;

	// ********************************
	// CONSTRUCTOR
	// ********************************
	
	public Person() {

	}
	
	public Person(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	// ********************************
	// GETS/SETS
	// ********************************
	
	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getPicturefilename() {
		return Picturefilename;
	}

	public void setPicturefilename(String picturefilename) {
		Picturefilename = picturefilename;
	}

	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	// ********************************
	// ATTRIBUTES
	// ********************************
	
	
	// ********************************
	// TO STRING
	// ********************************
	
	@Override
	public String toString() {
		return name;
	}

}// end of class
