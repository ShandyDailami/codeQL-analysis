import java.sql.*;   // Import necessary classes 

public class java_43121_JDBCQueryHandler_A03 {    
    public static void main(String[] args) throws SQLException{     
        String url = "jdbc:mysql://localhost/test";      
        
        Connection connection;         
        Statement stmt;              
                
        // Step 1 - Open a connection to the database.  
		/*Note that we should use this in production code instead of hard-coded credentials*/   
	    try {           
			// This is using MySQL's native driver for JDBC      
	        Class.forName("com.mysql.jdbc.Driver");     // Step 2 - Register the Driver  
	         connection = DriverManager.getConnection(url,"username","password" );    }      catch (ClassNotFoundException e) {          throw new ExceptionInInitializerError("You must set driver in your classpath",e);       }}       		
	       			    
	// Step 3 - Create a statement for sending SQL query to the database  
	try{ stmt = connection.createStatement();}catch(SQLException e){throw new RuntimeException("Cannot create Statement object"); }    try {          // Execute your Query here         System.out.println ("Executing your first query: " +query);           ResultSet rs;           
	rs=stmt.executeQuery (“select * from Employee” );  while(rs.next()){      /*Note that we should avoid printing the entire result set*/          //Step4 - Extract data and print each column value    System .out .println ("First name: " + rs.getString("firstName"));}    
	}catch (SQLException e) { throw new RuntimeException(e); } 		        	   stmt.close(); connection.close();}} // Close the connections after use