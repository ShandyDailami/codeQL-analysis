import java.security.InvalidParameterException;

public class java_38162_CredentialValidator_A08 {

    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public boolean isPasswordValid(String password) {
        if (password == null || password.length() < MIN_PASSWORD_LENGTH) {
            throw new InvalidParameterException("Password must be at least " + MIN_PASSWORD_LENGTH + " characters long.");
        }

        for (char c : password.toCharArray()) {
            if (!ALLOWED_CHARACTERS.contains(c + "")) {
                throw new InvalidParameterException("Password must contain only characters from " + ALLOWED_CHARACTERS);
            }
        }

        return true;
    }

}