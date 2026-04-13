import java.sql.*;   // Import necessary Java libraries for JDBC communication   
    
public class java_43261_JDBCQueryHandler_A01 {  // Main Class definition     
       static Connection conn = null;        // Database connection object         
        
           public void connectToDatabase() throws SQLException{             
                String url="jdbc:mysql://localhost/testdb";            // JDBC URL for MySQL server (Replace it with your actual database)   
            	String username =  "root";                  	    	// User name of the user that will be accessing this db          
         	    String password = "password@123!";                 		       	 	       	     			     									  // Replace '!' by a strong random string to secure your database access.                   
             conn=DriverManager.getConnection(url,username,password);               	// Establish the connection              	           if (conn==null) {                      System.out.println("Cannot connect"); } else{System.out.println("Connected successfully into application")}  ;       	 	    };    
       public void executeQuery() throws SQLException                   // Method to Execute Query on Database         
   	{            	              									          			     		  								              String query = "SELECT * FROM Employee";                     Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost/testdb", “root”, “password@123!”);                          Statement stmt   =conn.createStatement();                      ResultSet rs    = 	stmt .executeQuery(query) ;                 while (rs != null && rs.next()) {                    System.out.println("ID = " + rs.getString("id"));                     }             };
        public static void main(String[] args){                         // Main Method to invoke all methods in sequence 		    try{                          connectToDatabase();                       executeQuery ();}catch     Exception e   {System . out      . println ("Error running program: " +e.getMessage());};              } };