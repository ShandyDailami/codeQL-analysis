import java.security.InvalidParameterException;
import java.util.Base64;

public class java_31616_CredentialValidator_A08 {

    public boolean isValidPassword(String password) {
        if (password == null) {
            throw new InvalidParameterException("Password cannot be null");
        }
        if (password.length() < 8) {
            throw new InvalidParameterException("Password must be at least 8 characters long");
        }
        if (!password.matches(".*[0-9].*")) {
            throw new InvalidParameterException("Password must contain at least one numeric character");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new InvalidParameterException("Password must contain at least one lowercase character");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new InvalidParameterException("Password must contain at least one uppercase character");
        }
        if (!password.matches(".*[@#$%^&*()_+\-=\{\}\[\]|:;\"'<,>.?\\\\/?].*")) {
            throw new InvalidParameterException("Password must contain at least one special character");
        }
        return true;
    }

    public boolean isValidCredential(String username, String password, String cipherText) {
        if (username == null || password == null || cipherText == null) {
            throw new InvalidParameterException("Credentials cannot be null");
        }
        if (username.length() < 4) {
            throw new InvalidParameterException("Username must be at least 4 characters long");
        }
        if (!username.matches("^[a-zA-Z0-9]*$")) {
            throw new InvalidParameterException("Username must contain only alphanumeric characters");
        }
        byte[] decodedBytes = Base64.getDecoder().decode(cipherText);
        String decodedString = new String(decodedBytes);
        if (!isValidPassword(decodedString)) {
            throw new InvalidParameterException("Decoded password is not valid");
        }
        return true;
    }
}