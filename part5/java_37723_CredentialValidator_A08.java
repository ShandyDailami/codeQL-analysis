import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Base64;

public class java_37723_CredentialValidator_A08 {
    private Map<String, String> users;
    private MessageDigest digest;

    public java_37723_CredentialValidator_A08() {
        users = new HashMap<>();
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public void addUser(String username, String password) {
        String hashedPassword = hashPassword(password);
        users.put(username, hashedPassword);
    }

    public boolean validateUser(String username, String password) {
        String hashedPassword = hashPassword(password);
        return users.containsKey(username) && hashedPassword.equals(users.get(username));
    }

    private String hashPassword(String password) {
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hash);
    }
}