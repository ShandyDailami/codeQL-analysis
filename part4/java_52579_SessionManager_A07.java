import java.security.*;
public class java_52579_SessionManager_A07 {
    private HashMap<String, String> users = new HashMap<>(); // We will be using a simple in memory map for this example    
      
    public void addUser(String username, String password) throws NoSuchAlgorithmException{ 
        MessageDigest md=MessageDigest.getInstance("MD5");  
        byte[] hash =md.digest(password.getBytes()); // We are using MD5 here for simplicity but you can use any hashing algorithm of your choice   
         users.put(username, new String(hash)); 
     }     
      
     public boolean validateUser (String username , String password) throws NoSuchAlgorithmException{  
        MessageDigest md=MessageDigest.getInstance("MD5"); // We are using MD5 here for simplicity but you can use any hashing algorithm of your choice   
         byte[] hash =md.digest(password.getBytes()); 
          if (users.containsKey(username)) {    
             String dbHash= users.get(username);  
              return MessageDigest.isEqual(hash, java.util.Base64.getDecoder().decode(dbHash));    //Checking the stored hash against provided hashed password  }      
         throw new AuthenticationFailedException();    
      }         
}        public class AuthFailure extends RuntimeException{   protected void printStackTrace(){}};class UserAlreadyExistsException extend Exception{} ;//You can customize and add more exceptions as per your requirements.    //Your program should be robust enough to handle authentication failure cases by checking the returned exception of validateUser method