import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_06064_CredentialValidator_A03 {
    public static boolean validate(String username, String password) {
        // Stored credentials in plain text. In a real application, these should be hashed and stored.
        // For simplicity, these are hashed versions of the string "admin:admin".
        String[] credentials = {"admin:admin"};
        String[] credentialsBase64 = {Base64.getEncoder().encodeToString(credentials[0].getBytes())};
        
        if (credentialsBase64[0].equals(Base64.getEncoder().encodeToString(password.getBytes()))) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(validate("admin", "admin"));  // This should print: true
        System.out.println(validate("wrong", "password"));  // This should print: false
    }
}