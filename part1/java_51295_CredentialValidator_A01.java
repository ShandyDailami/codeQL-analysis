import java.security.*;   // Import crypto classes (MessageDigest) and general class java_51295_CredentialValidator_A01 
// This is necessary because we're going into low-level security topics such as implementing secure hash functions, message digests etc using the standard Java libraries only without a full framework/library suite like Spring or Hibernate.   
  
public class CredentialValidator {     // The main object of this program       
  public static void main(String[] args) throws NoSuchAlgorithmException     
// We'll use SHA-256 for hashing passwords and to generate a secure hash code        
{         
   String username = "exampleuser";   
 // Here we assume that the input is always valid (no user will provide invalid data, such as an empty string or null).     The real application should validate inputs.     
        byte[] hashedPassword;            
       MessageDigest messageDigest =  MessageDigest.getInstance("SHA-256");         // Creating a SHA 2 instance          
  
    /* We need to digest the password into bytes, because we're going for security here */     
        byte[] usernameBytes = username.getBytes();    
       messageDigest.update(usernameBytes);             
          hashedPassword =  messageDigest.digest();         // Getting a secure hash of user input (password)               
   /* Now, we want to check if the given password matches this secured one */     
        String providedInput = "examplepass";          
       MessageDigest digestForComparison  = MessageDigest.getInstance("SHA-256");         // Creating another instance for comparison         
  digitForComparisonBytes =  username + (char)1 ;              // Adds a random character to the password    */     
        byte[] providedInputHash =   digestForComparison .digest(providedInput.getBytes());     /* Calculating hash of input again here*/        
       if (MessageDigest.isEqual(hashedPassword,  providedInputHash))          // Now comparing hashes to see them match            {           return true;        } else                            {              System . out . println ("Invalid credentials");                   return false;}                     };    });      catch (Exception e)  
{       /* Handle exceptions as needed */     throw new SecurityException(e);  }}                // Providing a meaningful exception message         Console.error("Unable to load crypto, check your JVM.");           }}}                  Importing all the required class files and objects in CredentialValidator is necessary for this example program