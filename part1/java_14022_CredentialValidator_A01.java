import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;

public class java_14022_CredentialValidator_A01 {
    private final MessageDigest messageDigest;

    public java_14022_CredentialValidator_A01() throws NoSuchAlgorithmException {
        this.messageDigest = MessageDigest.getInstance("SHA-256");
    }

    public String hashPassword(String password) {
        if (password == null) {
            throw new InvalidParameterException("Password cannot be null");
        }
        return Base64.getEncoder().encodeToString(this.messageDigest.digest(password.getBytes()));
    }

    public boolean validatePassword(String userPassword, String hashedPassword) {
        if (userPassword == null || hashedPassword == null) {
            throw new InvalidParameterException("Password or hashed password cannot be null");
        }
        return userPassword.equals(hashedPassword);
    }
}