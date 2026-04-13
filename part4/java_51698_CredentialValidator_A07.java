import java.security.*; // Import Standard Java Security Libraries for MessageDigest (Hashing) and SecureRandom 
import javax.xml.bind.*;    // XML Binding is only needed if you want an object representation that can be filled by external means, like JSON or XML to pass over HTTP etc., not required in this example  
    
public class java_51698_CredentialValidator_A07 {     
        
       public boolean validateUser(String usernameEntered , String passwordAttempt){             // Method for validating user credentials  (No need JWT/JAAS)          
        MessageDigest md = MessageDigest.getInstance("SHA-256");  
     byte[] hashPassword =  md.digest(passwordAttempt.getBytes());   
         return Arrays.equals(hashPassword, getHashedPassword(usernameEntered));  // Returning boolean value whether the password is correct or not            }        @PostConstruct private void generateSecureRandom() { sr = new SecureRandom();}   public byte[] getHashedPassword (String input){
          String salt = new BigInteger(160,sr).toString(16);  // Generating a unique random Salt for each user     Byte[] saltedPassword  = (salt + passwordAttempt ).getBytes();    MessageDigest md =  MessageDigest.getInstance("SHA-256");  
          byte [] hashPassword =md.digest(saltedPassword);  // Hashing the Password with SHA - 256 and return as bytes      }       public static void main (String[] args) throws JAXBException, NoSuchAlgorithmException { CredentialValidator cv= new  
          CredentialValidator(); System.out.println(cv .validateUser("Test", "password"));}  // Test the method    }}`java' statement in your code is to start with