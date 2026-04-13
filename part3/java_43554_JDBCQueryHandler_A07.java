import java.sql.*;   // Import necessary Java packages for JDBC Connection & Statement object creation and handling etc...   
public class java_43554_JDBCQueryHandler_A07 {     // Class name must match with file/classname exactly, else it won't work!                  
 public static void main(String[] args)  {         /* Start of Main method */                                                      
   Connection con = null;        // Declare the connection object to database            
    Statement stmt=null;          // PreparedStatement and ResultSet objects                    
     try{                          // Create a new instance from JDBCConnection             
      Class.forName("com.mysql.cj.jdbc.Driver");   /* We need this driver for the MySQL database */ 
       con = DriverManager.getConnection( "jdbc:mysql://localhost/testdb", "username","password" );          // This connects to our Database                     
      System.out.println("Connected successfully!");        // Prints message if connected successful                    
     }catch (Exception e){                          /* Handles Exception */                           
         println(e);                                  /**Print the exception details*/                                                 
    }                                          // End of try-catch block                        
  con.close();                               // Close connection when it is no longer needed                  
}                                        //Ends main method            
   catch (SQLException ex) {                    /* Handles SQL Exception */                                  
        println(ex);                                    /**Print the exception details*/                                                 
    }                                          /// End of try-catch block                       });  }}           `     end part