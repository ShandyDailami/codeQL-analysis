import java.util.regex.Pattern;

public class java_19036_CredentialValidator_A03 {
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9_])[a-zA-Z0-9_]{8,}$");

    public boolean isValidUsername(String username) {
        return USERNAME_PATTERN.matcher(username).matches();
    }

    public boolean isValidPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public boolean validateCredentials(String username, String password) {
        if (!isValidUsername(username)) {
            System.out.println("Invalid username.");
            return false;
        }
        if (!isValidPassword(password)) {
            System.out.println("Invalid password.");
            return false;
        }
        System.out.println("Credentials validated.");
        return true;
    }
}