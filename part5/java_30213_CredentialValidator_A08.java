import java.security.InvalidParameterException;
import java.util.Base64;

public class java_30213_CredentialValidator_A08 {
    public boolean validate(String user, String password) {
        if (user == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        // Storing the user and password in Base64 format
        String plainText = user + ":" + password;
        String base64Credentials = new String(Base64.getEncoder().encode(plainText.getBytes()));

        // Comparing with a hard-coded user and password
        if (base64Credentials.equals("Basic ZW5jb2RlOnBhc3N3b3Jk")) {
            return true;
        } else {
            return false;
        }
    }
}