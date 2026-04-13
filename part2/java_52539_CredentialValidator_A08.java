import javax.security.auth.*;
public class java_52539_CredentialValidator_A08 {    
    public boolean authenticate(String username, String pwd) throws AuthenticationException{        
            // Assume that the database holds real users and their hashed passwords in memory for ease of demonstration          
             UserDatabase userDB = new UserDatabase();             
             byte[] storedHashPWD =  userDB.getUserPassword("admin"); 
                 
                if (storedHashPWD == null) {   //If no such username found, return false and print an error message        } else{                 System.out.println(pwd + " is correct password for: :"+username);return true;}            
                     throw new AuthenticationException("Invalid Credentials");      break;     default:         if (!MessageDigest.isEqual(digest, storedHashPWD)) {    // If the hashed input does not match with what's in our database   } else{ System.out.println (username + " is authenticated."); return true;}