import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Base64;

public class java_06488_CredentialValidator_A01 {
    private static final String CORRECT_USERNAME = "user";
    private static final String CORRECT_PASSWORD = "password";

    public boolean validate(String username, String password) {
        if (isCorrectCredentials(username, password)) {
            return true;
        } else {
            throw new InvalidParameterException("Invalid credentials");
        }
    }

    private boolean isCorrectCredentials(String username, String password) {
        return Arrays.equals(getCredentials(username), getCredentials(password));
    }

    private byte[] getCredentials(String user) {
        return Base64.getEncoder().encode((user + ":secret").getBytes());
    }

    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();

        try {
            validator.validate("user", "password"); // valid credentials
            validator.validate("wrong_username", "wrong_password"); // invalid credentials
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        }
    }
}