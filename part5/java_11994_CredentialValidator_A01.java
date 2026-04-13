import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_11994_CredentialValidator_A01 {

    private Map<String, String> users = new HashMap<>();

    public java_11994_CredentialValidator_A01() {
        users.put("admin", getEncodedPassword("admin"));
        users.put("user", getEncodedPassword("user"));
    }

    public boolean validate(String username, String password) {
        String encodedPassword = getEncodedPassword(password);
        return users.get(username).equals(encodedPassword);
    }

    private String getEncodedPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return Base64.getEncoder().encodeToString(md.digest(password.getBytes()));
    }
}