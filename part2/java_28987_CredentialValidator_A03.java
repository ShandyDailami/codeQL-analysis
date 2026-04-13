import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_28987_CredentialValidator_A03 {

    public boolean validatePassword(String password, String hashedPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashPassword = md.digest(password.getBytes());
            byte[] hashedEnteredPassword = md.digest(hashedPassword.getBytes());
            
            // Compare the two hashed passwords
            return MessageDigest.isEqual(hashPassword, hashedEnteredPassword);
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
       
            // If SHA-256 algorithm is not available, hash password in a different way
            // Then compare the passwords directly
            // ...
            return password.equals(hashedPassword);
        }
    }
}