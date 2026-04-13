import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;
import java.util.Base64;

public class java_37075_CredentialValidator_A03 implements CredentialValidator {
    private MessageDigest messageDigest;

    public java_37075_CredentialValidator_A03() {
        try {
            this.messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new InvalidParameterException("SHA-256 algorithm not supported.");
        }
    }

    @Override
    public boolean validate(String username, String password) {
        byte[] passwordBytes = password.getBytes();
        byte[] hashedPasswordBytes = messageDigest.digest(passwordBytes);
        String hashedPassword = Base64.getEncoder().encodeToString(hashedPasswordBytes);

        return hashedPassword.equals(username);
    }
}