import java.util.HashMap;
import java.util.Map;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger;

public class java_14890_CredentialValidator_A08 {

    private Map<String, String> userCredentials;

    public java_14890_CredentialValidator_A08() {
        this.userCredentials = new HashMap<>();
        this.userCredentials.put("user1", this.hashPassword("password1"));
        this.userCredentials.put("user2", this.hashPassword("password2"));
        // Add more users as needed
    }

    public boolean validateCredentials(String username, String password) {
        String hashedPassword = this.hashPassword(password);
        return hashedPassword.equals(this.userCredentials.get(username));
    }

    private String hashPassword(String password) {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(password.getBytes(StandardCharsets.UTF_8));
        return new BigInteger(1, digest).toString(16);
    }
}