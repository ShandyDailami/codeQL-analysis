import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_01213_CredentialValidator_A08 {

    // A method to hash a password
    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    // A method to check if two passwords match
    public boolean checkPassword(String enteredPassword, String hashedPassword) {
        try {
            return hashPassword(enteredPassword).equals(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();
        
        // Let's say we have a valid password
        String password = "valid_password";
        String hashedPassword;
        
        try {
            hashedPassword = validator.hashPassword(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return;
        }
        
        // Checking if the password matches
        if(validator.checkPassword(password, hashedPassword)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Invalid password.");
        }
    }
}