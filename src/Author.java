/**
 * 
 * @author Andrey
 *
 */
public class Author extends Person {

	/*
	 * NO-ARG CONSTRUCTOR
	 */
	public Author() {
		super();
	}
	
	/*
	 * ARG CONSTRUCTOR
	 */
	public Author(int id, String name, String email) {
		super(id, name, email);
	}

	/*
	 * COPY CONSTRUCTOR
	 */
	public Author(Author object) {
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

} // end of class
