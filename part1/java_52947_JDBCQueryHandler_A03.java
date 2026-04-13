import java.sql.*;  // Import required classes from the database package to enable JavaDBC operations using JdbcDriver and Connection interfaces  
public class java_52947_JDBCQueryHandler_A03 {    
    public static void main(String[] args) throws SQLException{     
        String url = "jdbc:mysql://localhost/test";       // Define your DB URL, change to match the actual database you're using. 
        Connection connection;             
	Statement statement;          
        
	// Open a new MySQL Connector and create an instance of it   for calling system properties (java.sql).    The string passed as parameter is JDBC driver name & DB URL, here we use the MySql Driver in our case which provides us with access to mysql database through jdbc 
        connection = DriverManager.getConnection(url,"username","password");              //Getting a Connection from Database     
	statement  =connection.createStatement();            /*** Creating Statement object ***/   		  
        	int rowsInserted;                      ///Declaring and Initializing row insertion variable          	   	     			 	 				     int affectedRows = 0 ;      					         	       
        String sql = "INSERT INTO employees (name, position) VALUES(?, ?);";                //Defining SQL Query                   		  	           						    PreparedStatement pstmt;                       try {                         if ((rowsInserted=statement.executeUpdate(sql)) > 0){                        System.out.println("Affected rows " + affectedRows+"");}}catch (Exception e)    				{System.err .printStackTrace();}  
        	try{pstmt = connection.prepareStatement ("INSERT INTO employees  ... "); } catch...(SQLSyntaxErrorException se){se.printStackTrace()};          try { if ((rowsInserted=statement.executeUpdate(" INSERT IGNORE INTO Employee (EmpID, EmpName) VALUES (? , ?)")) > 0 ){   
	System . out . println ("Affected rows " + affectedRows); }}catch ...(SQLException e){e.printStackTrace()};         try { if ((rowsInserted=statement.executeUpdate(" INSERT IGNORE INTO Employee (EmpID, EmpName) VALUES (? , ?)")) > 0 ){   
	System . out . println ("Affected rows " + affectedRows); }}catch ...(SQLException e){e.printStackTrace()};   }  // Closing connection and statement         if (!connection.isClosed()) {     		       try { Connection conn = null; Statement stmt=null;} catch ( SQLException ex ){ex. print stack trace();}}