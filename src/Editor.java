/**
 * 
 * @author Andrey
 *
 */
public class Editor extends Person {

	/*
	 * ARG CONSTRUCTOR
	 */
	public Editor(int id, String name, String email) {
		super(id, name, email);
		// TODO Auto-generated constructor stub
	}

	/*
	 * COPY CONSTRUCTOR
	 */
	public Editor(Editor object) {
		super(object.id, object.name, object.email);
		
		this.affiliation = object.affiliation;
		this.bio = object.bio;
		this.title = object.title;
		this.Picturefilename = object.Picturefilename;
		this.type = object.type;
	}

	/* 
	 * TO STRING
	 */
	@Override
	public String toString() {
		return name;
	}
		
}// end of class
