import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.sql.*;
  
public class java_45565_CredentialValidator_A03 {    
    public boolean validate(String username, String password) throws SQLException{        
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/db", "username", "password");  // replace with your db credentials     
              
        PreparedStatement preparedStatement  =connection .prepareStatement ("SELECT * FROM Users WHERE Username=?");  
          
       ResultSet rs =  preparedStatement .executeQuery();        
    while (rs.next()) {            
            String passwordInDB = rs.getString("Password");         
              if(new BCryptPasswordEncoder().matches(password, passwordInDB)){  //compare input with hashed DB Password      return true; } else{return false;}   });     }}