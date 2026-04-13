import java.security.InvalidParameterException;

public class java_24480_CredentialValidator_A08 {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public boolean validate(String password) {
        if (password == null) {
            throw new InvalidParameterException("Password can not be null.");
        }

        if (!password.matches(PASSWORD_PATTERN)) {
            throw new InvalidParameterException("Password is not valid. It must contain at least one numeric digit, one lowercase letter, one uppercase letter, one special character and no whitespace.");
        }

        return true;
    }

}