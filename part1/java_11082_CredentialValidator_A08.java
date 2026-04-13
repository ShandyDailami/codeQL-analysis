import java.util.regex.Pattern;

public class java_11082_CredentialValidator_A08 {

    // Regex for password validation
    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%^*?&])[A-Za-z\\d@$!%^*?&]{8,}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }

        return pattern.matcher(password).matches();
    }
}