import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_24193_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_24193_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        String hashedPassword = hashPassword(password);
        this.credentials.put(username, hashedPassword);
    }

    public boolean isValidCredential(String username, String password) {
        String hashedPassword = hashPassword(password);
        return this.credentials.containsKey(username) &&
                this.credentials.get(username).equals(hashedPassword);
    }

    private String hashPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] hash = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }
}