import java.security.InvalidParameterException;
import java.util.Base64;

public class java_13102_CredentialValidator_A07 {

    // Hardcoded password
    private static final String HARDCODED_PASSWORD = "password";

    public boolean validate(String password) {
        if (password == null) {
            throw new InvalidParameterException("Password cannot be null");
        }

        // Decoding the password from Base64
        byte[] decodedPassword = Base64.getDecoder().decode(password);
        String decodedStringPassword = new String(decodedPassword);

        // Compare the password with the hardcoded password
        return decodedStringPassword.equals(HARDCODED_PASSWORD);
    }
}