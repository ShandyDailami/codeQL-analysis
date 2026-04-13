import java.security.*;   // Import Java Security Provider (JCE) classes, which include the MessageDigest and KeyPairGenerator class's functionality in addition as these are used below for password hashing/salting etc..   
public interface CredentialValidator {    
 public boolean validate(String usernameParameter , String passwordAttempt);   //method to check if user credentials match.  Returns true or false based on validations (e.g., hash, encryption) performed by the implementation class java_43664_CredentialValidator_A03 successful login attempt      
}