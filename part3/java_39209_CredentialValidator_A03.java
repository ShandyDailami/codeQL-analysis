import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_39209_CredentialValidator_A03 {

    private String username;
    private String password;

    public java_39209_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to validate the user's password
    public boolean validate() throws NoSuchAlgorithmException {
        // Create a MessageDigest instance for SHA-256
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        // Update the password digest with the username and password
        digest.update(username.getBytes());
        digest.update(password.getBytes());

        // Get the digest bytes
        byte[] bytes = digest.digest();

        // Convert the bytes to a hexadecimal string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        // Convert the hexadecimal string to uppercase
        String hashedPassword = sb.toString().toUpperCase();

        // Compare the hashed password with the stored password
        return hashedPassword.equals(password);
    }
}