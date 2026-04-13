import java.util.regex.Pattern;

public class java_34138_CredentialValidator_A03 {

    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");

    public boolean isValidUsername(String username) {
        return USERNAME_PATTERN.matcher(username).matches();
    }

    public boolean isValidPassword(String password) {
        return password != null && password.length() >= 8;
    }

    public boolean validateCredentials(String username, String password) {
        return isValidUsername(username) && isValidPassword(password);
    }

}