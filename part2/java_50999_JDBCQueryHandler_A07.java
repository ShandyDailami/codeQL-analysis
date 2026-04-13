import java.sql.*;   // Import necessary Java SQL classes: Connection, Statement etc..   
public class java_50999_JDBCQueryHandler_A07 {      // Define a public static inner Class named 'JDBCQuery'      
     private String url;              // Declare instance variable for database URL         
     private String username;         // Instance variables to hold the user name and password       
     private String password ; 
    Connection conn = null;           // Define an object of connection class     
   Statement stmt=null, rs=null;       // Declare statement objects for SQL operations         
             public java_50999_JDBCQueryHandler_A07(String url , String username, String password) {        // Constructor to initialize the instance variables        
            this.url = url ;           // Setter method of URL and assign values   
			this.username=username;      
	    	    this.password=password;}     
             public void connect() {          // Connect Method  (Creating Connection)       
                 try{                     // Try block for exception handling        
                      conn = DriverManager.getConnection(url , username, password);  	// Get connection to database using the url and credentials passed in constructor          	    		    stmt=conn.createStatement();}               catch(SQLException e){                    System.out.println("Error while connecting: "+e );}}                 
                 finally{                   // Finally block for ensuring that resources are always closed whether an exception occurs or not              try { conn = DriverManager.getConnection (url, username , password) ; stmt=conn.createStatement(); } catch(SQLException e){ System .out   (.println (" Error while connecting: " +e));}           
             }}                   // End of Connect Method    	  		    public ResultSet executeQuery() {      // Execute a SQL SELECT statement          try{         stmt = conn.createStatement();        rs=stmt.executeQuery("SELECT * FROM Employees");       return  rs; }catch(SQLException e){           System .out (.println (" Error in executing query: " +e));}     
             public void closeConnection(){     // Close Connection Method            try{         stmt = conn.createStatement();        rs=stmt.executeQuery("SELECT * FROM Employees");       return  rs; }catch(SQLException e){           System .out (.println (" Error in executing query: " +e));}