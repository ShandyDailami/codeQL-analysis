import java.util.regex.Pattern;

public class java_09991_CredentialValidator_A03 {

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$");

    public boolean isValidPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new IllegalArgumentException("Password must be at least 8 characters long and contain at least one upper case letter, one lower case letter, and one number");
        }

        return true;
    }

    public boolean isValidUsername(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        if (username.length() < 4) {
            throw new IllegalArgumentException("Username must be at least 4 characters long");
        }

        return true;
    }
}