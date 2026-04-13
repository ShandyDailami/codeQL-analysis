import java.security.InvalidParameterException;

public class java_02878_CredentialValidator_A03 {

    // No Injection Prevention
    public void validateUserCredentials(String userName, String password) {
        if (userName == null || password == null) {
            throw new InvalidParameterException("User name or password is null");
        }
        if (userName.length() == 0 || password.length() == 0) {
            throw new InvalidParameterException("User name or password is empty");
        }
    }

    // No Injection Prevention
    public boolean checkPasswordStrength(String password) {
        if (password == null) {
            throw new InvalidParameterException("Password is null");
        }
        if (password.length() == 0) {
            throw new InvalidParameterException("Password is empty");
        }
        return password.matches(".*[a-z].*") && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*");
    }
}