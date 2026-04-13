import java.security.*;
public class java_51913_CredentialValidator_A08 {  
    public boolean validate(String username, String plainTextPassword) throws NoSuchAlgorithmException{    
        // Assuming the input passwords are already hashed using SHA-256        
          MessageDigest digest = MessageDigest.getInstance("SHA-256"); 
           byte[] hashBytes = digest.digest(plainTextPassword.getBytes());   
            StringBuilder sb = new StringBuilder();  
             for (int i = 0; i < hashBytes.length; ++i) {    
                 sb.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));   
            }      
           String generatedPassword = sb.toString();  
          // Comparing the stored password with plain text version of inputted (hashed!) password       
         return username != null && username.equals("admin") &&generatedPassword .equals("5baa61e4c9b93f3f0682250b6cf8331b7ee68b98b6d1d8a9c4bd7492ff2de8");
    }  
}