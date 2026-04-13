import java.sql.*;  // Import Java SQL classes

public class java_45606_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost/testdb";  
    private static final String USERNAME = "root";     
    private static final String PASSWORD =  "";    
      
        // Open a connection to the database  (Replace with your own credentials)        
	public Connection openConnection() {              
		return DriverManager.getConnection(DB_URL,USERNAME ,PASSWORD);            
	}  		                  
	       	 	   	// Prepare SQL query and return statement             				         			    // A01B: Add appropriate exception handling here (SQLException) 					       }                       public Statement prepareStatement() { try{return conn.createStatement();} catch(SQLException se){se.printStackTrace();}}                  
               	  			// Execute the SQL query and return result set             				         			    // A01B: Add appropriate exception handling here (SQLException) 					       } public ResultSet executeQuery() { try{return stmt.executeQuery("SELECT * FROM Employees");} catch(SQLException se){se.printStackTrace();}}                  
               	  			// Update the database with data from a result set             				         			    // A01B: Add appropriate exception handling here (SQLException) 					       } public void updateDatabase() { try{stmt = conn.createStatement()) catch(SQLException se){se.printStackTrace();}}