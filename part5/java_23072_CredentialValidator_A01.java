import java.util.Base64;
import java.util.Base64.Decoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class java_23072_CredentialValidator_A01 {
    private Map<String, String> users;
    private MessageDigest md;

    public java_23072_CredentialValidator_A01() {
        users = new HashMap<>();

        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        // Adding users to the system
        addUser("user1", "password1");
        addUser("user2", "password2");
    }

    public boolean validateCredentials(String user, String password) {
        String hashedPassword = getHashedPassword(password);

        return users.containsKey(user) && users.get(user).equals(hashedPassword);
    }

    private void addUser(String user, String password) {
        String hashedPassword = getHashedPassword(password);
        users.put(user, hashedPassword);
    }

    private String getHashedPassword(String password) {
        byte[] hashByte = md.digest(password.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hashByte);
    }
}