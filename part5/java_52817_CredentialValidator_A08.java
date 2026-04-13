import java.util.*;  // Importing Hash Map & Arrays Libraries  
public class java_52817_CredentialValidator_A08 {   
     public static boolean validateCredentials(String username, String password) throws Exception{      
         /* Create an empty hash map of usernames and hashed versions */     
           if (username.isEmpty() || password.isEmpty()) throw new IllegalArgumentException("Username or Password is null/empty");  // Ensure both fields are not blank  
          Map<String, String> validUsers = getValidUserCredentials();    /* Get the list of known users */     
           if(validUsers == null) {throw new Exception ("Couldn't load user credentials")};      
         boolean isMatchFound= false ;     // flag to check whether username exists in map and match hashes are equal or not  
          for (Map.Entry<String, String> entry : validUsers.entrySet())  {    /* Loop through entries of hashmap */     
              if(username.equalsIgnoreCase((CharSequence) entry.getKey())){     // Checking equality with username from user input      
                  isMatchFound = comparePasswordHashes (password, ((Map<String , String> )entry).getValue());  /* Compare hashed passwords of valid users and entered one */   
                      if(isMatchFound) break;   }                                  else { throw new Exception("Username or Password not found")} ;     // If match is identified then end program      };          return true;}else{return false}                  });  /* Calling the method to validate credentials (should be used in a main function for example purposes only) */