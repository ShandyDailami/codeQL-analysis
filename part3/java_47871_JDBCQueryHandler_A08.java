import java.sql.*;   // Import necessary Java libraries for SQL tasks, ie., Statement & PreparedStatement objects and ResultSet object etc.   
public class java_47871_JDBCQueryHandler_A08 {    
	private Connection connection = null;      // Declare the database connnection variable       
	final String USERNAME="root";       // MySQL username  
	final String PASSWORD= "Password@123$%^&*()_+`~{}[]|\\:<>?.;,' ";     // Password  for user, remember to use secure method (hashed)        
    final String URL ="jdbc:mysql://localhost/test";     	//URL of the database      	  
	public java_47871_JDBCQueryHandler_A08() {        // Constructor that creates a new connection when this object is created.    		 	   									         			                   }           public void openConnection(){         try{            if(connection==null || !connection.isValid())               connection = DriverManager.getConnection (URL,USERNAME , PASSWORD );        }}
   catch(SQLException ex){             System .out .println ("Error in Connection " +ex);       }    finally {           if(!connection.isClosed() ) closeConnection();  }     		} public void closeConnection(){          try{         connection= null;    		                   DriverManager.getConnection (URL,USERNAME , PASSWORD );        }} catch(SQLException ex){            System .out .println ("Error in Closing Connection " +ex);    }}}