import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_17415_CredentialValidator_A08 {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%^*?&])[A-Za-z\\d@$!%^*?&]{8,}$");

    public boolean validatePassword(String password) {
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validatePassword("Password123@")); // should print true
        System.out.println(validator.validatePassword("password123@")); // should print false
        System.out.println(validator.validatePassword("PASSWORD123@")); // should print false
        System.out.println(validator.validatePassword("password123")); // should print false
    }
}