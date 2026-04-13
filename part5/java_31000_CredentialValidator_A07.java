import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;

public class java_31000_CredentialValidator_A07 {

    private MessageDigest messageDigest;

    public java_31000_CredentialValidator_A07() {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new InvalidParameterException("SHA-256 hashing algorithm not available.", e);
        }
    }

    public String hashPassword(String password) {
        return Base64.getEncoder().encodeToString(messageDigest.digest(password.getBytes()));
    }

    public boolean validatePassword(String password, String hashedPassword) {
        return hashPassword(password).equals(hashedPassword);
    }
}