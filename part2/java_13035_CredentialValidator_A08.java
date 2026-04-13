import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_13035_CredentialValidator_A08 {

    private static final String[] validCredentials;

    static {
        // Assume we have a pre-defined list of valid credentials
        validCredentials = new String[]{"user1", "password1", "admin"};
    }

    public boolean validate(String username, String password) {
        String hashedPassword = hashPassword(password);
        for (String credential : validCredentials) {
            if (credential.equals(username) && credential.equals(hashedPassword)) {
                return true;
            }
        }
        return false;
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