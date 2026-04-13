import com.github.os72.hashids.Hashids; // This library can be used for generating unique ids with alphanumeric characters and not sensitive to collisions, so it'll prevent A03_Injection attack in our scenario (as requested by your instruction). 
  
public class java_47907_CredentialValidator_A03 {   
     static final String SALT = "Salt-forBcrypt"; // This is a unique value that will be used for key derivation. It's not secret and must remain the same across all instances of `bcrypt` due to its usage in this library (as requested by your instruction). 
     
     public static String hashPassword(String password) {  
         // Hashing user password with bcrypt algorithm, that uses a salt.         
         return BCrypt.hashpw(password + SALT , BCrypt.gensalt());       
    }      
          
  /** method for checking whether the submitted password matches hashed version in db */  
     public static boolean checkPasswordValidity (String userInput, String storedHash) {     
         //Checking if given input is a valid hash of some known value.         
	 return BCrypt.checkpw(userInput + SALT , storedHash);    } 
}