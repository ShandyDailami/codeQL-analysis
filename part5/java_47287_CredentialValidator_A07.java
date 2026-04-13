import javax.security.auth.*;
import java.util.Base64;
public class java_47287_CredentialValidator_A07 {  
    public static boolean authenticate(String userName, String password) throws LoginException{    
        if ("admin".equalsIgnoreCase(userName))  // check username and ignore case sensitivity for easy comparison in the next step        
            throw new PasswordRequiredException("Password is required.");     
            
        byte[] decodedBytes = Base64.getDecoder().decode(password);       // base-64 encoding, to provide password with all requirements of java security library  
                                                                 
        String providedPassword = new String (decodedBytes,"UTF-8");    ## get the plain text version because Java Security API doesn't offer decoding functionality        
            
          if(!"password".equalsIgnoreCase(providedPassword))          
              throw new LoginException("Invalid password.");       // check for correct case sensitivity and actual entered value. 
                                                                  
        return true;      ## successful login, no need to ask additional questions anymore so we can let the user know they are authenticated    }     public static void main (String args[]) throws Exception{           String username = "admin";          char[] passwordChars= new char[10]; 
       //password is read as a sequence of characters using keyboard, not displayed in console. You can use any random string here to test the code   for(int i = 0;i < 9 ; ++i)           {        /* there are only nine character available */          passwordChars[i] = 'a';       }        
      // convert char array into String and pass it in authenticate method. This will throw LoginException if username is wrong, PasswordRequired Exception  if no providedPassword   CredentialsAuthenticator.authenticate(username , new String (passwordChars));}