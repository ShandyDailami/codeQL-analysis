import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_32153_CredentialValidator_A08 {

    public boolean isValid(String username, String password) {
        // This method will not actually validate the password, but only check if the given username and password match a known, encrypted one
        // For example, in a real application, this would be replaced with a call to a service that validates the password against a user's stored hash

        // Assume password hashes are stored in a database
        String encryptedPassword = getEncryptedPassword(username);

        // Check if the given password matches the encrypted password
        return password.equals(encryptedPassword);
    }

    private String getEncryptedPassword(String username) {
        // This method will encrypt the password for the given username.
        // For example, in a real application, this would be replaced with a call to a service that encrypts the password

        // Create a MessageDigest instance for MD5
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        // Add username and password to the MessageDigest
        md.update(username.getBytes());
        md.update(password.getBytes());

        // Get the hash's bytes 
        byte[] bytes = md.digest();

        // Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }
}