import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;

public class java_11778_CredentialValidator_A01 {
    private static final String STRENGTH_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{8,}$";

    public boolean validatePassword(String password) throws NoSuchAlgorithmException, InvalidParameterException {
        if (password == null) {
            throw new InvalidParameterException("Password cannot be null.");
        }
        
        if (!password.matches(STRENGTH_REGEX)) {
            throw new InvalidParameterException("Password must contain at least one lowercase letter, one uppercase letter, one number, and one special character.");
        }

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());

        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }

        if (sb.toString().equals(password)) {
            throw new InvalidParameterException("Password hashing failed.");
        }

        return true;
    }
}