import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;

public class java_28131_CredentialValidator_A03 {

    public static boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        try {
            // Create a MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Add password bytes to digest
            md.update(password.getBytes());

            // Get the hash's bytes 
            byte[] bytes = md.digest();

            // Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            // Get complete hashed password in hexadecimal format
            String hashedPassword = sb.toString();

            // Compare with hashed version in database
            if (hashedPassword.equals(passwordInDatabase)) {
                return true;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return false;
    }

    // For testing purpose, password stored in a variable is not available
    private static String passwordInDatabase = "";

    public static void main(String[] args) {
        // Test with valid password
        System.out.println(validate("testUser", "testPassword")); // Should print true

        // Test with invalid password
        System.out.println(validate("testUser", "invalidPassword")); // Should print false
    }
}