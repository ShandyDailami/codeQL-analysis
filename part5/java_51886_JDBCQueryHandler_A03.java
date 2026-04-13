import java.sql.*;   // Import required Java libraries    
public class java_51886_JDBCQueryHandler_A03 {    // Begin of the program block      
    public static void main(String[] args)        // Define our entry point method        
{         
 String url = "jdbc:mysql://localhost/test";  /* Use your database URL */            
   final String USERNAME="root", PASSWORD="password12345!";     /// Your MySQL username and password     
          
    try(Connection connection =  DriverManager.getConnection(url,USERNAME ,PASSWORD)){       // Establish a Connection       
         System.out.println("Connected to database");          /* Successful Database Connections */            
                String selectSQL = "SELECT USER_ID FROM Users WHERE USERNAME= ?";      /// Your SQL statement          
            PreparedStatement preparedStatement  = connection .prepareStatement(selectSQL);        // Creating a Statement      
                 int userId = 102456789 ;         /* Value to be inserted in the query */         
             java.sql.Timestamp timestamp = new java.sql.Timestamp((new java.util.Date()).getTime());     /// Current Timestamp       
                   preparedStatement .setInt(1, userId);      // Setting value for '?' parameter      
            System.out.println("User ID: " +userId+ ", Time Stamp :"  +timestamp );          /* Printing the statement */            
               boolean executeResult =   (Boolean)preparedStatement  .executeUpdate();     /// Executed Update        // Execute and get result as Boolean type     
            if(executeResult == true){         /**** Successfully Updated in Database. ****/      
                System.out.println("User updated successfully.");             /* User data has been saved */               }              else{                  Println ("Error updating user");}     return;    // End of the program block            }}  catch (SQLException e) {e .printStackTrace();}}