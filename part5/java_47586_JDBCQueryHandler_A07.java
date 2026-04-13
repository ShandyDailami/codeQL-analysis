import java.sql.*;

public class java_47586_JDBCQueryHandler_A07 {
    // Using static credentials for simplicity, you should never use them in real application like this
    private final String DB_USER = "dbuser";  
    private final String DB_PASSWORD  ="password1234567890!"; 
    
    public boolean validateUser(String userNameParam) {     
        try (Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/testdb", "userDBCreds","passDbCreds")){       //replace with your credentials  
            PreparedStatement pstmt =conn.prepareStatement ("SELECT * FROM users WHERE username=?");   
                                                        //Replace 'users' and column name as per database schema 
              pstmt.setString(1, userNameParam );        
             ResultSet rs  =pstmt.executeQuery();         
               if (rs.next()) {                            //If the result set has a next value that means there is an account with this username  
                return true;                               //Return True to indicate validation was successful 
              }                                          
        } catch(SQLException e)                           //In case of any error, print out its message and exit.   
         {                                               
            System.out.println("Error in SQL Query");    
             e.printStackTrace();                       
               return false;                             //Return False to indicate validation failed 
        }                                         
           throw new RuntimeException("Unable to execute query",e);   //Throw a runtime exception if something goes wrong with DB operations   
      }                                                   
}