import java.util.regex.Pattern;

public class java_39331_CredentialValidator_A08 {

    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");

    public boolean validateUsername(String username) {
        return USERNAME_PATTERN.matcher(username).matches();
    }

    public boolean validatePassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public boolean areCredentialsValid(String username, String password) {
        return validateUsername(username) && validatePassword(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.areCredentialsValid("user", "Password@123"));
    }
}