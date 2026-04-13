import java.security.*;
public class java_47692_CredentialValidator_A07 {  //Replace with your own package if different from default one, e.g., com.example.* or similar  
    public static void main(String[] args) throws NoSuchAlgorithmException{        
        String id = UUID.randomUUID().toString();            //Create a random ID for the user          
       System.out.println("User's Unique Identifier: " +id);          //Print out it  (optional, not required unless you need to log or display)  
      byte[] bytes= id .getBytes(StandardCharsets.UTF_8 );    /*Get the UTF-8 Bytes of Id*/               
       MessageDigest md = MessageDigest.getInstance("SHA3-256");  //Instance SHA for hashing       
          md.update(bytes);      //Update with bytes using specified digest algorithm  
           byte[] digestedBytes=md .digest();     /* Perform the hash and get final Digets */   
         System.out.println("Digestion: " + new String (digestedBytes, StandardCharsets.UTF_8));  ///Print out Hash for user ID as a hexadecimal string   //Optional           
      }         
}