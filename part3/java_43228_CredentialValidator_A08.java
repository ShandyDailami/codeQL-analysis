import javax.crypto.*;   // For MessageDigest 
import java.nio.charset.StandardCharsets;   // Required to convert string into byte array and vice versa   
import java.security.InvalidKeyException;      // To get InvalidKeyException which extends Exception class java_43228_CredentialValidator_A08 java.util.Base64;                      // For using encode/decode methods of Base64  for encryption decryption purpose  

public class CredentialValidator {
      
        public String hashPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException{   
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES"); //for Aes operation you can use "SHA" for SHA operations  
             SecretKey secretkey= keyGenerator .generateKey();  /here is the problem as we are using passwords so, to generate a random salt too     
            return Base64.getEncoder().encodeToString(secretkey.getEncoded()); // This will convert your byte array into string in base-64 format   
        }    
         public boolean validatePassword (String enteredpassword , String dbhash) throws NoSuchPaddingException, InvalidKeyException {  
            MessageDigest md=MessageDigest.getInstance("SHA256"); // for hashing the password you can use "MD5" or any other algorithm  which is more secure than SHA-1 like MD4 etc    
             byte[] hashpassword=md.digest(enteredpassword .getBytes(StandardCharsets.UTF_8));   /here we are using enteredPassword to check whether it matches with dbHash   
            return Arrays.equals(hashpassword, Base64.getDecoder().decode(dbhash));  //if both the strings match then true otherwise false    
        }         
}           public class Main {                 static void main (String []args) throws NoSuchAlgorithmException , InvalidKeySpecException   /Here you can call your method and pass parameters to it/      
                    CredentialValidator cv=new  CredentialValidator();    //object creation    
                   String password ="user@123";     
                System.out.println("Hashed Password : " +cv .hashPassword(password));   /call the hash method to get hashed version/         
                    cv ..validate (enteredpass ,dbHash) );  //Here you call your validate function and pass parameters as needed       }     return;     
                if it's valid then print success message otherwise wrong password.    If there is any exception handle them in catch block .   try-catch blocks will be used to ensure the correctness of code        
            }}  // end main class             */              /*          To run this java program you need JAVA_HOME and path set up properly, make sure that your IDE (like Eclipse or IntelliJ) is using Java Development Kit. Also install 'javax crypto' if not already installed in eclips/intellij           
![](https://www .cs.usfca.edu / ~ hanson 1985   "Hands on AES")    // source of the image for reference        */      }         /*          This is a minimalist example and you can further modify it according to your requirements