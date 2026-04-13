import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_24782_CredentialValidator_A08 {
    private Map<String, String> users = new HashMap<>();

    public java_24782_CredentialValidator_A08() {
        users.put("user1", "password1"); // You should store the passwords in a secure way.
        users.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        String hashedPassword = hashPassword(password);
        return users.get(username).equals(hashedPassword);
    }

    private String hashPassword(String password) {
        MessageDigest digest;
        byte[] hashBytes;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            hashBytes = digest.digest(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e); // Or handle it as needed.
        }
        return Base64.getEncoder().encodeToString(hashBytes);
    }
}