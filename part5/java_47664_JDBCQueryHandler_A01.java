import java.sql.*; // Import the necessary classes from JDBC library
class java_47664_JDBCQueryHandler_A01 {  
    public static void main(String[] args) throws SQLException{    
        String url = "jdbc:mysql://localhost/mydatabase";  /*<-- Replace with your actual database URL */      
        String username="root", password="password";         // <-- replace these values if you have a different user and pass.  
                                                                                 
        try (Connection connection =  DriverManager.getConnection(url,username ,password)){      /*<--- Try-with Resource will automatically close the resources*/      
            System.out.println("Connected to database!");  // If connected successfully it prints this line   
             
             String selectQuery = "SELECT username FROM users WHERE password=?";  
               try (PreparedStatement pstmt =  connection.prepareStatement(selectQuery)){     /*<-- Prepare Statement for SQL injection protection*/      
                pstmt.setString(1,"password");  // Set the parameter value here, you can use any logic based on your requirement   
                 ResultSet rs =pstmt .executeQuery();      // Execute a query and store into result set  
                  if (rs.next()) {                        /*<--- If user found */      
                      String username= rs.getString("username");  // Get the value from column 'password'   
                       System.out.println(username);           // Print out the retrieved password which is equal to your input  
                  }else{                                    // <-- if no users match, it will not print anything so you can handle this condition according how required in project        
                      System.out.println("User Not Found");     /*<--- User not found */      
               }}  catch (Exception e){                   // Catch block for exception handling   }      DriverManager is a class that connects Java application with MySQL database, PreparedStatement and ResultSet are interfaces provided by the java sql package which allow you to safely execute SQL statements. These classes provide protection against code injection attacks on your behalf via parameter substitution wherever necessary using set methods or similar mechanisms within these packages (for example 'pstmt.' in above examples).
            }catch(Exception e){                          // Catch block for exception handling    System out and println are used to display messages.  Exception is the parent class of all exceptions, we use it as a catch-all when none specific errors match or if there's an error at runtime then our program will not crash but instead proceed with next line(es).
        }         // End Try block     System out and println are used to display messages.  Exception is the parent class of all exceptions, we use it as a catch-all when none specific errors match or if there's an error at runtime then our program will not crash but instead proceed with next line(es).
    }// End main method   This whole block encapsulates entire application and connection to database. It starts the app in try/catch blocks, handles exceptions internally by catch-all statement after each operation or if any part of it fails then control goes back outside this scope so that we can provide appropriate error message(s) with code snippet provided above (c).
}// End Main class encapsulation.   This whole block is responsible for starting the application and establishing a connection to database in Java through JDBC library or any other java based solution ie., spring data jpa, hibernate etc can be used according choice of requirement also this code snippet should not really work on real systems due security reasons.