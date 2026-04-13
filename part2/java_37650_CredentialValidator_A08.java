import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class java_37650_CredentialValidator_A08 {

    private static final String SALT = "salt";
    private static final String ALGORITHM = "SHA-256";
    private static final int MIN_PASSWORD_LENGTH = 8;

    public boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }

        if (password.matches(".*\\d.*")) {
            return false;
        }

        if (password.matches(".*[A-Z].*")) {
            return false;
        }

        return true;
    }

    public String hashPassword(String password) throws NoSuchAlgorithmException {
        if (!isValidPassword(password)) {
            throw new IllegalArgumentException("Password is not valid");
        }

        MessageDigest md = MessageDigest.getInstance(ALGORITHM);
        md.update(SALT.getBytes());
        byte[] bytes = md.digest(password.getBytes());

        return Base64.getEncoder().encodeToString(bytes);
    }
}