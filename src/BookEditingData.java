import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * 
 * @author Andrey
 *
 */
public class BookEditingData {

	// ********************************
	// ATTRIBUTES
	// ********************************
	
	private ArrayList<Author> authors = new ArrayList<Author>();
	private ArrayList<Publisher> publishers = new ArrayList<Publisher>();
	private ArrayList<Book> books = new ArrayList<Book>();
	private ArrayList<Chapter> chapters = new ArrayList<Chapter>();

	// ********************************
	// CONSTRUCTOR
	// ********************************
	
	public BookEditingData(){
		
	}
	
	// ********************************
	// GETS/SETS
	// ********************************
	
	public ArrayList<Author> getAuthors() {	
		return authors;
	}
	
	public ArrayList<Publisher> getPublishers() {	
		return publishers;
	}
	
	public ArrayList<Chapter> getChapters(){
		return chapters;
	}
	
	public ArrayList<Book> getBooks(){
		return books;
	}
	
	// ********************************
	// METHODS
	// ********************************
	
	public boolean SelectAuthors(){
		DBConnect db = new DBConnect();
		
		this.authors = new ArrayList<Author>();
				
		String sql = "SELECT * FROM AuthorEditor ORDER BY Name";
		
		ResultSet rs = db.select(sql);

		if (rs != null) {
			try {
				while (rs.next()) {
					// Retrieve by column name
					String id = rs.getString("AuthorID");
					String name = rs.getString("Name");
					String email = rs.getString("Email");
					String type = rs.getString("Type");
					String bio = rs.getString("Bio");
					String affiliation = rs.getString("Affiliation");

					Author tempAuthor = new Author();
					tempAuthor.setID(Integer.parseInt(id));
					tempAuthor.setName(name);
					tempAuthor.setEmail(email);
					tempAuthor.setType(type);
					tempAuthor.setBio(bio);
					tempAuthor.setAffiliation(affiliation);

					this.authors.add(tempAuthor);
				}
				
				db.close();
				
				return true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Invalid Query!");
		}
		
		db.close();
		
		return false;
		
	}// end of readAuthors method
	
	public void insertAuthor(String name, String email, String type, String bio, String affiliation) {
		DBConnect db = new DBConnect();
		
		String sql = "INSERT INTO AuthorEditor (Name, Email, Type, Bio, Affiliation) " +
				"VALUES ('" + name + "','" + email + "','"+ type +"','" + bio+ "','"+ affiliation +"')";
		
		int rows = db.update(sql);

		if (rows == 0)
			JOptionPane.showMessageDialog(null, "Invalid Insert!");
		else 
			JOptionPane.showMessageDialog(null, "Author inserted!");
		
		db.close();
	}

	/**
	 * 
	 */
	public void updateAuthor(int ID, String name, String email, String type, String bio, String affiliation) {
		DBConnect db = new DBConnect();
		
		String sql = "UPDATE AuthorEditor SET " +
				" Name='"+ name +"'," +
				" Email='"+ email +"'," +
				" Type='"+ type +"'," +
				" Bio='"+ bio +"'," +
				" Affiliation='"+ affiliation +"'" +
				" WHERE AuthorID=" + ID;

		int rows = db.update(sql);

		if (rows == 0)
			JOptionPane.showMessageDialog(null, "Invalid Update!");
		else 
			JOptionPane.showMessageDialog(null, "Author updated!");
		
		db.close();
	}

	/**
	 * 
	 */
	public void deleteAuthor(int ID) {
		DBConnect db = new DBConnect();
		
		String sql = "DELETE FROM AuthorEditor WHERE AuthorID=" + ID;

		int rows = db.update(sql);

		if (rows == 0)
			JOptionPane.showMessageDialog(null, "Invalid Delete!");
		else 
			JOptionPane.showMessageDialog(null, "Author deleted!");
		
		db.close();
	}
	
	public boolean SelectPublisher(){
		DBConnect db = new DBConnect();
		
		this.books = new ArrayList<Book>();
				
		String sql = "SELECT * FROM Publisher";
		
		ResultSet rs = db.select(sql);

		if (rs != null) {
			try {
				while (rs.next()) {
					// Retrieve by column name
					String publisher = rs.getString("PublisherID");
					String name = rs.getString("Name");
					String address = rs.getString("Address");
					String phone = rs.getString("Phone");
					String url = rs.getString("URL");

					Publisher tempPublisher = new Publisher();
					tempPublisher.setPublisherID(Integer.parseInt(publisher));
					tempPublisher.setName(name);
					tempPublisher.setAddress(address);
					tempPublisher.setPhone(phone);
					tempPublisher.setUrl(url);
					
					this.publishers.add(tempPublisher);
				}
				
				db.close();
				
				return true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Invalid Query!");
		}
		
		db.close();
		
		return false;
		
	}// end of SelectPublisher method
	
	public void insertPublisher(String name, String address, String phone, String url) {
		DBConnect db = new DBConnect();
		
		String sql = "INSERT INTO Publisher (Name, Address, Phone, URL) " +
				"VALUES ('" + name + "','" + address + "','"+ phone +"','" + url + "')";
		
		int rows = db.update(sql);

		if (rows == 0)
			JOptionPane.showMessageDialog(null, "Invalid Insert!");
		else 
			JOptionPane.showMessageDialog(null, "Author inserted!");
		
		db.close();
	}	// end of inertPublisher
	
	public void updatePublisher(int ID, String name, String address, String phone, String url) {
		DBConnect db = new DBConnect();
	
		String sql = "UPDATE Publisher SET " +
				" Name='"+ name +"'," +
				" Address='"+ address +"'," +
				" Phone='"+ phone +"'," +
				" url='"+ url +"'," +
				" WHERE PublisherID=" + ID;

		int rows = db.update(sql);

		if (rows == 0)
			JOptionPane.showMessageDialog(null, "Invalid Update!");
		else 
			JOptionPane.showMessageDialog(null, "Author updated!");
	
		db.close();
	}
	
	public void deletePublisher(int ID) {
		DBConnect db = new DBConnect();
		
		String sql = "DELETE FROM Publisher WHERE PublisherID=" + ID;

		int rows = db.update(sql);

		if (rows == 0)
			JOptionPane.showMessageDialog(null, "Invalid Delete!");
		else 
			JOptionPane.showMessageDialog(null, "Author deleted!");
		
		db.close();
	}
	
	public boolean SelectChapter(){
		DBConnect db = new DBConnect();
		
		this.books = new ArrayList<Book>();
				
		String sql = "SELECT * FROM Chapter";
		
		ResultSet rs = db.select(sql);

		if (rs != null) {
			try {
				while (rs.next()) {
					// Retrieve by column name
					String title = rs.getString("Title");
					String keywords = rs.getString("Keywords");
					String chapterAbstract = rs.getString("Abstract");
					String pages = rs.getString("NumberPages");

					Chapter tempChapter = new Chapter();
					tempChapter.setTitle(title);
					tempChapter.setKeywords(keywords);
					tempChapter.setChapterAbstract(chapterAbstract);
					tempChapter.setNumberPages(Integer.parseInt(pages));
					
					this.chapters.add(tempChapter);
				}
				
				db.close();
				
				return true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Invalid Query!");
		}
		
		db.close();
		
		return false;
		
	}// end of SelectChapters method
	
	public void insertChapter(String title, String keywords, String chapterAbstract, String pages) {
		DBConnect db = new DBConnect();
		
		String sql = "INSERT INTO Chapter (Title, ISBN, Year, EditorID, PublisherID) " +
				"VALUES ('" + title + "','" + keywords + "','"+ chapterAbstract +"','" + pages+ "')";
		
		int rows = db.update(sql);

		if (rows == 0)
			JOptionPane.showMessageDialog(null, "Invalid Insert!");
		else 
			JOptionPane.showMessageDialog(null, "Author inserted!");
		
		db.close();
	}
	
	public void deleteChapter(int ID) {
		DBConnect db = new DBConnect();
		
		String sql = "DELETE FROM Chapter WHERE ChapterID=" + ID;

		int rows = db.update(sql);

		if (rows == 0)
			JOptionPane.showMessageDialog(null, "Invalid Delete!");
		else 
			JOptionPane.showMessageDialog(null, "Author deleted!");
		
		db.close();
	}
	
	public boolean SelectBook(){
		DBConnect db = new DBConnect();
		
		this.books = new ArrayList<Book>();
				
		String sql = "SELECT * FROM Book";
		
		ResultSet rs = db.select(sql);
		
		if (rs != null) {
			try {
				while (rs.next()) {
					// Retrieve by column name
					String title = rs.getString("Title");
					String isbn = rs.getString("ISBN");
					String year = rs.getString("Year");
					
					Book tempBook = new Book();
					tempBook.setTitle(title);
					tempBook.setIsbn(isbn);
					tempBook.setYear(Integer.parseInt(year));
					
					this.books.add(tempBook);
				}
				
				db.close();
				
				return true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Invalid Query!");
		}
		
		db.close();
		
		return false;
		
	}// end of SelectBook method
	
	public void insertBook(String Title, String ISBN, String Year, String EditorID, String PublisherID) {
		DBConnect db = new DBConnect();
		
		String sql = "INSERT INTO Book (Title, ISBN, Year, EditorID, PublisherID) " +
				"VALUES ('" + Title + "','" + ISBN + "','"+ Year +"','" + EditorID+ "','"+ PublisherID +"')";
		
		int rows = db.update(sql);

		if (rows == 0)
			JOptionPane.showMessageDialog(null, "Invalid Insert!");
		else 
			JOptionPane.showMessageDialog(null, "Author inserted!");
		
		db.close();
	}
	
	public void deleteBook(int ID) {
		DBConnect db = new DBConnect();
		
		String sql = "DELETE FROM Book WHERE BookID=" + ID;

		int rows = db.update(sql);

		if (rows == 0)
			JOptionPane.showMessageDialog(null, "Invalid Delete!");
		else 
			JOptionPane.showMessageDialog(null, "Author deleted!");
		
		db.close();
	}
}
