import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;

public class java_39258_CredentialValidator_A08 {

    public static boolean validate(String password, String hash, String salt) throws NoSuchAlgorithmException, InvalidParameterException {
        // Create a SHA-256 instance
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // Concatenate password and salt (to prevent rainbow table attacks)
        md.update(password.getBytes());
        md.update(salt.getBytes());

        // Get the hash of the password and the salt
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();

        // Convert bytes to hexadecimal
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        // Compare the hash of the password with the stored hash
        String storedHash = sb.toString();

        return storedHash.equals(hash);
    }
}