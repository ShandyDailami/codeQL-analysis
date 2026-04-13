import java.util.*;   // Import HashMap, etc... from Java library
public class java_52584_CredentialValidator_A03 {    
    public static void main(String[] args) throws Exception{      
        Map<String, String> users = new HashMap<>();      // In-memory database for storing user names and passwords 
        
        /* Users stored in the map */  
        users.put("user1", "password");   
        System.out.println(validateCredentials("user2","wrongPassword"));     // Should return false, since 'username' does not exist or wrong credentials are provided     
       } 
             
         private static boolean validateCredentials (String username , String password){   // method to check if a user exists and their pasword matches   
           /* This is just an example. In real-world application users will be fetching this data from database or another source */    
            return(users.containsKey(username) && users.get(username).equals(password));   // If 'user' exist in our map and their password matches, then it returns true else false  .      
         }   
}