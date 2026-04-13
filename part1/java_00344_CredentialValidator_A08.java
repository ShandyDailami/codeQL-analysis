import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_00344_CredentialValidator_A08 {

    public static boolean validateCredentials(String username, String password) {
        // This is a dummy validation. In real world, passwords should be hashed and compared against a hash
        // For simplicity, we will just compare the password with a hardcoded value
        return password.equals("password");
    }

    public static void main(String[] args) {
        String username = "user";
        String password = "password";

        if (validateCredentials(username, password)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}