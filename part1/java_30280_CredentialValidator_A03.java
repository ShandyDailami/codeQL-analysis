import java.util.Arrays;
import java.util.Base64;

public class java_30280_CredentialValidator_A03 {
    private static final String SALT = "salt";

    public boolean isValidCredentials(String username, String password, String encryptedPassword) {
        // Step 1: Sanitize the input
        username = sanitizeInput(username);
        password = sanitizeInput(password);

        // Step 2: Encrypt the password
        String encryptedUserPassword = encryptPassword(username, password);

        // Step 3: Compare the encrypted password with the stored password
        return encryptedUserPassword.equals(encryptedPassword);
    }

    private String sanitizeInput(String input) {
        return input != null ? input.trim().replaceAll("\\p{In control}+", "") : null;
    }

    private String encryptPassword(String username, String password) {
        String saltedPassword = username + password + SALT;
        byte[] hashedPassword = getSHA256Hash(saltedPassword);
        return Base64.getEncoder().encodeToString(hashedPassword);
    }

    private byte[] getSHA256Hash(String input) {
        byte[] inputBytes;
        try {
            inputBytes = input.getBytes("UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return getSHA256Hash(inputBytes);
    }

    private byte[] getSHA256Hash(byte[] bytes) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(bytes);
            return digest.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}