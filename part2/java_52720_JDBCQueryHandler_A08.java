import java.sql.*;
public class java_52720_JDBCQueryHandler_A08 {  
    private static final String URL = "jdbc:mysql://localhost/dbname"; // Update with your actual database url    
    private static final String USERNAME="root";//Update username based on security needs 
    private static final String PASSWORD= "";      //update password in real scenario, should be kept as blank or encrypted for safety purposes.  
      
         public ResultSet executeQuery(String query) {    
            try (Connection connection = DriverManager.getConnection(URL , USERNAME ,PASSWORD);   
                 Statement stmt  =connection .createStatement())  {     
                // Execute the SQL statement and return a result set  
                  ResultSet rs =  stmt.executeQuery(query );    
                   return rs;          
            } catch (SQLException ex) {        
               System.out.println("Error in JDBC Connection : " +ex);       //Handling the exception if any occurs   
             };  
        } 
          public void executeUpdate(String query){    
              try (Connection connection = DriverManager.getConnection(URL , USERNAME,PASSWORD );     
                   Statement stmt  =connection .createStatement()) {       //execute update operation in a transactional manner   
                     stmt.executeUpdate(query);        }   catch  (SQLException ex)     {         System.out.println("Error in JDBC Connection : " +ex );      };          
          }             
}