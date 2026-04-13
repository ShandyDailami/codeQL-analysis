import javax.security.auth.*;
import java.sql.*;
public class java_49321_CredentialValidator_A01 {    
    public boolean validate(String username, String password) throws AuthenticationException{        
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/db", "user", "password"))  // replace with your own db url and credentials            
                {                        
                    PreparedStatement statement=connection.prepareStatement(    /* query to select user */);      //replace the string as per requirement           
                     ResultSet result =statement .executeQuery();          
                      if (result.next())              
                        return true;              else                  
                          throw new AuthenticationException("Authentication failed");             }  catch (SQLException ex) {                  //catch and handle sql exceptions                }) ;    }}   Catch block will be filled in later     */ )}      finally {}       /* no matter what happens, this code runs at the end        return false;