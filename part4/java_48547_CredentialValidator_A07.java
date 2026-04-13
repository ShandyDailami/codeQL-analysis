import javax.security.auth.*;
import java.util.Base64;
  
public class java_48547_CredentialValidator_A07 {   
     public static boolean validate(String user, String password) throws AuthenticationException{        
          // Decoding the base-64 string to get username and passsword          
            byte[] decodedBytes = Base64.getDecoder().decode("YOUR_BASE_64_ENCODED_STRING");   
             char [] userCharArray= new String(decodedBytes, StandardCharsets.UTF_8).trim();  // get username  
               password =  new String (Base64.getDecoder().decode((userCharArray)),StandardCharsets.UTF_8);        // decode and trim the base-64 string to obtain passsword        
    
          if( user == null || "".equalsIgnoreCase(user) )  {                
               throw new AuthenticationException("User name is not provided");              return false;             }   else    if ( password==null ||  "".equalsIgnoreCase(password)){                  // Checking the presence and correctness of passsword         
                   throw new AuthenticationException ("Password cannot be null or empty.");  return false;}            String userDB="Admin";              
                    String pwdDB ="Admin@123456".hashPassword();             if (user.equals(userDB) && password . equals(pwdDB)) {return true; }else{ throw new AuthenticationException("Invalid Credentials");  return false;}   }}                   public class MainClass