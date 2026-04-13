import java.sql.*;  // Import Statement, PreparedStatement & ResultSet interfaces  
    
public class java_47574_JDBCQueryHandler_A07 {   
      
 public Connection connectToDatabase(String dbURL , String userName , char[] password){        
        try{            
            return DriverManager.getConnection(dbURL,userName,password);           // Returning the connection object 
        }catch (SQLException e ){               
          System.out.println("Error in connecting to database " +e );              // Error handling and displaying an error message if any occurred    
         return null;                        
       }                           
   }     
    public ResultSet executeQuery(Connection connection , String query){           
        try {                         
           Statement stmt =connection.createStatement();          // Create a statement object to perform SQL operations 
		return stmt.executeQuery(query);                               // Execute the given sql Query and return the result set   
	    } catch (SQLException e)   {                     	// Error handling in case any error occurs while executing query              System.out.println("Error: " +e );            Print out an appropriate message for user               	return null;       		}                   // Close resources if exceptions occurred 	        connection.close();     
       }   									                    			     return null;}   void main(String[] args) {		 Connection con = connectToDatabase ("jdbc:mysql://localhost/test", "root","password"); ResultSet rs =  executeQuery (con, "select * from users where username='Johnny' and password like 'pass12345';")  if (rs !=  null) { while(rs.next()) System.out.println("Name: " + rs.getString("username")); connection.close(); } else{System.out.print ("No User found");}}