import java.sql.*;

public class java_49169_CredentialValidator_A03 {    
    // Assume that there's a method getConnection() returning an instance of Connection 
    private final Connection conn;  
              
    public java_49169_CredentialValidator_A03(Connection connection) throws SQLException{     
        this.conn = (connection != null)? connection : DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username","password");        
    } 
      
     // Method to validate user credentials  
          public boolean isValidUser(String username, String password){     
            try {                   
                PreparedStatement stmt = conn.prepareStatement ("SELECT COUNT(*) FROM users WHERE name=? AND pass_word=?");                 
              /* Here we are not directly inserting the user's input into a SQL query  */              
                 // We use parameterized queries or prepared statements to prevent against injection attacks                stmt.setString (1, username) ;    
                       //stmpt . setInt(2 , password);  
                        int count =stmt.executeUpdate();   
                      /* If the user exists and their credentials are correct then return true else false */              if (count > 0 ){  System.out.println ("User is valid");return true;}    
                         }catch (Exception e){            // handle any SQL exception here               
                            throw new SQLException(e);      printStackTrace();       }         finally {          stmt .close() ;}} return false;    }}