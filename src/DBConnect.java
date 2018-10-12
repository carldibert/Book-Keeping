import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


/**
 * 
 * @author Andrey
 *
 */
public class DBConnect {

	// ********************************
	// ATTRIBUTES
	// ********************************
	
	// Credentials
	private final String DBNAME = "ist312_g1";	// replace with your group's information
	private final String USERNAME = "ist312_g1";	// replace with your group's information
	private final String PASSWORD = "ju3yWcrqCefU8u84";	// replace with your group's information
			
	// Driver
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://asoares.casa.siu.edu/" + DBNAME;
	
	private Connection conn = null; 
	
	// ********************************
	// CONSTRUCTOR
	// ********************************
	
	public DBConnect(){
		
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Connection Failed!\nCheck your credentials.");
		}
		
		
	} // end of Constructor
	
	// ********************************
	// METHODS
	// ********************************
	
	public Connection isConnected(){
		return conn;
	}
	
	public ResultSet select(String sql){ // select
		
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
		
	}// end of Select 
	
	public int update(String sql){ // insert, delete or update
		int numRows = 0;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			numRows = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return numRows;
	}// end of update
	
	public void close(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
} // end of Class





