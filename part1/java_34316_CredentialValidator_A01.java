import java.security.InvalidParameterException;

public class java_34316_CredentialValidator_A01 {

    public static final int MIN_PASSWORD_LENGTH = 8;
    public static final int MAX_PASSWORD_LENGTH = 16;

    public static boolean isValidPassword(String password) {
        if (password == null) {
            throw new InvalidParameterException("Password is null");
        }

        if (password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
            return false;
        }

        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                return false;
            }
        }

        return true;
    }

}