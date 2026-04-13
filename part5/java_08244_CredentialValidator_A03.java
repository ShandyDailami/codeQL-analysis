import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class java_08244_CredentialValidator_A03 {
    private Map<String, String> credentials;

    public java_08244_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] hash = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        this.credentials.put(username, sb.toString());
    }

    public boolean validateCredentials(String username, String password) {
        if (!this.credentials.containsKey(username)) {
            return false;
        }

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] hash = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        String expectedHash = this.credentials.get(username);
        return sb.toString().equals(expectedHash);
    }
}