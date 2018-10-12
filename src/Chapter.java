import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Andrey
 *
 */
public class Chapter {

	/*
	 * ATTRIBUTES
	 */
	private ArrayList<Person> authors;
	private String title;
	private String keywords;
	private String chapterAbstract;
	private int numberPages;
	private String chapterFilename;

	/*
	 * NO-ARG CONSTRUCTOR
	 */
	public Chapter() {
		// define size of lists
		authors = new ArrayList<Person>();
	}

	/*
	 * ARG CONSTRUCTOR
	 */
	public Chapter(String title) {
		this.title = title;
		// define size of lists
		authors = new ArrayList<Person>();
	}

	/*
	 * COPY CONSTRUCTOR
	 */
	public Chapter(Chapter object) {
		this.authors = object.authors; // implement deep copy for each author in
										// the list
		this.title = object.title;
		this.keywords = object.keywords;
		this.chapterAbstract = object.chapterAbstract;
		this.numberPages = object.numberPages;
		this.chapterFilename = object.chapterFilename;
	}

	/*
	 * GETs and SETs
	 */
	public ArrayList<Person> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<Person> authors) {
		this.authors = authors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getChapterAbstract() {
		return chapterAbstract;
	}

	public void setChapterAbstract(String chapterAbstract) {
		this.chapterAbstract = chapterAbstract;
	}

	public int getNumberPages() {
		return numberPages;
	}

	public void setNumberPages(int numberPages) {
		this.numberPages = numberPages;
	}

	public String getChapterFilename() {
		return chapterFilename;
	}

	public void setChapterFilename(String chapterFilename) {
		this.chapterFilename = chapterFilename;
	}

	/*
	 * TO STRING
	 */
	@Override
	public String toString() {
		return title;
	}

	/*
	 * METHODS
	 */
	public void addAuthor(Person person) {
		if (person instanceof Author)
			authors.add(new Author((Author) person));
		else if (person instanceof Editor)
			authors.add(new Editor((Editor) person));
	}

	public void addKeyword(String keyword) {
		keywords += ", " + keyword;
	}

	public int getCountAuthors() {
		return authors.size();
	}

}// end of class
