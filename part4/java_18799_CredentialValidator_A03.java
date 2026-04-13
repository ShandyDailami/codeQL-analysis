import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_18799_CredentialValidator_A03 {

    private final String hardcodedUsername;
    private final String hardcodedPassword;

    public java_18799_CredentialValidator_A03(String hardcodedUsername, String hardcodedPassword) {
        this.hardcodedUsername = hardcodedUsername;
        this.hardcodedPassword = hashPassword(hardcodedPassword);
    }

    private String hashPassword(String password) {
        MessageDigest digest;
        byte[] hash;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            hash = digest.digest(password.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException | java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean validate(String username, String password) {
        return username.equals(hardcodedUsername) && hashPassword(password).equals(hardcodedPassword);
    }
}