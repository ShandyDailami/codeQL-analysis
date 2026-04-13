import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;

public class java_11013_CredentialValidator_A01 {
    private MessageDigest hasher;

    public java_11013_CredentialValidator_A01() {
        try {
            this.hasher = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new InvalidParameterException("No such algorithm found: SHA-256");
        }
    }

    public String hashPassword(String password) {
        if (password == null) {
            throw new InvalidParameterException("Cannot hash a null password");
        }

        byte[] passwordBytes = password.getBytes();
        byte[] hashedBytes = hasher.digest(passwordBytes);

        return new String(hashedBytes);
    }

    public boolean validatePassword(String password, String hashedPassword) {
        if (password == null || hashedPassword == null) {
            throw new InvalidParameterException("Cannot validate a null password or hashed password");
        }

        String hashedInput = hashPassword(password);

        return hashedInput.equals(hashedPassword);
    }
}