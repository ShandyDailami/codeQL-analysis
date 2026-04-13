import java.security.*;   // Import the necessary classes from Security package 

public class java_52339_CredentialValidator_A07 {   
     public boolean validate(String username, String password) throws NoSuchAlgorithmException{     
          MessageDigest md = MessageDigest.getInstance("MD5");// Get an instance of MD5 Hash for hashing  
           
           byte[] thedigest  = md.digest(password.getBytes());  // Hashes Password to a secure hash value (16 bytes = 32 hex characters)   
        
          StringBuilder sb = new StringBuilder();     
       
       /* Append each byte in the digest into string */    
            for(int i=0;i<thedigest.length;i++){   // Loop through hash value  and append it to a hexadecimal format   
                sb.append(Integer.toString((thedigest[i] & 0xff) + 0x100, 16).substring(1));    
            }     
          String securePassword =sb.toString();   // Stores the hashed password into a string   
         System.out.println("Hashed Password : " +securePassword);// Prints out Hashed PassWord for validation purpose only 
        return (password != null && securePassword !=null) ? new PasswordState(checkExpectedPasswordEqualsSecurePassword(username, password)));   // Returns true if the two hashed and expected pass is same else false.   
     }     
}