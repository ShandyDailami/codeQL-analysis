import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;

public class java_05519_CredentialValidator_A08 {

    // Pre-defined password hash
    private String preDefinedHash = "$2a$10$";

    // Method to validate the password
    public boolean validatePassword(String password) {
        if (password == null) {
            throw new InvalidParameterException("Password is null");
        }
        try {
            // Create a MessageDigest instance for SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // Add password bytes to digest
            md.update(password.getBytes());

            // Get the hash's bytes
            byte[] bytes = md.digest();

            // Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            // Get complete hashed password
            String hashedPassword = sb.toString();

            // Compare the two hashed passwords
            return hashedPassword.equals(this.preDefinedHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }
}