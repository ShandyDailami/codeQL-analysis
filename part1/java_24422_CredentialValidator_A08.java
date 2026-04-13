import java.security.Credential;
import java.security.InvalidParameterException;

public class java_24422_CredentialValidator_A08 {
    public static boolean validate(Credential credential) {
        if (credential == null) {
            throw new InvalidParameterException("Credential cannot be null");
        }
        
        String password = credential.getPassword();
        if (password == null || password.length() == 0) {
            throw new InvalidParameterException("Password cannot be null or empty");
        }
        
        // Replace this with the actual validation logic.
        // For the sake of simplicity, we'll assume the password is valid if it's at least 8 characters long.
        if (password.length() < 8) {
            return false;
        }
        
        return true;
    }
}