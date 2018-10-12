import java.util.ArrayList;

/**
 * 
 * @author Andrey
 *
 */
public class Book {

	/*
	 * ATTRIBUTES
	 */
	private String title;
	private ArrayList<Editor> editors;
	private Publisher publisher;
	private int edition;
	private String isbn;
	private ArrayList<Chapter> chapters;
	private int year;

	/*
	 * NO-ARG CONSTRUCTOR
	 */
	public Book() {
		// define size of lists
		editors = new ArrayList<Editor>();
		chapters = new ArrayList<Chapter>();
	}

	/*
	 * ARG CONSTRUCTOR
	 */
	public Book(String title) {
		super();
		this.title = title;
		// define size of lists
		editors = new ArrayList<Editor>();
		chapters = new ArrayList<Chapter>();
	}

	/*
	 * COPY CONSTRUCTOR
	 */
	public Book(Book object) {
		this.title = object.title;
		this.editors = object.editors; // implement deep copy for each editor in
										// the list
		this.publisher = new Publisher(object.publisher);
		this.edition = object.edition;
		this.isbn = object.isbn;
		this.chapters = object.chapters; // implement deep copy for each chapter
										 //in the list
	}

	/*
	 * GETs and SETs
	 */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<Editor> getEditors() {
		return editors;
	}

	public void setEditors(ArrayList<Editor> editors) {
		this.editors = editors;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public ArrayList<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(ArrayList<Chapter> chapters) {
		this.chapters = chapters;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	/*
	 * TO STRING
	 */
	public String toString() {
		return title;
	}

	/*
	 * METHODS
	 */
	public void addEditor(Editor editor) {
		editors.add(new Editor(editor));
	}

	public void addChapter(Chapter chapter) {
		chapters.add(new Chapter(chapter));
	}

	public int getCountEditors() {
		return editors.size();
	}

	public int getCountChapters() {
		return chapters.size();
	}

	public int getTotalPages() {
		int total = 0;
		for (int i = 0; i < chapters.size(); i++) {
			total += chapters.get(i).getNumberPages();
		}
		return total;
	}

	public String getAPACitation() {
		String citation = "";

		for (int i = 0; i < this.editors.size(); i++) {
			if (i > 0) {
				citation += ", ";
			}
			Editor e = this.editors.get(i);
			String[] Names = e.getName().split(" ");
			int size = Names.length;
			String lastName = Names[size - 1];
			char firstLetter = Names[0].charAt(0);

			citation += lastName + ", " + firstLetter + ".";
		}

		return citation + " (" + this.getYear() + ") " + this.getTitle() + ", " + this.getPublisher().getName();

	}

}// end of class
